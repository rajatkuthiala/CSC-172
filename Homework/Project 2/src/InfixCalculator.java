import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class InfixCalculator{
  public static BufferedReader in;
  public static PrintWriter writer;
  public static void main(String[] args){
    if (args.length < 2){ //if they don't give two files, complain
      System.out.println("Error: Enter source and destination File");
    }
    else{ //if they do

      ShuntingYard sy = new ShuntingYard(); //create an object to handle the conversions
      try{ //try to open and set up the files
        writer = new PrintWriter(args[1], "UTF-8");
        in = new BufferedReader(new FileReader( new File(args[0])));
      }catch(FileNotFoundException e){
        System.out.println(e);
      }catch(UnsupportedEncodingException e){
        System.out.println(e);
      }
      try{ //then try to read in each line
        while(in.ready()){
          String t = in.readLine();
          Queue<String> post = sy.postfix(t);
          Double ans = Calc.calc(post); //get the postfix, then send it to the calc
          //System.out.println(ans);
          writer.printf("%.2f\n", ans); //print the answer to the output file
        }
      }catch(IOException e){
        System.out.println(e);
      }
      //ShuntingYard sy = new ShuntingYard();
      writer.close(); //close the output file
      try{
        in.close();
      }catch(IOException e){
        System.out.println(e);
      }
    }
  }
}
