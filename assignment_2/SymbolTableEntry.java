public class SymbolTableEntry
{
    String id;
    String type;
    String origin;
    String scope;

    public SymbolTableEntry() {
        this.id = "";
        this.type = "unknown"; // Default value of unknown
        this.origin = "";
        this.scope = "";
    }

    public SymbolTableEntry(String id, String type, String origin, String scope) {
        this.id = id;
        this.type = type;
        this.origin = origin;
        this.scope = scope;
    }

    public void printEntry() {
	    System.out.println (this.id + ":" + this.type + ":" + this.origin + ":" + this.scope);
    }
}