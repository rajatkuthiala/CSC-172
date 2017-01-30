/*
 * Rajat Kuthiala
 * Project 4
 * CSC-172
 * TA: Shuyang Liu
 * 
 */


public class Edge implements Comparable<Edge>{
  String name;
  String v;
  String w;
  double weight;

  public Edge(String n, String x, String y, double we){
    name = n;
    v = x;
    w = y;
    weight = we;
  }

  public int compareTo(Edge that){
    if(weight == that.weight){
      return 0;
    }
    else if (weight > that.weight){
      return 1;
    }
    else{
      return -1;
    }
  }
}
