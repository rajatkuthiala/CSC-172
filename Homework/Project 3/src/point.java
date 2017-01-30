
public class point {
  double x;
  double y;

  line parent;
  public point (double xval, double yval){ //set up the point with an x & y value
    setX(xval);
    setY(yval);
  }

  public double getX(){ // get the x value
    return x;
  }
  public double getY(){ //get the y value
    return y;
  }

  public void setX(double a){ //set the x value
    if (a >= 0 && a <= 1 && y !=-10){
      x = a;
    }
    else{
      x = -10; //a value for invalid points, should really throw an error, but, I'll fix it later
      y = -10;
    }
  }
  public void setY(double a){ //set the y value
    if (a >= 0 && a <= 1 && x != -10){
      y = a;
    }
    else{
      y = -10; //a value for invalid points should throw an error, but I'll fix it later
      x = -10;
    }
  }

  public boolean equals(Object o){ //test the points equality
    point b = (point) o;
    if (this.x == b.x && this.y == b.y){
      return true;
    }
    return false;
  }
  public String toString() { //to string method for printing them out
    String ans = String.format("(%.4f, %.4f)", this.getX(), this.getY());

    return (ans);
  }
}
