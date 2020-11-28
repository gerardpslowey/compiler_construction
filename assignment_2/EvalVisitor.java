import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvalVisitor extends calBaseVisitor<Boolean> {
   Map<String, Boolean> memory = new HashMap<String, Boolean>();
	Scanner sc = new Scanner(System.in);

   @Override
	public Boolean visitAssignStm (calParser.AssignStmContext ctx)	{
		String id = ctx.ID().getText();
   }
   
   @Override
	public Boolean visitParensStm(calParser.ParensStmContext ctx) {
      String id = ctx.ID().getText();
   }
   
   @Override
	public Boolean visitBlockStm (calParser.BlockStmContext ctx) {

	}

   @Override
   public Boolean visitIfElseStm (calParser.IfElseStmContext ctx) {

	}

   @Override
	public Boolean visitWhileStm (calParser.WhileStmContext ctx) {

   }
   
   @Override
	public Boolean visitSkipStm (calParser.SkipStmContext ctx) {

   }
   
   @Override
	public Boolean visitFragExpr (calParser.BinaryOpContext ctx) {

   }
   
   @Override
	public Boolean visitParensExpr (calParser.ParensOpContext ctx) {

   }
   
   @Override
	public Boolean visitArglistExpr (calParser.ArglistOpContext ctx) {
		String id = ctx.ID().getText();

   }
   
   @Override
	public Boolean visitFragExpr (calParser.FragOpContext ctx) {

	}

}
