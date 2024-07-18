package org.univates.pipescript;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.function.Supplier;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class RunPipescript {

  private final static String INPUT_FILENAME = "src/main/java/org/univates/pipescript/tests/Test.ps";
  private final static String OUTPUT_FILENAME = "src/main/java/org/univates/pipescript/output/Output.j";

  public static void main(String[] args) {
    try {
      String inputFileName = INPUT_FILENAME;
      if (args.length > 0) {
        inputFileName = args[0];
      }

      CharStream input = fromFileName(inputFileName);
      org.univates.pipescript.PipescriptLexer lexer = new org.univates.pipescript.PipescriptLexer(input);
      org.univates.pipescript.PipescriptParser parser = new org.univates.pipescript.PipescriptParser(new CommonTokenStream(lexer));

      final String compiledCode = captureConsoleOutput(parser::program);

      try(FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILENAME)){
        fileOutputStream.write(compiledCode.getBytes());
      }

      executePipescriptProgram();
    } catch (IOException | InterruptedException e) {
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

  public static void executePipescriptProgram() throws IOException, InterruptedException {
    final String outputFileName = OUTPUT_FILENAME.split("/")[OUTPUT_FILENAME.split("/").length -1];
    final String currentDir = System.getProperty("user.dir");
    final File workDir = new File(currentDir + "\\src\\main\\java\\org\\univates\\pipescript\\output\\");
    final String[] compileCommand = {
      "java",
      "-jar",
      "jasmin-2.4.jar",
      outputFileName
    };

    final ProcessBuilder compileProcess = new ProcessBuilder(compileCommand);
    compileProcess.directory(workDir);
    final Process procCompile = compileProcess.start();

    if (procCompile.waitFor() != 0) {
      final BufferedReader stdError = new BufferedReader(new
        InputStreamReader(procCompile.getErrorStream()));
      String s = null;
      System.out.println("Error during compilation phase:\n");
      while ((s = stdError.readLine()) != null) {
        System.out.println(s);
      }
      return;
    }

    final String[] executeCommand = {
      "java",
      outputFileName.split("\\.")[0]
    };

    final ProcessBuilder executeProcess = new ProcessBuilder(executeCommand);
    executeProcess.directory(workDir);
    executeProcess.inheritIO();
    final Process procExec = executeProcess.start();

    if (procExec.waitFor() != 0) {
      final BufferedReader stdError = new BufferedReader(new
        InputStreamReader(procExec.getErrorStream()));
      String s = null;
      System.out.println("Error during execution phase:\n");
      while ((s = stdError.readLine()) != null) {
        System.out.println(s);
      }
    }
  }

}
