import java.io.File;

import java.io.FileNotFoundException;
import java.util.*;
import utils.ToNumber;

import token.Token;
import token.TokenType;

import Regex.Regex;

public class ReadFile {
	public void readFile()throws FileNotFoundException {
		
		String f = System.getProperty("user.dir")+"\\src\\Calc2.txt";
		File myObj = new File(f);
		Scanner myReader = new Scanner(myObj);
		
		Map<String, String> variables = new HashMap<String, String>();
		
		variables.put("x", "20");
	    variables.put("y", "10");
	    
		while (myReader.hasNextLine()) {
			// tokens são os tokens de uma linha
			List<Token> tokens = new ArrayList<Token>();
			
			// line é a linha sem ser tokenizada
			String line = myReader.nextLine().trim();
			System.out.println("Expression: " + line);
			
			//token guardará o resultado da pilha
			Token token = null;
			
			//List<String> tkn = new ArrayList<>();
		    StringTokenizer tokenizer = new StringTokenizer(line);
		    while (tokenizer.hasMoreElements()) {
		    	// tkn é cada token dentro da linha
		        String tkn = tokenizer.nextToken();
				
				if (Regex.isNum(tkn)) {
					token = new Token(TokenType.NUM, tkn);
				} else if (Regex.isOP(tkn)) {
					token = new Token(Regex.getOPTokenType(tkn), tkn);
				} else if (Regex.isID(tkn)) {
					if (Regex.getIDValue(tkn, variables) !=  null) {
						token = new Token(TokenType.ID, Regex.getIDValue(tkn, variables));
					} else {
						myReader.close();
		            	throw new RuntimeException(tkn + " cannot be resolved");
					}
				} else {
	            	myReader.close();
	            	throw new RuntimeException("Error: Unexpected character: " + tkn);
	            }
				tokens.add(token);
				//System.out.println("Token [type=" + token.type + ", lexeme=" + tkn + "]");
		    }
		    int response = new RPN().RPNalgorithm(tokens);
		    System.out.println("Result is " + response + "\n");
      	}
      	myReader.close();
	}
}