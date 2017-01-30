/*
 * Rajat Kuthiala
 * Project 1
 * CSC-172
 * TA: Shuyang Liu
 * 
 */
import java.util.Scanner;

public class Game {
  public static void main(String[] args){
    System.out.println("Welcome to MasterMind. The Computer will try to guess the code you have chosen, and you provide feedback based on the positions of the tokens. Have fun!\n");

    Scanner input = new Scanner(System.in); //set up scanner
    System.out.print("Enter the tokens seperated by a space: ");
    String token_s = input.nextLine();
    String[] tokens = token_s.split(" "); //get the array of token options
    System.out.print("Enter the number of tokens in the code: ");
    int x = input.nextInt();//get the number of tokens per code
    MasterMind m = new MasterMind(tokens, x); //set up the game
    Code g = new Code(); //set up variable to handel the gameplay
    String[] move;

    while (!m.won){ //start the game, continue untill the user won
      System.out.println("Finding move, please wait.");
      move = m.nextMove();
      System.out.print("My guess is: ");
      for (String c : move){
        System.out.print(c +", ");
      }
      System.out.println();
      System.out.print("How many are in the right spot? ");
      int r = input.nextInt();
      System.out.print("How many are the right color, wrong spot? ");
      int w = input.nextInt();
      System.out.println();
      m.response(w,r);
      if (m.won){ //if they win, ask if they want to play again.
        System.out.print("Do you want to play again (y/n)? ");
        String newgame = input.next();
        if (newgame.charAt(0) == 'y'){
          System.out.println("Good Luck.");
          m.newGame();
        }
      }
    }
  }
}
