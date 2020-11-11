import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Cal
{
	public static void main (String[] args) throws Exception{

		//file name can be given from the args or the scanner.
		Scanner in = new Scanner(System.in);
		String inputFile = null;

		if (args.length == 1) {
			inputFile = args[0];
		}

		else {
			// Give the user a second chance to enter a file name
			System.err.print("Please enter an input file name: ");
			inputFile = in.next();
			in.close();
		}

		InputStream is = System.in;
		File file = new File(inputFile);
		
		if ((inputFile != null) && (file.exists())) {
			is = new FileInputStream(inputFile);
		}

		else {
			System.err.println("File " + inputFile + " not found");
			System.exit(1);
		}

		//remove default error listeners and add my own ParseErrorListener
		calLexer lexer = new calLexer(CharStreams.fromStream(is));
		lexer.removeErrorListeners();
		lexer.addErrorListener(CalErrorListener.INSTANCE);

		CommonTokenStream tokens = new CommonTokenStream (lexer);
		calParser parser = new calParser(tokens);

		//again, replace the default error listeners for the parser.
		parser.removeErrorListeners();
		parser.addErrorListener(CalErrorListener.INSTANCE);
		parser.prog();
		
		// REPORT_SYNTAX_ERRORS is set to true in CalErrorListener by default.
		if(CalErrorListener.SYNTAX_ERRORS)
			System.out.println(inputFile + " parsed successfully");
		else
			System.out.println(inputFile + " has not parsed");
	}
}
