public class Calc {
  public static Double calc(Queue<String> expressionQueue){ //overhead of the calculations
    Stack<String> expressionStack = new Stack<String>(); //set up a new stack to use
    while (!expressionQueue.isEmpty()){ //while there is stuff in the queue
      if (operator(expressionQueue.peek())){ //if it is an opperator
        String ex = expressionQueue.dequeue();
        String a;
        String b;
        if(ex.equals("!")){ //if it is a 'not'
          a = expressionStack.pop(); //get one item
          b = ""; //this one doesn't matter
        }
        else{ //otherwise
          a = expressionStack.pop(); //get two items
          b = expressionStack.pop();
        }
        expressionStack.push(math(a,b,ex)); //add the result to the stack
      }
      else{
        expressionStack.push(expressionQueue.dequeue()); //its a number, to the stack
      }
    }
    return (new Double(expressionStack.pop())); //return the final ans, from the stack.
  }

  public static boolean operator(String t){ //check to see if something is an operator
    String[] op = {"+", "-", "*", "/", "(", ")", "<", ">", "=", "&", "|", "!", "%", "^"};
    for (String o : op){ //if its in the list it is
      if (o.equals(t))
      return true;
    }
    return false; //otherwise its not
  }

  public static String math(String a, String b, String ex){ //handles the math
    if (ex.equals("!")){ //if its not
      if(a.equals("1"))
        return("0");
      return ("1");
    }
    Double newA = new Double(a); //set up Doubles to work with
    Double newB = new Double(b);
    if (ex.equals("=")){ //equality
      if(newA.equals(newB))
        return("1");
      return ("0");
    }
    if (ex.equals("<")){ //less than
      if(newB < newA)
        return("1");
      return ("0");
    }
    if (ex.equals(">")){ //greater than
      if(newB > newA)
        return("1");
      return ("0");
    }
    if (ex.equals("&")){ //and
      if(!a.equals("0") && !b.equals("0"))
        return("1");
      return ("0");
    }
    if (ex.equals("|")){ //or
      if(!a.equals("0") || !b.equals("0"))
        return("1");
      return ("0");
    }
    else if (ex.equals("^")){
      double ans = 1;
      for (int i = 0; i < newA; i++){
        ans *= newB;

      }
      return "" + ans;
    }
    else if (ex.equals("+")){ //plus
      return ("" + (newA + newB));
    }
    else if (ex.equals("-")) //minus
      return("" + (newB - newA));
    else if (ex.equals("*")) //times
      return("" + (newB * newA));
    else if (ex.equals("/")) //divide
      return("" + (newB / newA));
    else if (ex.equals("%")) //divide
      return("" + (newB % newA));
    else
      return ""; //if it ever hits here, something went very, very wrong....
  }
}
