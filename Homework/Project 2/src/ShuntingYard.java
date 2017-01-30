public class ShuntingYard {
  public Stack<String> expressionStack;
  public Queue<String> expressionQueue;

  public ShuntingYard (){
    expressionStack = new Stack<String>(); //set up the stack & queue
    expressionQueue = new Queue<String>();
  }

  public Queue<String> postfix (String eq){ //convert to postfix
    expressionQueue.clear(); //clear the queue
    eq = noSpace(eq);
    String[] tokens = tokenize(eq); //get the tokens

    for(String t : tokens){ //for every token

      if(t == (null) || t.equals("")){ //remove the null things added into the list
        //I should work on finding a way that doesn't result in nulls in the array but it works for now so...
      }
      else if (Calc.operator(t)){ //if it is an operator
        if(t.equals(")")){ //close paren, empty the stack into the queue until you fnd the open paren.
          while (!expressionStack.isEmpty() && true){
            String temp = expressionStack.pop();
            if (temp.equals("(")){
              break;
            }
            expressionQueue.enqueue(temp);
          }
        }
        else if (t.equals("(")){ //just push an open paren to the stack
          expressionStack.push(t);
        }
        else if (!expressionStack.isEmpty()){ //if an expression is added, but the stack isn't empty
          while(!expressionStack.isEmpty() && presidence(t, expressionStack.peek())){ //check the presidence of the operator and the first one on the stack
            expressionQueue.enqueue(expressionStack.pop()); //pop it and enqueue if t has a greater presidence
          }
        expressionStack.push(t); //finally push t to the stack
      }
      else{ //otherwise, to the stack it goes.
        expressionStack.push(t);
      }
    }
    else{ //its a number, to the queue
      expressionQueue.enqueue(t);
    }
  }
  while (!expressionStack.isEmpty()){ //empty the remainder of the stack to the queue
    expressionQueue.enqueue(expressionStack.pop());
  }
  return expressionQueue; //return the queue
}

public boolean presidence(String a, String b){ //check 2 opperator presidences, if A > B return true
  int presA = 0;
  int presB = 0;
  String top[] = {"^"}; //will have top presidence, in this case 8
  String mul[] = {"*", "/", "%"}; //will have presidence 7
  String add[] = {"+", "-"}; //presidence 6
  String not[] = {"!"}; //presidence 5
  String com[] = {"<", ">"}; //presidence 4
  String equ[] = {"="}; //presidence 10
  String and[] = {"&"}; //presidence 2
  String or[] = {"|"}; //presidence 1
  String paren[] = {"(", ")"};
  for (String o : top){
    if (a.equals(o))
    presA = 6;
    if (b.equals(o))
    presB = 6;
  }
  for (String o : mul){
    if (a.equals(o))
    presA = 7;
    if (b.equals(o))
    presB = 7;
  }
  for (String o : add){
    if (a.equals(o))
    presA = 8;
    if (b.equals(o))
    presB = 8;
  }
  for (String o : not){
    if (a.equals(o))
    presA = 5;
    if (b.equals(o))
    presB = 5;
  }
  for (String o : com){
    if (a.equals(o))
    presA = 4;
    if (b.equals(o))
    presB = 4;
  }
  for (String o : equ){
    if (a.equals(o))
    presA = 10;
    if (b.equals(o))
    presB = 10;
  }
  for (String o : and){
    if (a.equals(o))
    presA = 2;
    if (b.equals(o))
    presB = 2;
  }
  for (String o : or){
    if (a.equals(o))
    presA = 1;
    if (b.equals(o))
    presB = 1;
  }

  for (String o : paren){ //it will never be true if either are a paren.
    if (a.equals(o))
    return false;
    if (b.equals(o))
    return false;
  }
  if (presA > presB)
    return true;
  else
    return false;
}

public String[] tokenize(String t){ //split the string up into its tokens
  //System.out.println(t.length());
  String[] res = new String[t.length() + 1]; //set up an array to store them, there cannot be more tokens than there are chars in the string so this works.
  int pos = 0; //set the position to insert into the result array
  String temp = ""; //set up the temp string
  for (int i = 0; i<t.length(); i++){ //for each char
    if(i == (t.length()-1)){ //if you are at the last one
      if (Calc.operator(String.valueOf(t.charAt(i)))){ //and its an opperator
        res[pos] = temp; //push the temp onto the array
        temp ="";
        pos++;
      }
      temp = temp+t.charAt(i); //then add the opperator
      res[pos] = temp;
      temp = "";
      pos++;
    }
    else if(t.charAt(i) == ' '){ //if its a space, push temp to the array
      res[pos] = temp;
      temp ="";
      pos++;
    }
    else if (Calc.operator(String.valueOf(t.charAt(i)))){ //if its an opperator
      if (!(temp.equals(""))){ //if temp isn't empty
      res[pos] = temp; //push temp to the array
      temp ="";
      pos++;
    }

    if(String.valueOf(t.charAt(i)).equals("-")){
      if (i == 0){
        temp = temp + t.charAt(i);
      }
      else if(Calc.operator(String.valueOf(t.charAt(i-1))) && !String.valueOf(t.charAt(i-1)).equals(")")){
        temp = temp + t.charAt(i);
      }
      else {
        if(temp != ""){
          res[pos] = temp;
          pos++;
        }
        res[pos] = String.valueOf(t.charAt(i));
        pos++;
      }
    }
    else{
      res[pos] = String.valueOf(t.charAt(i)); //add the opperator
      temp = "";
      pos++;
    }
  }
  else{
    temp = temp+t.charAt(i); //otherwise add the char to the temp
  }
}
return res; //return the resulting array.
}
public String noSpace(String s){
  String temp = "";
  for (int i=0; i<s.length(); i++){
    if (s.charAt(i) != ' '){
      temp += String.valueOf(s.charAt(i));
    }
  }
  return temp;
}
}
