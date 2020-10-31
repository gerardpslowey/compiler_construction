import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CAL
{
	public static void main (String[] args) throws Exception
	{
		String inputFile = null;
		if (args.length >0)
			inputFile = args [0];

		assert inputFile != null;
		File file = new File(inputFile);
		FileInputStream is = null;
		boolean success = true;

		try {
			is = new FileInputStream (file);
			CALLexer lexer = new CALLexer (CharStreams.fromStream (is));
			lexer.removeErrorListeners();

			CommonTokenStream tokens = new CommonTokenStream (lexer);
			CALParser parser = new CALParser (tokens);
			parser.removeErrorListeners();

			parser.prog ();
			is.close();
		}
		catch (IOException e) {
			success = false;
			// If theres errors print failure.
			System.out.println(inputFile + " has not parsed");
		}

		if(success){
			// If theres no errors print success.
			System.out.println(inputFile + " parsed successfully");

		}

  }
}
