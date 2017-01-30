/*
 * Rajat Kuthiala
 * Project 4
 * CSC-172
 * TA: Shuyang Liu
 * 
 */

public class Node implements Comparable<Node>{
  String name;
  int num;
  double lon;
  double lat;
  Node connection;

  boolean known;
  double distance;
  Node parent;

  String setParent;

  public Node(String n, int spot, double lo, double la){
    num = spot;
    name = n;
    lon = lo;
    lat = la;
    known = false;
    distance = Double.POSITIVE_INFINITY;
    parent = null;
  }
  public Node(){
    known = false;
    distance = Double.POSITIVE_INFINITY;
    parent = null;
  }

  public Node(String n){
    name = n;
    known = false;
    distance = Double.POSITIVE_INFINITY;
    parent = null;
  }

  public boolean equals(Node that){
    if (this.name.equals(that.name)){
      return true;
    }
    return false;
  }

  public int compareTo (Node that){
    if (this.distance > that.distance){
      return 1;
    }
    else if (this.distance < that.distance){
      return -1;
    }
    else{
      return 0;
    }
  }
}
