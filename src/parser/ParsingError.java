package parser;


import lexer.tokens.Token;
import lexer.tokens.TokenKind;

import java.util.ArrayList;

public class ParsingError extends RuntimeException {
  private ParsingError(String message) {
		super(message);
	}

	public static ParsingError unexpectedToken(Token got, TokenKind expected, String sourceFile) {
      String[] lines = sourceFile.split("\n");


      for(String line : lines) {

      }
	}
}
