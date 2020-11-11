import org.antlr.v4.runtime.*;

public class CalErrorListener extends BaseErrorListener {

    public static final CalErrorListener INSTANCE = new CalErrorListener();
    public static boolean SYNTAX_ERRORS = true;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        if (!SYNTAX_ERRORS) {
            return;
        }

        else {
            SYNTAX_ERRORS = false;
        }
        
    //if syntaxError is called, then we can change the boolean.
    }
}