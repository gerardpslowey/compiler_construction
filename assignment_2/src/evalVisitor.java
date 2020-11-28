import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class evalVisitor extends calBaseVisitor<Boolean>
{
	Map<String, Boolean> memory = new HashMap<String, Boolean>();
	Scanner sc = new Scanner(System.in);

	@Override
	public Boolean visitAssignStm (calParser.AssignStmContext ctx)
	{
		String id = ctx.ID().getText();
		Boolean value = visit(ctx.expr());
		memory.put(id, value);
		return value;
	}

	@Override
	public Boolean visitWriteStm(calParser.WriteStmContext ctx)
	{
		String id = ctx.ID().getText();
		System.out.print (id + ": ");
		Boolean value = memory.get(id);
		if (value)
			System.out.println ("True");
		else
			System.out.println ("False");

		return value;
	}

	@Override
	public Boolean visitReadStm (calParser.ReadStmContext ctx)
	{
		String id = ctx.ID().getText();
		System.out.print (id + ": ");
		String str = sc.nextLine();
		char c = str.charAt(0);
		Boolean value = (c =='t' || c == 'T') ? true : false;
		memory.put (id, value);

		return value;
	}

	@Override
	public Boolean visitBoolV (calParser.BoolVContext ctx)
	{
		if (ctx.BV().getText().equals ("true"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Boolean visitId (calParser.IdContext ctx)
	{
		String id = ctx.ID().getText();
		if (memory.containsKey (id))
			return memory.get(id);
		return true;
	}

	@Override
	public Boolean visitBinOp (calParser.BinOpContext ctx)
	{
		Boolean left = visit(ctx.expr(0));
		Boolean right = visit (ctx.expr(1));
		if (ctx.op.getType() == calParser.AND)
			return (left & right);
		return (left | right);
	}

	@Override
	public Boolean visitNegOp (calParser.NegOpContext ctx)
	{
		Boolean value = visit(ctx.expr());
		return (!value);
	}

	@Override
	public Boolean visitParens (calParser.ParensContext ctx)
	{
		return visit(ctx.expr());
	}

}