import org.antlr.v4.runtime.*;

public class CalErrorListener extends BaseErrorListener {

    public static CalErrorListener INSTANCE = new CalErrorListener();

    // Error listener called errors_present is true
    public static boolean ERRORS_PRESENT = true;

    // Success message by default
    private String message = " parsed successfully";

    // Override the syntax error definition
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        
        // No lexer or parse errors
        if (!ERRORS_PRESENT) {
            return;
        }
    
        // Change message
        // Errors have occurred
        message = " has not parsed";
    }

    @Override
    public String toString() {
        return message;   
    }

}