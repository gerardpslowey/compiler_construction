import java.util.ArrayList;
import java.util.Arrays;

public class SemanticCheckVisitor extends calBaseVisitor<String> {
   
   // Data structures to handle scope, symbols and progFuncs 
   private static String scope;
   SymbolTable symbolTable = new SymbolTable();
   ArrayList<String> progFuncs = new ArrayList<>();

   // Data Types used
   private String bool = "boolean";
	private String integer = "integer";
	private String unknown = "void";
	private String varDecl = "variable";
	private String constDecl = "constant";
   private String function = "function";
   
   private String closingBracket = ")";

   @Override 
   public String visitProg(calParser.ProgContext ctx) { 
      scope = "global";
      
      // Checking if every function has been called
      if (progFuncs.size() != 0) {
         for (String function : progFuncs) {
            System.out.println("Program Error: The function '" + function + "' was declared but never called");
         }
      }
      symbolTable.closeScope();
      return visitChildren(ctx);
   }

   @Override 
   public String visitVar_decl(calParser.Var_declContext ctx) { 
      String id = ctx.ID().getText();
      String type = visit(ctx.type());

      SymbolTableEntry tableEntry = (SymbolTableEntry) symbolTable.get(id);

      // Ensure case insensitivity
      if (id.equalsIgnoreCase(tableEntry.id) & scope.equalsIgnoreCase(tableEntry.scope)) {
         System.out.println("Declare Error: '" + id + "' already declared in " + scope + " scope");
      } 
      
      else {
         symbolTable.put(id, type, varDecl, scope);
      }

      return unknown; 
   }

   @Override 
   public String visitConst_decl(calParser.Const_declContext ctx) { 
		String id = ctx.ID().getText();
		String type = visit(ctx.type());
		String expr = visit(ctx.expression());
		SymbolTableEntry tableEntry = (SymbolTableEntry) symbolTable.get(id);
      
      // Local Scope
      scope = id;
      
      // String to store table tableEntry type
      String eType;

      if(tableEntry.type != "unknown"){
         eType = tableEntry.type;
      } else {
         eType = getType(expr);
      }

		if(id.equalsIgnoreCase(tableEntry.id) && scope.equals(tableEntry.scope)){
			System.out.println("Declare Error: " + id + " declared already in " + scope);
      } else if (expr.equals(unknown)) {
			System.out.println("Declare Error: " + expr + " used before being declared");
		}
      
		if (!type.equals(eType)){				
			System.out.println("Compatibility Error: cannot assign " + type + " to " + expr);
		} else{
			symbolTable.put(id, type, constDecl, scope);
      }
      
		return unknown; 
   }

   @Override 
   public String visitFunction(calParser.FunctionContext ctx) { 
      
      String id = ctx.ID().getText();
      String type = visit(ctx.type());
      
      // Local Scope
      scope = id;

      // Check that ID doesn't already exist
      SymbolTableEntry tableEntry = (SymbolTableEntry) symbolTable.get(id);

      if ((id == tableEntry.id) & (tableEntry.origin == function)) {
         System.out.println("Declare Error: Function cannot be declared more than once");
      }

      // Default value if no value retrieved
      String returnType = unknown;

      // Formatting with LBR and RBR
      String parameters = type + "(";
      String args = visit(ctx.parameter_list());
      parameters = parameters + args + ")";

      // Check if optional argument is included
      if(ctx.getChild(11).getText().equals(closingBracket)){
         String returnValue = visit(ctx.return_expr());
         SymbolTableEntry returnVal = (SymbolTableEntry) symbolTable.get(returnValue);
         returnType = returnVal.type;
      }

      visit(ctx.decl_list());
      visit(ctx.statement_block());

      // if (returnType != type) {
      //    System.out.println("Type Error: Function '" + id + "' must return " + type + " and not " + returnType);
      // }

      symbolTable.put(id, parameters, function, scope);

      // Reset Scope
      scope = "global";

      // Remove function because it was called
      progFuncs.remove(id);
      return unknown;
   }

   @Override 
   public String visitReturn_expr(calParser.Return_exprContext ctx) { 
      return visit(ctx.expression()); 
   }


   @Override 
   public String visitType(calParser.TypeContext ctx) { 
      // Get type from op and match with string
      String type = ctx.op.getText();

      if(type.equalsIgnoreCase("integer")) {
         return integer;
      }

      else if(type.equalsIgnoreCase("boolean")) {
         return bool;
      }

      return unknown;
   }

   @Override
   public String visitNemp_parameter_list(calParser.Nemp_parameter_listContext ctx) { 
      String args = "";
      String id = ctx.ID().getText();
      String type = visit(ctx.type());
      
      SymbolTableEntry tableEntry = (SymbolTableEntry) symbolTable.get(id);
      if(id.equalsIgnoreCase(tableEntry.id) & scope.equals(tableEntry.scope)) {
         System.out.println("Declare Error: Variable " + id + " already declared in " + scope + " scope");
      } else {
         // scope = type
         symbolTable.put(id, type, type, scope);
      } 

      args = args + type;

      // Check if nemp_parameter_list is included
      if(ctx.getChildCount() == 5){
         args = args + ", " + visit(ctx.nemp_parameter_list());
      }

      return args;
   }

   @Override 
   public String visitMain(calParser.MainContext ctx) { 
      // Main scope
      scope = "main";
      // Visit all
      String data = visitChildren(ctx);
      // Reset scope
      scope = "global";

      return data;
   }

   @Override 
   public String visitAssignStm(calParser.AssignStmContext ctx) { 
      
      String thisID = ctx.ID().getText();
      String expr = visit(ctx.expression());

      SymbolTableEntry tableEntry = (SymbolTableEntry) symbolTable.get(thisID);

      // Check if the id existst already
      if (!thisID.equalsIgnoreCase(tableEntry.id)) {
			System.out.println("Assignment Error: Variable (" + thisID + ") must be declared before use");
      }
      
      // Can't assign to a constant
		if (tableEntry.origin.equals(constDecl)) {
			System.out.println("Compatibility Error: Cannot assign to a constant");
      }
      
      // Check for incorrect boolean assignment
      if ( (tableEntry.type.equalsIgnoreCase("boolean")) & !isBoolean(expr)) {
			System.out.println("Compatibility Error: Cannot assign " + expr + " to boolean");
      }
      
		return unknown;
   }

   @Override 
   public String visitParensStm(calParser.ParensStmContext ctx) { 
      
      String id = ctx.ID().getText();
      
      SymbolTableEntry tableEntry = (SymbolTableEntry) symbolTable.get(id);
      if (!id.equals(tableEntry.id)) {
         System.out.println("Function Error: Function (" + id + ") has not been defined");
      }

      int expectedNumArgs = getNumArgs(tableEntry.type);
      String type = tableEntry.type;
            
      String args = visit(ctx.arg_list());
      int numArgs = args.length();

      if(numArgs > 1) {
			args = args.substring(0, numArgs - 1);
      }

      // Format with LBR and RBR
      String params = type + "(" + args + ")";
      // The actual number of arguments presented
      Integer actualNumArgs = getNumArgs(params);

      // Comparing actual and expected number of arguments
      if(expectedNumArgs != actualNumArgs){
         System.out.println("Function Error: Function (" + id + ") expects " + expectedNumArgs + " arguments but got " + actualNumArgs);
      }

      // Comparing each argument type
      ArrayList<String> expectedTypes = argsTypes(tableEntry.type);
      ArrayList<String> actualTypes = argsTypes(params);

      for (int i = 0; i < expectedTypes.size(); i++) {
         String expected = expectedTypes.get(i);
         String actual = actualTypes.get(i);
         if (!expected.equals(actual)) {
            System.out.println("Function Error: Expected type " + expected + " for argument " + i + " but got " + actual);
         }
      }

      // Return function return types
		return returnArgTypes(tableEntry.type);
   }

   @Override 
   public String visitBlockStm(calParser.BlockStmContext ctx) { 
      return visit(ctx.statement_block()); 
   }

   @Override 
   public String visitIfElseStm(calParser.IfElseStmContext ctx) { 
      visit(ctx.condition());
      visit(ctx.statement_block());
      visit(ctx.else_statement());

      return unknown;
   }

   @Override 
   public String visitWhileStm(calParser.WhileStmContext ctx) { 
      visit(ctx.condition());
      visit(ctx.statement_block());

      return unknown;
   }

   @Override 
   public String visitSkipStm(calParser.SkipStmContext ctx) { 
      return unknown; 
   }

   @Override 
   public String visitBinaryOp(calParser.BinaryOpContext ctx) { 

      String left = visit(ctx.frag(0));
      String right = visit(ctx.frag(1));
      
      SymbolTableEntry leftEntry = (SymbolTableEntry) symbolTable.get(left);
      String leftType;

      SymbolTableEntry rightEntry = (SymbolTableEntry) symbolTable.get(right);
      String rightType;

      // Left Type
      if(leftEntry.type == "unknown"){
         leftType = getType(left);
      } 
      else {
         leftType = leftEntry.type;
      }

      // Right Type
      if(rightEntry.type == "unknown"){
         rightType = getType(right);
      } 
      else {
         rightType = rightEntry.type;
      }

      // Check valid comparsion
      if(leftType == integer | rightType == integer){
         return integer;
      } else{
         System.out.println("Compatibility Error: " + left + " is not compatible with " + right);
      }   

		return unknown; 
   }

   @Override 
   public String visitParensOp(calParser.ParensOpContext ctx) { 
      return visit(ctx.expression());
   }

   @Override 
   public String visitArglistOp(calParser.ArglistOpContext ctx) {
      return visit(ctx.arg_list()); 
   }

   @Override 
   public String visitFragOp(calParser.FragOpContext ctx) {
      return visit(ctx.frag()); 
   }

   @Override 
   public String visitNegOp(calParser.NegOpContext ctx) { 
      String id = ctx.ID().getText();
      String posID = getAbsString(id);

      SymbolTableEntry tableEntry = (SymbolTableEntry) symbolTable.get(posID);
      if (!(posID.equals(tableEntry.id))) {
         System.out.println("Declare Error: Variable " + id + " must be declared before first use");
      }

      return id; 
   }

   @Override 
   public String visitNumOP(calParser.NumOPContext ctx) { 
      return ctx.NUMBER().getText();
   }
   
   @Override 
   public String visitTrue(calParser.TrueContext ctx) { 
      return ctx.True().getText();
   }

   @Override 
   public String visitFalse(calParser.FalseContext ctx) { 
      return ctx.False().getText();
   }

   @Override 
   public String visitNegateOp(calParser.NegateOpContext ctx) { 
      return visit(ctx.condition());
   }

   @Override 
   public String visitExprOp(calParser.ExprOpContext ctx) { 
      return visit(ctx.expression()); 
   }

   @Override 
   public String visitParensCondOp(calParser.ParensCondOpContext ctx) { 
      return visit(ctx.condition()); 
   }

   @Override 
   public String visitExprCompOp(calParser.ExprCompOpContext ctx) { 

      String left = visit(ctx.expression(0));
      String right = visit(ctx.expression(1));
      String operator = visit(ctx.comp_op());

      SymbolTableEntry leftEntry = (SymbolTableEntry) symbolTable.get(left);
      String leftType;

		SymbolTableEntry rightEntry = (SymbolTableEntry) symbolTable.get(right);
      String rightType;
      
      // Left Type
      if(leftEntry.type == "unknown"){
         leftType = getType(left);
      } 
      else {
         leftType = leftEntry.type;
      }

      // Right Type
      if(rightEntry.type == "unknown"){
         rightType = getType(right);
      } 
      else {
         rightType = rightEntry.type;
      }

      // Check valid comparsion
      if(leftType == rightType){
         return bool;
      } 
      else {
         System.out.println("Type Error: Cannot compare " + leftType  + " and " + rightType  + " using " + operator);
      }

      return unknown;
   }

   @Override 
   public String visitComp_op(calParser.Comp_opContext ctx) { 
      String operator = ctx.op.getText();
      return operator;
   }

   @Override 
   public String visitCondOp(calParser.CondOpContext ctx) { 
      String leftValue = visit(ctx.condition(0));
      String rightValue = visit(ctx.condition(1));
      String operator = ctx.op.getText();

      if (isBoolean(leftValue) && isBoolean(rightValue)) {
         System.out.println("Compatibility Error: Cannot perform " + operator + " on types " + leftValue + " and " + rightValue);
      }

      return unknown;
   }

   @Override 
   public String visitNemp_arg_list(calParser.Nemp_arg_listContext ctx) { 
      String args = "";

		if(ctx.getChildCount() != 0){
			String id = ctx.ID().getText();
			SymbolTableEntry tableEntry = (SymbolTableEntry) symbolTable.get(id);

         if(!id.equals(tableEntry.id)){
				System.out.println("Declare Error: Variable " + id + " already declared in " + scope + " scope");
         }

      }
      
      // If nemp_arg_list is included
		if(ctx.getChildCount() == 3)
         args = args + visit(ctx.nemp_arg_list());
         
		return args; 
   }
   

   // ****** Helper Functions ****************

   // Get the positive of value
   private String getAbsString(String value){

		if(value.substring(0,1).equals("-")){
			value = value.replace("-", "");
		}
		return value;
   }

   // Get the type if unknown
   public String getType(String s){
      
      if(isInteger(s)){
         return integer;
      }
      
      else if(isBoolean(s)){
         return bool;
      }

	   return unknown;
   }
   
   // Get the number of argumnets by splitting them
   private Integer getNumArgs(String sig) {
      // Starting marker -> (
		String[] parts = sig.split("\\(");
		String rightSide = parts[1];
      String args = rightSide.substring(0, rightSide.length() - 1);
      // Split on comma
      String[] argsSplit = args.split(",");
      // Empty string -> no args
		if (argsSplit[0].equals("")) {
			return 0;
		}
		return argsSplit.length;
   }
   
   private ArrayList<String> argsTypes(String sig) {
		ArrayList<String> typeArray = new ArrayList<>(); 
		
		String[] parts = sig.split("\\(");
		String rightSide = parts[1];
		String args = rightSide.substring(0, rightSide.length() - 1);
		String[] argsSplit = args.split(",");
		
		if (argsSplit[0].equals("")) {
		   return typeArray;
		} 
	
		else {
			typeArray = new ArrayList<>(Arrays.asList(argsSplit));
      }
      
		return typeArray;
   }
    
   // Function to get the return type of the function
   private String returnArgTypes(String sig) {				
	   String[] parts = sig.split("\\(");
		return parts[0];
   }

   // Bool checker
   public boolean isBoolean(String s){
      return (s.equalsIgnoreCase("true") | s.equalsIgnoreCase("false"));
   }

   // Int checker
   public Boolean isInteger(String s){
      if(s == null) {
         return false;
      }

      try{
         Integer.parseInt(s);
      }
      catch (NumberFormatException tableEntry){
         return false;
      }
      return true;
   }

}