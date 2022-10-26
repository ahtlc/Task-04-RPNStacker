import java.util.*;

import stack.Stack;
import token.Token;
import token.TokenType;

public class RPN {
	public int RPNalgorithm(List<Token> tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        while (!tokens.isEmpty()) {
        	Token token = tokens.remove(0);
        	if (token.type == TokenType.NUM) {
                stack.push(Integer.valueOf(token.lexeme));
            } else if (token.type == TokenType.ID) {
            	stack.push(Integer.valueOf(token.lexeme));
            }
        	
        	else {
            	int x = stack.pop();
                int y = stack.pop();

                switch (token.type){
                	case MINUS:
                		stack.push(y - x);
                		break;
                	case PLUS:
                		stack.push(y + x);
                		break;
                	case STAR:
                		stack.push(y * x);
                		break;
                	case SLASH:
                		stack.push(y / x);
                		break;
                }
            }
        }
        return stack.pop();
    }
}