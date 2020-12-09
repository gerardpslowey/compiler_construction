import java.util.ArrayList;

import javax.xml.crypto.Data;

public class SemanticCheckVisitor extends calBaseVisitor<String> {
   
   private static String scope;
   SymbolTable st = new SymbolTable();
   private ArrayList<String> functions = new ArrayList<>();


   @Override 
   public String visitProg(calParser.ProgContext ctx) { 
      scope = "global";
      String data = visitChildren(ctx); 

      // Check all functions have been used
      if (functions.size() > 0) {
         for (String func : functions) {
            System.out.println("Program Error: Function (" + func +") was declared but never used");
         }
      }
      
      return data;
   }

   @Override 
   public String visitDecl_list(calParser.Decl_listContext ctx) { 
      return visitChildren(ctx); 
   }

   // @Override 
   // public String visitDecl(calParser.DeclContext ctx) { 
   //    return visitChildren(ctx); 
   // }

   // var_decl: Variable ID COLON type ;
   @Override 
   public String visitVar_decl(calParser.Var_declContext ctx) { 
      String id = ctx.ID().getText();
      String type = visit(ctx.type());

      SymbolTableEntry e = (SymbolTableEntry) st.getSymbol(id);
      if (id.equalsIgnoreCase(e.id) && scope.equals(e.scope)) {
         System.out.println("Declaration Error: '" + id + "' already declared in " + scope + " scope");
      } else {
         st.putSymbol(id, type.toString(), DataType.var_decl, scope);
      }

      return visitChildren(ctx); 
   }


   // const_decl: Constant ID COLON type ASSIGN expression ;
   @Override 
   public String visitConst_decl(calParser.Const_declContext ctx) { 
      String id = ctx.ID().getText(); // id
      String declared_type = ctx.type().getText(); // type
      String expression = ctx.expression().getText(); // expression

      SymbolTableEntry e = (SymbolTableEntry) st.getSymbol(id);

      if (id.equalsIgnoreCase(e.id) && scope.equals(e.scope)) {
         System.out.println("Already declared in this scope");
      } else if (expression.equals(DataType.unknown)) {
         System.out.println("Variable used before declaration");
      } else if (declared_type != expression) {
         System.out.println("Assignment of different types");
      } else {
         st.putSymbol(id, declared_type, DataType.const_decl, scope);
      }

      return visitChildren(ctx); 
   }

   @Override 
   public String visitFunction_list(calParser.Function_listContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitFunction(calParser.FunctionContext ctx) { 
      String type = visit(ctx.type());
      String id = ctx.ID().getText();

      // Check function with ID doesn't already exist
      SymbolTableEntry e = (SymbolTableEntry) st.getSymbol(id);
      if (id.equals(e.id) && e.declType == DataType.function) {
         System.out.println("Declaration Error: Function cannot be declared more than once");
     }

      scope = id;
      functions.add(id);

      String signature = type + "(";
      String parameters = visit(ctx.parameter_list());
      signature = signature + parameters + ")";

      visit(ctx.decl_list());

      // TODO: Not sure about this terminal node
      visit(ctx.Begin());

      visit(ctx.statement_block());

      String returnType = visit(ctx.returnStatement());

      if (returnType != type) {
         System.out.println("Type Error: Function (" + id + ") must return " + type);
      }

      visit(ctx.End());
      st.putSymbol(id, signature, DataType.function, scope);
      scope = "global";

      return visitChildren(ctx);
   }

   @Override 
   public String visitReturnStatement(calParser.ReturnStatementContext ctx) {
      if(ctx.getChildCount() == 0){
         return String.valueOf(DataType.unknown);
      }
      else if(ctx.getChildCount() == 1){
         return visit(ctx.expression());
      }
      
      return String.valueOf(DataType.unknown);
   }

   @Override 
   public String visitType(calParser.TypeContext ctx) { 
      String type = ctx.getText();

      if(type.equalsIgnoreCase("integer")) {
         return String.valueOf(DataType.integer);
      }

      else if(type.equalsIgnoreCase("boolean")) {
         return String.valueOf(DataType.bool);
      }

      return String.valueOf(DataType.unknown);
   }

   @Override 
   public String visitParameter_list(calParser.Parameter_listContext ctx) { 
      return visitChildren(ctx.nemp_parameter_list()); 
   }

   // nemp_parameter_list: ID COLON type (COMMA nemp_parameter_list)? ;
   @Override
   public String visitNemp_parameter_list(calParser.Nemp_parameter_listContext ctx) { 
      String parameters = "";
      String id = ctx.ID().getText();

      String type = visitChildren(ctx.type());
      
      SymbolTableEntry e = (SymbolTableEntry) st.getSymbol(id);
      if(id.equalsIgnoreCase(e.id) && scope.equals(e.scope)) {
          System.out.println("Declaration Error: Variable " + id + " already declared in " + scope + " scope");
      } else {
         // TODO fix this datatype
          st.putSymbol(id, type, DataType.const_decl, scope);
      } 

      parameters = parameters + type;

      if(ctx.getChildCount() > 3){
         parameters = parameters + ", " + visitChildren(ctx.nemp_parameter_list());
      }

      return parameters;
   }

   @Override 
   public String visitMain(calParser.MainContext ctx) { 
      scope = "main";
      
      String data = visitChildren(ctx);

      scope = "global";

      return data;
   }

   @Override 
   public String visitStatement_block(calParser.Statement_blockContext ctx) { 
      return visitChildren(ctx); 
   }

   // Statements
   @Override 
   public String visitAssignStm(calParser.AssignStmContext ctx) { 
      String id = ctx.ID().getText();

      // Check id has been declared
      SymbolTableEntry e = (SymbolTableEntry) st.getSymbol(id);
      if (!id.equalsIgnoreCase(e.id)) {
         System.out.println("Assignment Error: Variable (" + id + ") must be declared before use");
      }
      if (e.declType == DataType.const_decl) {
         System.out.println("Assignment Error: Cannot assign to a constant");
      }

      DataType expression = (DataType) visit(ctx.expression());
      if (toDataType(e.type) != expression) {
          System.out.println("Value Error: Cannot assign " + expression + " to " + e.type);
      }

      return String.valueOf(DataType.unknown);
   }

   @Override 
   public String visitParensStm(calParser.ParensStmContext ctx) { 
      String id = ctx.ID().getText();
      SymbolTableEntry e = (SymbolTableEntry) st.getSymbol(id);
      if (!id.equals(e.id)) {
         System.out.println("Invocation Error: Function (" + id + ") has not been defined");
      }

      // Check it has correct integer of arguments
      Integer expectedNumArgs = getNumArgsFromSignature(e.type);
      DataType type = getReturnTypeFromSignature(e.type);

      String args = visit(ctx.arg_list());
      
      if (args.length() > 1){
         args = args.substring(0, args.length() - 1);
      }
      String signature = type.toString() + "(" + args.substring(0, args.length()) + ")";
      
      Integer actualNumArgs = getNumArgsFromSignature(signature);

      if (expectedNumArgs != actualNumArgs) {
         System.out.println("Invocation Error: Function (" + id + ") expects " + expectedNumArgs + " arguments but got " + actualNumArgs);
      }
      
      // Check arguments are of correct type
      ArrayList<DataType> expectedTypes = getArgumentTypesFromSignature(e.type);
      ArrayList<DataType> actualTypes = getArgumentTypesFromSignature(signature);

      for (int i = 0; i < expectedTypes.size() ; i++) {
         DataType exp = expectedTypes.get(i);
         DataType act = actualTypes.get(i);
         if (!exp.equals(act)) {
               System.out.println("Invocation Error: Expected type " + exp + " for argument " + i + " but got " + act);
         }
      }

      // Remove from functions list
      functions.remove(id);
      // return functions return type
      return String.valueOf(getReturnTypeFromSignature(e.type));
   }

   @Override 
   public String visitBlockStm(calParser.BlockStmContext ctx) { 
      return visit(ctx.statement_block()); 
   }

   @Override 
   public String visitIfElseStm(calParser.IfElseStmContext ctx) { 
      return visitChildren(ctx);

   }

	@Override public String visitElseStatement(calParser.ElseStatementContext ctx) { 
      return visit(ctx.statement_block()); 
   }


   @Override 
   public String visitWhileStm(calParser.WhileStmContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitSkipStm(calParser.SkipStmContext ctx) { 
      return null; 
   }





   @Override 
   public String visitBinaryOp(calParser.BinaryOpContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitParensOp(calParser.ParensOpContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitArglistOp(calParser.ArglistOpContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitFragOp(calParser.FragOpContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitBinary_arith_op(calParser.Binary_arith_opContext ctx) { 



      return visitChildren(ctx); 
   }

   @Override 
   public String visitNegOp(calParser.NegOpContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitNumOP(calParser.NumOPContext ctx) { 
      return visitChildren(ctx); 
   }
   
   @Override 
   public String visitBooleanOp(calParser.BooleanOpContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitExprOp(calParser.ExprOpContext ctx) { 
      return visitChildren(ctx); 
   }





   @Override 
   public String visitNegateOp(calParser.NegateOpContext ctx) { 
      return visitChildren(ctx); 
   }




   @Override 
   public String visitCondOp(calParser.CondOpContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitExprCompOp(calParser.ExprCompOpContext ctx) { 
      DataType left = (DataType) visit(ctx.expression(0));
      DataType right = (DataType) visit(ctx.expression(1));
      String operator = Integer.toString(ctx.op.getType());

      if (!isValidComp(left, right, operator)){
         return String.valueOf(DataType.unknown);
      }
      return String.valueOf(DataType.bool);
   }

   @Override 
   public String visitParensCondOp(calParser.ParensCondOpContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitArg_list(calParser.Arg_listContext ctx) { 
      return visitChildren(ctx); 
   }

   @Override 
   public String visitNemp_arg_list(calParser.Nemp_arg_listContext ctx) { 
      return visitChildren(ctx); 
   }

   private DataType toDataType(String s) {
      if (s.equals("integer")) {
          return DataType.integer;
      }
      if (s.equals("bool")) {
          return DataType.bool;
      }
      if (s.equals("varDecl")) {
          return DataType.var_decl;
      }
      if (s.equals("constDecl")) {
          return DataType.const_decl;
      }
      if (s.equals("assign")) {
          return DataType.assign;
      }
      if (s.equals("function")) {
          return DataType.function;
      }
      if (s.equals("compOp")) {
          return DataType.compOp;
      }

      return DataType.unknown;
  }

   private Integer getNumArgsFromSignature(String sig) {
      String[] parts = sig.split("\\(");
      String secondHalf = parts[1];
      String args = secondHalf.substring(0, secondHalf.length() - 1);
      String[] argv = args.split(",");
      if (argv[0].equals("")) {
         return 0;
      }
      return argv.length;
   }

   private DataType getReturnTypeFromSignature(String sig) {
      String[] parts = sig.split("\\(");
      return toDataType(parts[0]);
   }

   private ArrayList<DataType> getArgumentTypesFromSignature(String sig) {
      ArrayList<DataType> dataTypeArray = new ArrayList<>(); 
      
      String[] parts = sig.split("\\(");
      String secondHalf = parts[1];
      String args = secondHalf.substring(0, secondHalf.length() - 1);
      String[] argv = args.split(",");
      if (argv[0].equals("")) {
         return dataTypeArray;
      } else {
         for (String type : argv) {
            dataTypeArray.add(toDataType(type));
         }
         return dataTypeArray;
      }
   }

   private boolean isValidComp(DataType left, DataType right, String op) {

      boolean isValid = true;
      if (op.equals("==") || op.equals("!=")) {
          if ((left != DataType.bool | right != DataType.bool) & 
              (left != DataType.integer | right != DataType.integer)) {
                  isValid = false;
                  System.out.println("Type Error: Cannot compare types " + 
                                      left + " and " + right + 
                                      " with operator " + op);
          }
      } else {
          if (left != DataType.integer | right != DataType.integer) {
              isValid = false;
              System.out.println("Type Error: Cannot compare types " + 
                                  left + " and " + right + 
                                  " with operator " + op);
          }
      }
      return isValid;
  }
}