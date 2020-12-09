public class SymbolTableEntry
{
    String id;
    String type;
    DataType declType;
    String scope;

    public SymbolTableEntry() {
        this.id = "";
        this.type = "";
        DataType declType = DataType.unknown;
        this.scope = "";
    }

    public SymbolTableEntry(String id, String type, DataType declType, String scope) {
        this.id = id;
        this.type = type;
        this.declType = declType;
        this.scope = scope;
    }
}