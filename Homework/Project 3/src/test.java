

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;

public class test {
  static Scanner fl;
  public static void main(String[] args){
    try{
      fl = new Scanner(new File(args[0]));
    }catch(Exception e){
      System.out.println("File was not found");
      return;
    }
    //System.out.println("Enter the number of lines, then enter the lines in the following format:\n# of lines \nx1 y1 x2 y2");
    int num_lines = fl.nextInt(); //get the number of lines

    line L[] = new line[num_lines]; //set up the array of lines

    for(int i = 0; i < num_lines; i++){ //loop through, getting the 4 points of each line
      float x1 = fl.nextFloat();
      float y1 = fl.nextFloat();
      float x2 = fl.nextFloat();
      float y2 = fl.nextFloat();
      if (Geometry.isValid(x1) && Geometry.isValid(y1) && Geometry.isValid(x2) && Geometry.isValid(y2)){ //check for valid points
        L[i] = new line(x1, y1, x2, y2);
      }
      else {
        System.out.println("One of the points you have entered is invalid. The points must be in the unit square.");
        i--;
        return;
      }
    }

    BinarySearchTree bst = new BinarySearchTree(); //set up the tree

    for (line l : L){ //insert the lines
      bst.insert(l);
      //bst.printInOrder(); //for testing, print the lines
      //System.out.println();
    }

    //System.out.println(bst.externalNode() + " " + bst.externalPath());
    System.out.println("Average Path is: " + (double) bst.externalPath()/ (double) bst.externalNode());
    //System.out.println("Enter the points you want to test: x1 y1 x2 y2"); //ask for the points
    point a;
    point b;
    while (fl.hasNext()) { //untill they quit
      String s = fl.next(); //get the first thing
      if (s.equals("quit")){ //if its quit, break
        break;
      }
      a = new point (new Float(s), fl.nextFloat());
      b = new point (fl.nextFloat(), fl.nextFloat());
      System.out.print(a + " " + b + " : ");
      bst.sameRegion(a, b); //otherwise test the points
    }
  }
}
