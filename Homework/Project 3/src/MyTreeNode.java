
public class MyTreeNode{
  public line data;
  public MyTreeNode leftChild;
  public MyTreeNode rightChild;
  public MyTreeNode parent;

  public MyTreeNode insertLine(MyTreeNode n, line in){ //insert a line.
    if (n == null){ //null node, insert
      n = new MyTreeNode();
      n.data = in;
      return n;
    }
    else if (n.data.equals(in)){ //equivelent node found, break out.
      return n;
    }
    else if (!(Geometry.intersect(n.data, in).equals(new point(-10,-10)))){ //if they intersect, both sides
      point inter = Geometry.intersect(n.data, in);
      if(Geometry.ccw(in.start, n.data.start, n.data.end) == Geometry.direction.COUNTERCLOCKWISE){
        n.rightChild = insertLine(n.rightChild, new line (inter, in.start));
        n.rightChild.parent = n;
        n.leftChild = insertLine(n.leftChild, new line (in.end, inter));
        n.leftChild.parent = n;
      }
      else{
        n.leftChild = insertLine(n.leftChild, new line (inter, in.start));
        n.leftChild.parent = n;
        n.rightChild = insertLine(n.rightChild, new line (in.end, inter));
        n.rightChild.parent = n;
      }
    }
    else if(Geometry.ccw(in.end, n.data.start, n.data.end) == Geometry.direction.COUNTERCLOCKWISE){ //right
      n.rightChild = insertLine(n.rightChild, in);
      n.rightChild.parent = n;
    }
    else if(Geometry.ccw(in.end, n.data.start, n.data.end) == Geometry.direction.CLOCKWISE){ //left
      n.leftChild = insertLine(n.leftChild, in);
      n.leftChild.parent = n;
    }
    else if(Geometry.ccw(in.end, n.data.start, n.data.end) == Geometry.direction.COLINEAR){ //same line
      n = new MyTreeNode();
      n.data = in;
      return n;
    }
    else{
      return null;
    }

    return n;
  }

  public void printInOrder(){ //prints
    if(leftChild !=null)
      leftChild.printInOrder();
    System.out.println(data);
    if (rightChild !=null)
      rightChild.printInOrder();
  }

  public void printPostOrder(){
    if(leftChild !=null)
      leftChild.printPostOrder();

    if (rightChild !=null)
      rightChild.printPostOrder();
    System.out.println(data);
  }
  public void printPreOrder(){
    System.out.println(data);
    if(leftChild !=null)
      leftChild.printPreOrder();

    if (rightChild !=null)
      rightChild.printPreOrder();
  }

  public MyTreeNode lookup(line x){ //lookup a line, never used...
    if (this == null){
      return null;
    }
    else if (x.equals(data)){
      return this;
    }
    else if (Geometry.ccw(this.data.start, x.start, this.data.end) == Geometry.direction.COUNTERCLOCKWISE)
      return rightChild.lookup(x);
    else if (Geometry.ccw(this.data.start, x.start, this.data.end) == Geometry.direction.CLOCKWISE)
      return leftChild.lookup(x);

    return null;
  }

  public void pointCheck(MyTreeNode n, line x){
    if (n == null){ //null node, insert
      System.out.println("They are in the same region");
    }
    else if (n.data.equals(x)){ //equivelent node found, break out.
      System.out.println("The points are on the line: " + n.data);
    }
    else if (!(Geometry.intersect(n.data, x).equals(new point(-10,-10)))){ //if they intersect, both sides
      point inter = Geometry.intersect(n.data, x);
      System.out.println("The points are seperated by the line: " + subDivide(n,x));

    }
    else if(Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.COUNTERCLOCKWISE){ //right
      pointCheck(n.rightChild, x);
    }
    else if(Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.CLOCKWISE){ //left
      pointCheck(n.leftChild, x);
    }
    else if(Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.COLINEAR){ //same line
      System.out.println("One of these points falls on a line");
    }
    else{
      System.out.println("I'm sorry, something has gone terribly wrong."); //you should never hit this point.
    }

  }

  public int externalNode(MyTreeNode n){ //count the number of external nodes
    if (n == null){
      return 0;
    }
    else if(n.leftChild == null & n.rightChild == null){ //no children, external node
      return 1;
    }

    else{
      return externalNode(n.leftChild) + externalNode(n.rightChild);
    }
  }

  public int externalPath(MyTreeNode n){ //get the length of the external paths
    MyTreeNode backup = n;
    if (n == null){
      return 0;
    }
    int lpath = 0;
    while (n != null){
      lpath++;
      n = n.leftChild;
    }
    int rpath = 0;
    while (backup != null){
      rpath++;
      backup = backup.leftChild;
    }
    return Math.max(lpath, rpath); //return the longest path
  }

  //Ok, so my method already return fragments of lines, but not the smallest possible fragments of lines, so here is this, terribly written abominiation.

  public line subDivide(MyTreeNode n, line l){
    line t = n.data; //store the line
    while (true){ //while we still can
      if(n.leftChild == null && n.rightChild == null){
        break; //break when there is nowhere left to go
      }
      //should just check if point is invalid, why did I do this?
      else if(n.leftChild == null && Geometry.endTest(n.data, n.rightChild.data).equals(new point(-10,-10))){ //if the left child is null, and the point isn't valid
        break;
      }
      else if(n.rightChild == null && Geometry.endTest(n.data, n.leftChild.data).equals(new point(-10,-10))){ //right child null point isn't valid
        break;
      }
      else if(n.leftChild == null){ //if the left child is null jsut check the right
        point temp = Geometry.endTest(n.data, n.rightChild.data);
        if (!(Geometry.intersect(new line (n.data.start, temp), l).equals(new point(-10,-10)))){
          t = new line(n.data.start, temp);
        }
        else{
          t = new line(temp, n.data.end);
        }
        n = n.rightChild;
      }

      else if(n.rightChild == null){ //if the right is null just check the left
        point temp = Geometry.endTest(n.data, n.leftChild.data);
        if (!(Geometry.intersect(new line (n.data.start, temp), l).equals(new point(-10,-10)))){
          t = new line(n.data.start, temp);
        }
        else{
          t = new line(temp, n.data.end);
        }
        n = n.leftChild;
      }
      //Should update else to allow for both children to be checked w/o the continue...
      else{ //otherwise check them both
        point temp = Geometry.endTest(n.data, n.leftChild.data); //find the point of intsection between the line and its children
        point rtemp = Geometry.endTest(n.data, n.rightChild.data);
        if (!(temp.equals(new point (-10, -10)))){ //if not an invalid point, check left child possibilities
          if (!(Geometry.intersect(new line (n.data.start, temp), l).equals(new point(-10,-10)))){
            t = new line(n.data.start, temp);
            n = n.leftChild;
            continue;
          }
          else if (!(Geometry.intersect(new line (n.data.end, temp), l).equals(new point(-10,-10)))){
            t = new line(n.data.end, temp);
            n = n.leftChild;
            continue;
          }
        }
        if (!(rtemp.equals(new point (-10, -10)))){//if not an invalid point, check right child
          if (!(Geometry.intersect(new line (n.data.start, rtemp), l).equals(new point(-10,-10)))){
            t = new line(n.data.start, rtemp);
            n = n.rightChild;
            continue;
          }
          else if (!(Geometry.intersect(new line (n.data.end, rtemp), l).equals(new point(-10,-10)))){
            t = new line(n.data.end, rtemp);
            n = n.rightChild;
            continue;
          }

          break; //so this also should never really be hit, but when it is it is because of (as far as I could tell) rounding errors in the math.
        }
        else{
          System.out.println("This line cannot be broken down more, due to issues with the mathematcal rounding");
          return t;
        }
      }
    }
    return t;
  }
}
