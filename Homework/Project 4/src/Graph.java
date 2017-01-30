/*
 * Rajat Kuthiala
 * Project 4
 * CSC-172
 * TA: Shuyang Liu
 * 
 */


import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Graph {
  static Scanner in;
  private int vertexCount;
  private int edgeCount;
  PriorityQueue<Node> dijkstasQueue;


  ArrayList<Node> sp;
  ArrayList<Edge> mst;
  HashMap<String, Node> nodeMap;
  HashMap<String, Edge> edgeMap;

  boolean directed;
  private boolean adj[][];
  double dist;

  GraphNode adjNode[];
  HashMap<String, GraphNode> adjNodeMap;

  public double weight[][];

  public Graph () {
    nodeMap = new HashMap<String, Node>();
    edgeMap = new HashMap<String, Edge>();
    adjNodeMap = new HashMap<String, GraphNode>();
    dijkstasQueue = new PriorityQueue<Node>();
    sp = new ArrayList<Node>();
    edgeCount = 0;
  }

  public void buildAdjNode(int numV){
    adjNode = new GraphNode[numV];
    int i = 0;
    for(String k : nodeMap.keySet()){
      if(k != null){
        adjNode[i] = new GraphNode(k);
        i++;
      }
    }
  }

  public void setVertexCount(int v){
    vertexCount = v;
  }
  public boolean isDirected(){
    return directed;
  }
  public int vertices(){
    return vertexCount;
  }
  public int edges(){
    return edgeCount;
  }

  public void insertList(String a, String b, double lb, String rdName){
    GraphNode g = adjNodeMap.get(a);
    if(g == null){
      adjNodeMap.put(a, new GraphNode(a));
      g = adjNodeMap.get(a);
    }
    g.insert(g,b,lb, g.id, rdName);

    g = adjNodeMap.get(b);
    if(g == null){
      adjNodeMap.put(b, new GraphNode(b));
      g = adjNodeMap.get(b);
    }
    g.insert(g,a,lb, g.id, rdName);
  }

  public boolean connected (Node node1, Node node2){

    GraphNode t = adjNodeMap.get(node1.name);
    if (t == null){
      return false;
    }
    return t.lookup(t, node2.name);

  }

  public double getNodeWeight (Node node1, Node node2){
    GraphNode t = adjNodeMap.get(node1.name);
    if (t == null){
      return Double.POSITIVE_INFINITY;//should never happen
    }
    return t.lookupWeight(t, node2.name);
  }


  public void shortPath(String a, String b, boolean print) throws Exception{
    dist = 0;
    if(a.equals(b)){
      System.out.println ("Those are the same point.");
      throw new Exception();
    }

    else{
      Node aa = nodeMap.get(a);
      Node bb = nodeMap.get(b);
      dijksra(aa, bb);
      shortHelper(aa, bb, print);
      if(print){
        System.out.println(" " + bb.distance*69 + " miles");
      }
    }
  }

  public void parentPrinter(){
    for(Node n : nodeMap.values()){
      System.out.println(n.parent);
    }
  }

  public void shortHelper(Node a, Node b, boolean print){
    if(a.name.equals(b.name)){
      if(print){
        System.out.print(a.name + ", ");
      }
      dist = a.distance;
      sp.add(a);
      return;
    }
    else if(b == null){
      System.out.println("There is no path");
      return;
    }
    else if (b.parent == null){
      System.out.println("There is no path");
      return;
    }

    shortHelper(a, b.parent, print);
    if(print){
      System.out.print(b.name + ", ");
    }
    sp.add(b);
  }

  public static Graph createFromFile(String fileName){
    Graph g = new Graph();
    File f = new File(fileName);
    try{
      in = new Scanner(f);
    }catch(Exception e){
      System.out.println("File Not Found");
      return null;
    }
    in.useDelimiter("\\t|\\n");
    int i = 0;
    while(in.hasNext()){
      if (in.next().equals("r")){
        break;
      }
      else{
        String n = in.next();
        double lati = in.nextFloat();
        double longi = in.nextFloat();
        Node t = new Node(n, i, longi, lati);
        g.nodeMap.put(n, t);
      }
      i++;
    }
    g.setVertexCount(i);
    g.setVertexCount(i);
    String n = in.next();
    String d = in.next();
    String s = in.next();
    Node first = g.nodeMap.get(d);
    Node second = g.nodeMap.get(s);
    double lb = getWeight(first, second);
    g.insertList(d, s, lb, n);
    g.edgeMap.put(n, new Edge(n, d, s, lb));
    g.edgeCount++;
    while (in.hasNext()){
      String r = in.next(); //reads in and ignores the 'r'
      String nam = in.next();
      String i1 = in.next();
      String i2 = in.next();
      Node n1 = g.nodeMap.get(i1);
      Node n2 = g.nodeMap.get(i2);
      double lbs = getWeight(n1, n2);
      g.insertList(i1, i2, lbs, nam);
      g.edgeMap.put(nam, new Edge(nam, i1, i2, lbs));
      g.edgeCount++;
    }
    return g;
  }


  public void dijksra (Node v, Node w){ //improved with info from the wikipedia page on Dijkstra's.
    v.distance = 0;
    v.parent = v;
    dijkstasQueue.add(v);

    int i = 0;
    while (dijkstasQueue.size() != 0){ //O(V), but because it runs by weight, the average runtime can be dropped down to O(log(V))
      if(w.known){
        return;
      }
      i++;

      Node t = dijkstasQueue.poll();
      if (t == null){
        System.out.println("Whoop went null"); //should never happen
        return;
      }

      t.known = true;
      long s = System.currentTimeMillis();
      GraphNode l = adjNodeMap.get(t.name);
      GraphNode[] cons = l.getConnections();
      for(GraphNode c : cons){ //O(E), runs for every connection.
        Node j = nodeMap.get(c.id);
        if (j != null){
          if (!(j.known)){
              double cvw = getNodeWeight(t,j);
              if(t.distance + cvw < j.distance){
                j.distance = t.distance + cvw;
                j.parent = t;
                dijkstasQueue.add(j);
              }
          }
        }
      }
      long e = System.currentTimeMillis();
    }
  }

  public Node smallestDistNode(){ //O(2n)
    Node ans = firstNotKnownNode();//O(n)
    if (ans == null){
      return ans;
    }
    for (Node n : nodeMap.values()){

      if(n.distance < ans.distance){
        if (!(n.known)){

          ans = n;
        }
      }
    }
    return ans;
  }

  public Node firstNotKnownNode(){ //O(n)
    for (Node n : nodeMap.values()){

      if (n != null){
        if(!(n.known) && !(n.distance == Double.POSITIVE_INFINITY )){
          return n;
        }
      }
    }
    System.out.println("Woah there, first not known broke");
    return null;
  }

  public ArrayList<Edge> Prim (String s){ //based off of information attained from the wikipedia article on Prim's algorithem.
    Node Start = nodeMap.get(s);
    mst = new ArrayList<>();
    HashMap<String, String> inserted = new HashMap<String, String>();
    ArrayList<Edge> failed = new ArrayList<Edge>();
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    ArrayList<Edge> ed = new ArrayList<Edge>(edgeMap.values());
    Edge first = ed.get(0);
    mst.add(first);
    inserted.put(first.w, first.w);
    inserted.put(first.v, first.v);

    priorityEdgeInsert(pq, first);

    while (inserted.size() <= edges() && pq.size() != 0){ //O(E log(V))
      //runs for E checking the possible V, where the number of V is devided each time, or log(V), giving ELog(V)
      Edge e = pq.poll();
      String w = inserted.get(e.w);
      String v = inserted.get(e.v);

      if ((w == null) ^ (v == null)){
        priorityEdgeInsert(pq, e);
        for(Edge f : failed){
          if(f.v == e.v || f.v == e.w || f.w == e.v || f.w == e.w){

          }
          else{
            pq.add(f);
          }
        }
        failed.clear();
        mst.add(e);
        inserted.put(e.w, e.w); //only puts one, the null one is hashed to a meaningless spot
        inserted.put(e.v, e.v);
      }
      else if ((w == null) && (v == null) ){
        failed.add(e);
      }
      else if (!(w == null) && !(v == null) ){
        failed.remove(e);
        pq.remove(e);
      }
      else if (e == null){
        System.out.println("HOW?"); //should never happen.
      }
    }
    return mst;
  }

  public void priorityEdgeInsert(PriorityQueue<Edge> pq, Edge e){
    GraphNode r = adjNodeMap.get(e.w);
    String rootName = r.id;
    while (true){
      if(r.next == null){
        break;
      }
      else{
        pq.add(new Edge(r.next.road, rootName, r.next.id, r.next.weight));
        r = r.next;
      }
    }

    r = adjNodeMap.get(e.v);
    rootName = r.id;
    while (true){
      if(r.next == null){
        break;
      }
      else{
        pq.add(new Edge(r.next.road, rootName, r.next.id, r.next.weight));
        r = r.next;
      }
    }
  }
  public static double getWeight(Node a, Node b){
    double w = 0;
    double x = Math.abs(b.lat) - Math.abs(a.lat);
    double y = Math.abs(b.lon) - Math.abs(a.lon);
    double c2 = x*x + y*y;
    w = Math.sqrt(c2);
    return w;
  }

  public void mspShow(){
    Atlas window = new Atlas("Test");
    Canvas theMap = new Canvas(nodeMap, edgeMap, mst, sp, 1);
    //window.add(theMap);
    window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit program when the windiow is closed
		window.setResizable(true);
    window.pack(); //prepare window to be displayed
    window.setSize(400,400); //set size
    window.add(theMap);
    window.setVisible(true);
  }
  public void directionShow(){
    Atlas window = new Atlas("Test");
    Canvas theMap = new Canvas(nodeMap, edgeMap, mst, sp, -1);
    //window.add(theMap);
    window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit program when the windiow is closed
		window.setResizable(true);
    window.pack(); //prepare window to be displayed
    window.setSize(400,400); //set size
    window.add(theMap);
    window.setVisible(true);
  }

}
