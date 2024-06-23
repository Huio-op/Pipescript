package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.example.gen.TaraLexer;
import org.example.gen.TaraParser;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class RunTara {

  public static void main(String[] args) {
    try {
      CharStream input = fromFileName("C:\\Users\\fe151\\IdeaProjects\\Antlr\\src\\main\\java\\org\\example\\Test.tara");
      TaraLexer lexer = new TaraLexer(input);
      TaraParser parser = new TaraParser(new CommonTokenStream(lexer));
      parser.program();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
