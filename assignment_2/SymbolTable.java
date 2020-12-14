import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Hashtable;
import java.util.Arrays;

public class SymbolTable
{
    final String marker = "/";

    Hashtable<Integer, LinkedList<SymbolTableEntry>> symbolTable;
    // Stack to handle scope
    Stack<String> undoStack; 

    public SymbolTable() {
        this.symbolTable = new Hashtable<>();
        this.undoStack = new Stack<>();
        this.undoStack.push(marker);
    }

    public Object get(String id) {
        Integer k = id.hashCode();

        if (symbolTable.containsKey(k)) {
            LinkedList<SymbolTableEntry> entry = symbolTable.get(k);

            // Iterate through the symbol table for the entry
            ListIterator<SymbolTableEntry> listIter = entry.listIterator();
            while (listIter.hasNext()) {
                SymbolTableEntry smbl = (SymbolTableEntry)listIter.next();
                if (smbl.id.equals(id))
                    return (Object)smbl;
            }
        } 
        return new SymbolTableEntry();      
    }


    public void put(String id, String type, String origin, String scope) {
        SymbolTableEntry newEntry = new SymbolTableEntry(id, type, origin, scope);
        
        // Push symbol to undo stack
        undoStack.add(id);
        
        Integer k = id.hashCode();
        if (symbolTable.containsKey(k)) {
            LinkedList<SymbolTableEntry> entry = symbolTable.get(k);
            entry.offerFirst(newEntry);
        } else {
            LinkedList<SymbolTableEntry> entry = new LinkedList<>(Arrays.asList(newEntry));
            symbolTable.put(k, entry);
        }
    }

    public void openScope() {
        undoStack.add(marker);
    }

    public void closeScope() {
        String symbol = undoStack.pop();
        
        while (!symbol.equals(marker)) {
            Integer k = symbol.hashCode();
            LinkedList<SymbolTableEntry> entry = symbolTable.get(k);
            ListIterator<SymbolTableEntry> listIter = entry.listIterator();
            while (listIter.hasNext()) {
                SymbolTableEntry smbl = (SymbolTableEntry) listIter.next();
                if (smbl.id.equals(symbol))
                    entry.remove(smbl);
            }
            symbol = undoStack.pop();
        }
    }

    public void printStack() {
        System.out.println("** Printing Stack **");
        System.out.println(Arrays.toString(this.undoStack.toArray()));
        System.out.println("********************");
    }

    public void printSymbolTable() {
        System.out.println("** Printing Symbol Table **");
        System.out.println(symbolTable.toString());
        System.out.println("***************************");
    }
}