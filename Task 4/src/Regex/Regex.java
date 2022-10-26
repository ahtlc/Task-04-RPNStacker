package Regex;

import token.*;

import java.util.Map;

public class Regex {
	
	private static final String ID_REGEX = "[a-zA-Z]+"; // letras
	private static final String NUM_REGEX = "[0-9]+"; // [0-9]
	private static final String OP_REGEX = "(\\+|-|\\*|/)"; // operações
	private static final String PLUS_REGEX = "(\\+)"; // operação de soma
	private static final String MINUS_REGEX = "(\\-)"; // operação de subttação
	private static final String SLASH_REGEX = "(/)"; // operação de divisão
	private static final String STAR_REGEX = "(\\+)"; // operação de multiplicação
	
	public static boolean isID(String token) {
		return token.matches(ID_REGEX);
	}
	
	public static boolean isNum(String token) {
		return token.matches(NUM_REGEX);
	}
	
	public static boolean isOP(String token) {
		return token.matches(OP_REGEX);
	}
	
	public static boolean isPLUS(String token) {
		return token.matches(PLUS_REGEX);
	}
	
	public static boolean isMINUS(String token) {
		return token.matches(MINUS_REGEX);
	}
	
	public static boolean isSLASH(String token) {
		return token.matches(SLASH_REGEX);
	}
	
	public static boolean isSTAR(String token) {
		return token.matches(STAR_REGEX);
	}
	
	public static TokenType getOPTokenType(String line) {
		if (line.equals("-")) {
			return TokenType.MINUS;
    	} else if (line.equals("+")) {
    		return TokenType.PLUS;
    	} else if (line.equals("/")) {
    		return TokenType.SLASH;
    	} else if (line.equals("*")) {
    		return TokenType.STAR;
		}
		return null;
	}
	
	public static String getIDValue(String line, Map<String, String> variables) {
		
		// retorna o valor da variável
		for (Map.Entry<String, String> set : variables.entrySet()) {
			if (line.equals(set.getKey())) {
				return set.getValue();
			}
		}
		return null;
	}
}