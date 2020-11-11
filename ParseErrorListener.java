import org.antlr.v4.runtime.*;

public class ParseErrorListener extends BaseErrorListener {

    public static final ParseErrorListener INSTANCE = new ParseErrorListener();
    public static boolean SYNTAX_ERRORS = true;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        if (!SYNTAX_ERRORS) {
            return;
        }
        
        //if syntaxError is called, then we can change the boolean.
    SYNTAX_ERRORS = false;
    }
}