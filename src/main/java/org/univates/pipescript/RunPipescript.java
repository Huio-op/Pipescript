package org.univates.pipescript;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class RunPipescript {

  private final static String INPUT_FILENAME = "src/main/java/org/univates/pipescript/Test.ps";
  private final static String OUTPUT_FILENAME = "src/main/java/org/univates/pipescript/output/Output.j";

  public static void main(String[] args) {
    try {
      List<String> vars = new ArrayList<>();
      vars.stream().anyMatch(var -> !var.isEmpty());
      CharStream input = fromFileName(INPUT_FILENAME);
      org.univates.pipescript.PipescriptLexer lexer = new org.univates.pipescript.PipescriptLexer(input);
      org.univates.pipescript.PipescriptParser parser = new org.univates.pipescript.PipescriptParser(new CommonTokenStream(lexer));

      final String compiledCode = captureConsoleOutput(parser::program);

      try(FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILENAME)){
        fileOutputStream.write(compiledCode.getBytes());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static <T> String captureConsoleOutput(Supplier<T> function) {
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    PrintStream old = System.out;
    System.setOut(ps);

    function.get();

    System.out.flush();
    System.setOut(old);
    return baos.toString();
  }

}
