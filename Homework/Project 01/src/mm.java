/*
 * Rajat Kuthiala
 * Project 1
 * CSC-172
 * TA: Shuyang Liu
 * 
 */
//interface given to us in the project assignment.
public interface mm {
  public void response(int colorsRightPositionWrong, int positionsAndColorRight);
  public void newGame(); // Reset the game
  public String [] nextMove(); // return the next guess
}
