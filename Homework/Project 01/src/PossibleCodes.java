/*
 * Rajat Kuthiala
 * Project 1
 * CSC-172
 * TA: Shuyang Liu
 * 
 */
public class PossibleCodes {
  Code first;
  Code last;
  int size;
  public PossibleCodes(){
    first = new Code();
    last = new Code();
    first.nextCode = last;
    last.prevCode = first;
    size = 0;
  }
  public void clear(){
    first.nextCode = last;
    last.prevCode = first;
    size = 0;
  }
  public int size(){
    return size;
  }
  public void insert(int[] x){
    size++;
    Code e = last;
    Code in = new Code();
    int[] y = x.clone();
    in.code = y;
    in.prevCode = e.prevCode;
    in.nextCode = e;
    e.prevCode.nextCode = in;
    e.prevCode = in;
  }
  public boolean arrayEqual(int[] a, int[] b){
    for(int i = 0; i<a.length; i++){
      if (a[i] != b[i]){
        return false;
      }
    }
    return true;
  }
  public void delete(int[] x){
    size--;
    Code e = first;
    while(e.nextCode != last){ //run through the elements
      if (arrayEqual(x, e.nextCode.code)){
        e.nextCode.nextCode.prevCode = e;
        e.nextCode = e.nextCode.nextCode;
        return;
      }
      e = e.nextCode;
    }
  }
  public void printList(){
    Code e = first;
    while (e.nextCode != last){ //run through the elements and print each one
      for(int s : e.nextCode.code){
        System.out.print(s);
      }
      System.out.println();
      e = e.nextCode;
    }
    System.out.println();
  }
  public boolean isEmpty(){
    return (first.nextCode == last);
  }
  public boolean lookup(int[] x){
    Code e = first;
    boolean res = false;

    while (e.nextCode != last && !res){
      for(int i =0; i<x.length; i++){
        if (e.nextCode.code[i] != x[i]){
          res = false;
          i = x.length;
        }
        else{
          res = true;
        }
      }
      e = e.nextCode;
    }
    return res;
  }
  public void rightColorRightSpot(Code guess, int blackPegs){ //move to PossibleCodes
    System.out.println("Updating list, hold on.");
    Code e = first;
    while (e.nextCode != last){
      int b = 0;
      for(int i =0; i<guess.code.length; i++){
        if (e.nextCode.code[i] == guess.code[i]){
          b++;
        }
      }
      if(e.nextCode == last || e.nextCode == null){
        return;
      }
      if (b != blackPegs){
        delete(e.nextCode.code);
      }
      else{
        e = e.nextCode;
      }
    }
  }

  public void rightColorWrongSpot(Code guess, int whitePegs, String[] colors){
    System.out.println("Still updating list, please wait.");
    Code e = first;
    int[] copies = new int[colors.length];
    int[] test_copies = new int[colors.length];
    int[] w_vals = new int[colors.length];
    int[] w_res = new int[colors.length];

    for (int h = 0; h < copies.length; h++){
      copies[h] = 0;
      test_copies[h] = 0;
      w_vals[h] = 0;
    }
    for (int v : guess.code){
      copies[v]++;
    }

    while (e.nextCode != last){
      for (int h = 0; h < copies.length; h++){
        test_copies[h] = 0;
        copies[h] = 0;
        w_res[h] = 0;
        w_vals[h] = 0;
      }
      for (int v = 0; v < guess.code.length; v++){
        if(guess.code[v] != e.nextCode.code[v])
        copies[guess.code[v]]++;
      }
      for (int v = 0; v < e.nextCode.code.length; v++){
        if(guess.code[v] != e.nextCode.code[v]){
          test_copies[e.nextCode.code[v]]++;
        }
      }

      for (int i = 0; i<guess.code.length; i++){
        for(int j = 0; j<e.nextCode.code.length; j++){
          if(guess.code[i] == e.nextCode.code[j] && guess.code[j] != e.nextCode.code[j] && guess.code[i] != e.nextCode.code[i]){
            w_vals[guess.code[i]]++;
          }
        }
      }


      for (int h = 0; h < w_res.length; h++){
        if(copies[h] != 0 && (copies[h] > test_copies[h])){
          w_res[h] = w_vals[h]/copies[h];
        }
        else if(test_copies[h] != 0 && (test_copies[h] >= copies[h])){
          w_res[h] = w_vals[h]/test_copies[h];
        }
      }
      int w = 0;
      for (int y : w_res){
        w += y;
      }

      if (whitePegs != w){
        delete(e.nextCode.code);
      }
      else{
        e = e.nextCode;
      }
    }
  }
  public int rightColorRightSpotCount(Code guess, int blackPegs){
    //System.out.println("Finding the next guess.");
    Code e = first;
    int removed = 0;
    while (e.nextCode != last){
      int b = 0;
      for(int i =0; i<guess.code.length; i++){
        if (e.nextCode.code[i] == guess.code[i]){
          b++;
        }
      }
      if(e.nextCode == last || e.nextCode == null){
        return removed;
      }
      if (b != blackPegs){
        removed++;
      }
      e = e.nextCode;
    }
    return removed;
  }

  public int rightColorWrongSpotCount(Code guess, int whitePegs, String[] colors){
    //System.out.println("Almost done finding the next guess, please wait.");
    Code e = first;
    int removed = 0;
    int[] copies = new int[colors.length];
    int[] test_copies = new int[colors.length];
    int[] w_vals = new int[colors.length];
    int[] w_res = new int[colors.length];

    for (int h = 0; h < copies.length; h++){
      copies[h] = 0;
      test_copies[h] = 0;
      w_vals[h] = 0;
    }
    for (int v : guess.code){
      copies[v]++;
    }

    while (e.nextCode != last){
      for (int h = 0; h < copies.length; h++){
        test_copies[h] = 0;
        copies[h] = 0;
        w_res[h] = 0;
        w_vals[h] = 0;
      }
      for (int v = 0; v < guess.code.length; v++){
        if(guess.code[v] != e.nextCode.code[v])
        copies[guess.code[v]]++;
      }
      for (int v = 0; v < e.nextCode.code.length; v++){
        if(guess.code[v] != e.nextCode.code[v]){
          test_copies[e.nextCode.code[v]]++;
        }
      }

      for (int i = 0; i<guess.code.length; i++){
        for(int j = 0; j<e.nextCode.code.length; j++){
          if(guess.code[i] == e.nextCode.code[j] && guess.code[j] != e.nextCode.code[j] && guess.code[i] != e.nextCode.code[i]){
            w_vals[guess.code[i]]++;
          }
        }
      }
      for (int h = 0; h < w_res.length; h++){
        if(copies[h] != 0 && (copies[h] > test_copies[h])){
          w_res[h] = w_vals[h]/copies[h];
        }
        else if(test_copies[h] != 0 && (test_copies[h] >= copies[h])){
          w_res[h] = w_vals[h]/test_copies[h];
        }
      }
      int w = 0;
      for (int y : w_res){
        w += y;
      }

      if (whitePegs != w){
        removed++;
      }
      e = e.nextCode;
    }
    return removed;
  }

  public void printCode(Code x){
    for (int c : x.code){
      System.out.print(c);
    }
  }
}
