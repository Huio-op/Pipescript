package org.univates.pipescript;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.univates.pipescript.gen.PipescriptLexer;
import org.univates.pipescript.gen.PipescriptParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class RunTara {

  public static void main(String[] args) {
    try {
      CharStream input = fromFileName(".\\src\\main\\java\\org\\univates\\pipescript\\Test.ps");
      PipescriptLexer lexer = new PipescriptLexer(input);
      PipescriptParser parser = new PipescriptParser(new CommonTokenStream(lexer));
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
      parser.program();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
