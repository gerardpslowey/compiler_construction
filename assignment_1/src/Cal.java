import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Cal
{
	public static void main (String[] args) throws Exception{

		Scanner in = new Scanner(System.in);
		String inputFile = null;

		// If the filename has been given on the command line
		// Assign it to the inputFile variable
		if (args.length == 1) {
			inputFile = args[0];
		}

		// Give the user a second chance to enter a file name
		// if they have ran the program with no input
		else if (args.length == 0) {
			System.out.print("Please enter an input file name: ");
			inputFile = in.next();
			in.close();
		}

		// Otherwise the user has entered too much
		else {
			System.out.print("Only one input file is allowed");
			System.exit(1);
		}

		InputStream is = System.in;
		File file = new File(inputFile);
		
		// If the input file name is valid and 
		// The file exists
		if ((inputFile != null) && (file.exists())) {
			is = new FileInputStream(inputFile);
		}

		// If the file cannot be found or is not valid
		// inform the user and exit with an error code
		else {
			System.out.println("File " + inputFile + " cannot be found");
			System.exit(1);
		}

		// Get a stream of tokens
		calLexer lexer = new calLexer(CharStreams.fromStream(is));
		
		// Remove default error listeners and add my own CalErrorListener
		lexer.removeErrorListeners();
		lexer.addErrorListener(CalErrorListener.INSTANCE);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		calParser parser = new calParser(tokens);

		// As before, replace the default error listeners for the parser
		parser.removeErrorListeners();
		parser.addErrorListener(CalErrorListener.INSTANCE);

		// Then run the parser on the prog rule
		parser.prog();
		
		// Print out the result of the lexical analysis and parsing
		System.out.println(inputFile + CalErrorListener.INSTANCE.toString());

	}
}
