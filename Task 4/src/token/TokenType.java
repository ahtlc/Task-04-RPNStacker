package token;


/**
 * @author Henrique Rebelo
 */
public enum TokenType {

	// Literals.
	NUM, ID,

	// Single-character tokens for operations.
	MINUS, PLUS, SLASH, STAR,
	
	EOF

}