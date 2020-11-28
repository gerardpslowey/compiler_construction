public interface CalParserTreeConstants
{
  public int CALPROG = 0;
  public int CALVOID = 1;
  public int CALVAR = 2;
  public int CALCONST = 3;
  public int CALFUNCTION = 4;
  public int CALTYPE = 5;
  public int CALNPARAMLIST = 6;
  public int CALMAIN = 7;
  public int CALSTATEMENT = 8;
  public int CALASSIGN = 9;
  public int CALARGASSIGN = 10;
  public int CALADD = 11;
  public int CALSUBTRACT = 12;
  public int CALFUNCRETURN = 13;
  public int CALANDCON = 14;
  public int CALORCON = 15;
  public int CALCOMP = 16;
  public int CALEQUAL = 17;
  public int CALNOTEQUAL = 18;
  public int CALLESSTHAN = 19;
  public int CALLESSTHANEQUALTO = 20;
  public int CALGREATERTHAN = 21;
  public int CALGREATERTHANEQUALTO = 22;
  public int CALARGLIST = 23;
  public int CALID = 24;
  public int CALNUMBER = 25;
  public int CALBOOL = 26;


  public String[] CalNodeName = {
    "Program",
    "void",
    "Var",
    "Const",
    "Function",
    "Type",
    "NParamList",
    "Main",
    "Statement",
    "Assign",
    "ArgAssign",
    "Add",
    "Subtract",
    "FuncReturn",
    "AndCon",
    "OrCon",
    "Comp",
    "Equal",
    "NotEqual",
    "LessThan",
    "LessThanEqualTo",
    "GreaterThan",
    "GreaterThanEqualTo",
    "ArgList",
    "ID",
    "Number",
    "Bool",
  };
}
