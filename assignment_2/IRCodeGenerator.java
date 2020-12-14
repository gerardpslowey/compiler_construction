import java.util.Stack;

public class IRCodeGenerator extends calBaseVisitor<String> {
    
    private int value = 1;
    private int temp = 1;
    private int paramNum = 0;
    private Stack<Integer> labels = new Stack<> ();
    
    @Override 
    public String visitProg(calParser.ProgContext ctx) {

        System.out.println("global:");

        if(ctx.decl_list() != null){
            visit(ctx.decl_list());
        }

        System.out.println("\tgoto main");

        if(ctx.function_list() != null)
            visit(ctx.function_list());
        
        if(ctx.main() != null)
            visit(ctx.main());

        return null;
    }

    @Override 
    public String visitVar_decl(calParser.Var_declContext ctx) { 
        return null;
    }

    @Override 
    public String visitConst_decl(calParser.Const_declContext ctx) { 

        String expr = ctx.expression().getClass().getSimpleName();

        if(!expr.equals("Binary_arith_opContext")){
            String var = ctx.ID().getText();
            String exp = visit(ctx.expression());
            System.out.println("\t" + var + " = " + exp);
        } 

        else{
            String var = ctx.ID().getText();
            String lOp = visit(ctx.expression().getChild(0)); //frag1
            String rOp = visit(ctx.expression().getChild(2)); //frag2
            String operator = visit(ctx.expression().getChild(2));

            System.out.println("\t" + var + " = " + lOp + " " + operator + " " + rOp);
        }

        return null; 
    }

    @Override 
    public String visitFunction_list(calParser.Function_listContext ctx) { 
        return visitChildren(ctx); 
    }

    @Override 
    public String visitFunction(calParser.FunctionContext ctx) { 
        String id = ctx.ID().getText();
        System.out.println(id + ":");
        visit(ctx.parameter_list());
        visit(ctx.decl_list());
        visit(ctx.statement_block());
        visit(ctx.return_expr());

        return null; 
    }

    @Override 
    public String visitReturn_expr(calParser.Return_exprContext ctx) { 
        if(ctx.getChildCount() == 0){
            System.out.println("\t" + "return");
            return null;
        }

        String rChildType = ctx.expression().getClass().getSimpleName();

        if(!rChildType.equals("BinaryOpContext")){
            String var = visit(ctx.expression());
            System.out.println("\t" + "return " + var);
        }

        else{
            visit(ctx.expression());
            ctx.expression().getText();

            System.out.println("\t" + "return t" + (temp-1));
        }
        return null;

    }

    @Override 
    public String visitType(calParser.TypeContext ctx) { 
        String type = ctx.op.getText();

        if(type.equalsIgnoreCase("integer")) {
           return "integer";
        }
  
        else if(type.equalsIgnoreCase("boolean")) {
           return "bool";
        }
  
        return null;
     }

    @Override 
    public String visitParameter_list(calParser.Parameter_listContext ctx) { 
        visitChildren(ctx); 
        return null;
    }

    @Override 
    public String visitNemp_parameter_list(calParser.Nemp_parameter_listContext ctx) {
        String pId = ctx.ID().getText();
        System.out.println("\t" + pId + " = getparam " + paramNum);
        paramNum ++;

        if(ctx.getChildCount() == 5){
            visit(ctx.nemp_parameter_list());
        }

        return null; 
    }

	@Override public String visitMain(calParser.MainContext ctx) { 
        System.out.println("main:");
        return visitChildren(ctx); 
    }

	@Override public String visitStatement_block(calParser.Statement_blockContext ctx) { 
        return visitChildren(ctx);
    }

    @Override 
    public String visitAssignStm(calParser.AssignStmContext ctx) {

        String expr = ctx.expression().getClass().getSimpleName();

        if(!expr.equals("BinaryOpContext")){
            String id = ctx.ID().getText();
            String val = visit(ctx.expression());
            System.out.println("\t" + id + " = " + val);
        }

        else if(expr.equals("ParensStmContext")){
            String id = ctx.ID().getText();
            String val = visit(ctx.expression().getChild(1));
            System.out.println("\t" + id + " " + val);
        } 
        
        else {
            String id = ctx.ID().getText();
            String left = visit(ctx.expression().getChild(0));
            String operator = visit(ctx.expression().getChild(1));
            visit(ctx.expression().getChild(2));
            System.out.println("\t" + id + " = " + left + " " + operator + " t" + (temp-1));
        }

        return null; 
        }

    @Override 
    public String visitParensStm(calParser.ParensStmContext ctx) { 
        String count = visit(ctx.arg_list());
        String id = ctx.ID().getText();

        String instruction = "call " + id + " " + count;

        String parent = ctx.getParent().getClass().getSimpleName();

        if (parent.equals("BlockStmContext")) {
            System.out.println("\t" + instruction);
        }

        return instruction; 
    }

    @Override 
    public String visitBlockStm(calParser.BlockStmContext ctx) { 
        return visitChildren(ctx); 
    }

    @Override 
    public String visitIfElseStm(calParser.IfElseStmContext ctx) { 
        System.out.println("\tifz t" + (temp-1) + " goto L" + value);
        labels.push(value);
        value++;

        visit(ctx.condition());
        value++;
        System.out.println("\tgoto L" + (value-1));
        System.out.println("L" + labels.pop() + ":");

        visit(ctx.statement_block());

        return null; 
    }

    @Override 
    public String visitWhileStm(calParser.WhileStmContext ctx) {
        System.out.println("L" + value + ":");
        labels.push(value);
        value++;
        
        visit(ctx.condition());
        System.out.println("\tifz t" + (temp-1) + " goto L" + value);
        labels.push(value);
        value++;

        visit(ctx.statement_block());
        int tmpLbl = labels.pop();
        int tmpLbl2 = labels.pop();
        System.out.println("\tgoto L"+ tmpLbl2);
        System.out.println("L" + tmpLbl + ":");
        value++;

        return visitChildren(ctx);
    }

    @Override 
    public String visitSkipStm(calParser.SkipStmContext ctx) { 
        return null; 
    }

    @Override 
    public String visitElse_statement(calParser.Else_statementContext ctx) { 
        visit(ctx.statement_block());
        System.out.println("\tgoto L" + (value-1));
        System.out.println("L" + (value-1));
        return null;
    }

    @Override 
    public String visitBinaryOp(calParser.BinaryOpContext ctx) { 
       
        String operator = visit(ctx.binary_arith_op());

        String right = ctx.frag(1).getClass().getSimpleName();

        if(!right.equals("BinaryOpContext")){
            String lval = visit(ctx.frag(0));
            String rval = visit(ctx.frag(1));
            System.out.println("\t" + "t" + temp + " = " + lval + " " + operator + " " + rval);
        } 
        else{
            visit(ctx.frag(1));
            System.out.println("\t" + "t" + temp + " = " 
            + visit(ctx.frag(0)) + " " + operator + " t" + (temp-1));
        }
        temp++;
        return "t" + (temp-1);

    }

    @Override 
    public String visitParensOp(calParser.ParensOpContext ctx) { 
        return visit(ctx.expression()); 
    }

    @Override 
    public String visitArglistOp(calParser.ArglistOpContext ctx) {
                
        String count = visit(ctx.arg_list());
        String id = ctx.ID().getText();

        String instruction = "call " + id + " " + count;

        String parent = ctx.getParent().getClass().getSimpleName();

        if (parent.equals("BlockStmContext")) {
            System.out.println("\t" + instruction);
        }
        return instruction; 
    }

	@Override public String visitFragOp(calParser.FragOpContext ctx) { 
        return visit(ctx.frag());
    }

    @Override 
    public String visitBinary_arith_op(calParser.Binary_arith_opContext ctx) { 
        return ctx.op.getText(); 
    }

    @Override 
    public String visitNegOp(calParser.NegOpContext ctx) { 
        String id = ctx.ID().getText();
        if(ctx.getChildCount() == 2){
            return "0 - " + id;
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
    public String visitExprOp(calParser.ExprOpContext ctx) { 
        return visit(ctx.expression()); 
    }

    @Override 
    public String visitNegateOp(calParser.NegateOpContext ctx) {
        return "-" + visit(ctx.condition());
    }

    @Override 
    public String visitCondOp(calParser.CondOpContext ctx) { 
        String lChild = visit(ctx.condition(0));
        String rChild = visit(ctx.condition(1));
        String operator = ctx.op.getText();

        System.out.println("\t" + "t" + temp + " = t" + (lChild) + " " + operator + " t" + rChild);
        temp++;

        return null; 
    }

    @Override 
    public String visitExprCompOp(calParser.ExprCompOpContext ctx) { 
        String lValue = visit(ctx.expression(0));
        String rValue = visit(ctx.expression(1));
        String operator = visit(ctx.comp_op());

        System.out.println("\t" + "t" + temp + " = " + lValue + " " + operator + " " + rValue);
        temp++;
        return String.valueOf(temp-1);
    }

    @Override 
    public String visitParensCondOp(calParser.ParensCondOpContext ctx) { 
        return visit(ctx.condition());
    }

    @Override 
    public String visitComp_op(calParser.Comp_opContext ctx) { 
        return ctx.op.getText();
    }

    @Override 
    public String visitArg_list(calParser.Arg_listContext ctx) {
        if(ctx.getChildCount() != 0){
            return visit(ctx.nemp_arg_list()); 
        }
        return null;
    }

    @Override 
    public String visitNemp_arg_list(calParser.Nemp_arg_listContext ctx) { 
        int count = 0;
        
        System.out.println("\t" + "param " + ctx.ID().getText());
        paramNum++;
        if(ctx.getChildCount() == 3){
            count++;
            visit(ctx.nemp_arg_list());
        }
        return String.valueOf(count);
    }
}