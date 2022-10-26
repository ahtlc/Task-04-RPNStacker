import java.io.*;

import java.util.*;

import token.Token;
import token.TokenType;

public class Main {
	  public static void main(String[] args) {
		  try {
			  ReadFile r = new ReadFile();
			  r.readFile();
		  }
		  
		  catch (FileNotFoundException e) {
			  System.out.println("An error occurred.");
			  e.printStackTrace();
		  }
	  }
	}