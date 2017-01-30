/*
 * Rajat Kuthiala
 * Project 1
 * CSC-172
 * TA: Shuyang Liu
 * 
 */
public class MasterMind implements mm {
  //set up the variables needed by the mastermind game
  PossibleCodes codeList;
  int spaces;
  String[] colors;
  boolean won;
  Code currentGuess;
  int colorCorrect;
  int positionsCorrect;
  public MasterMind (String[] tokencolors, int positions){
    won = false;
    colors = tokencolors;
    codeList = new PossibleCodes();
    spaces = positions;
    int[] tokens = new int[spaces];
    codeGenerator(tokens, 0);
    colorCorrect = -1; //used to tell if it is the first move.
  }

  public void printList (){
    codeList.printList();
  }

  public void response(int colorsRightPositionWrong, int positionsAndColorRight) { //checks the users response and checks if the computer won, otherwise it removes options from the list
    colorCorrect = colorsRightPositionWrong;
    positionsCorrect = positionsAndColorRight;
    if (positionsAndColorRight == spaces){
      won = true;
      return;
    }
    else {
      codeList.rightColorRightSpot(currentGuess, positionsAndColorRight);
      codeList.rightColorWrongSpot(currentGuess, colorsRightPositionWrong, colors);
    }
    //printList();
  }

  public void newGame() { //resets variables for the new game
    codeList.clear();
    int[] tokens = new int[spaces];
    codeGenerator(tokens, 0);
    won = false;
    colorCorrect = -1;
  }


  public String [] nextMove() { //finds the next guess
    Code e = codeList.first.nextCode;
    if (colorCorrect == -1){ //for the first guess there is no base data so just start with the middle item
      System.out.println("first try");
      String[] g = new String[e.nextCode.code.length];
      Code nm = new Code();
      for (int i = 0; i < codeList.size()/2; i++){
        e = e.nextCode;
      }

      for (int i = 0; i < g.length; i++){
        g[i] = colors[e.nextCode.code[i]];
      }
      nm.code = e.nextCode.code;
      currentGuess = nm;
      return g;
    }
    else if (codeList.size() == 1){ //if there is only one code, return it
      String[] g = new String[e.code.length];
      for (int i = 0; i < g.length; i++){
        g[i] = colors[e.code[i]];
      }
      return g;
    }
    //otherwise find the code that will remove the most other codes if wrong.
    int max = 0;
    Code next = new Code();
    while(e.code != null){
      int tot = codeList.rightColorRightSpotCount(e, colorCorrect) + codeList.rightColorWrongSpotCount(e, positionsCorrect, colors);
      if (tot >= max){
        max = tot;
        next.code = e.code;
      }
      e = e.nextCode;
    }
    currentGuess = next;
    String[] g = new String[spaces];
    for (int i = 0; i < g.length; i++){
      g[i] = colors[next.code[i]];
    }
    return g;
  }
  //so this uses ints, guess I should make it strings, but...
  //the following method uses theorys obtained by discussing the game theory with other students, and by the information given to us in class.

  public void codeGenerator (int[] options, int position){
    int next = position + 1;
    for (int codeVal = 0; codeVal < colors.length; codeVal++){
      if (position != spaces){
        options[position] = codeVal;
        codeGenerator(options, next);
      }
      else{
        codeList.insert(options);
      }
    }
  }
}
