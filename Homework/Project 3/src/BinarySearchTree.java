
public class BinarySearchTree{
  private MyTreeNode root; //define the root node

  public BinarySearchTree(){ // make the tree on setup
    root = new MyTreeNode();
  }
  public MyTreeNode getRoot(){ // get the root
    return root;
  }
  public void insert(line in){ //insert a line
    if (root.data == null){
      root.data = in;
    }
    else{
      root.insertLine(root, in);
    }
  }

  public void printPreOrder(){ //print methods for testing
    if (root.data != null)
      root.printPreOrder();
  }

  public void printInOrder(){
    if (root.data != null)
      root.printInOrder();
  }
  public void printPostOrder(){
    if(root.data != null)
      root.printPostOrder();
  }

  public boolean sameRegion(point a, point b){ //check if two points are in the same region
      if (a.equals(new point(-10, -10)) || b.equals(new point(-10, -10))){
        System.out.println("One of the points was invalid, cannot calculate");
        return false;
      }
      else if (root.data == null){
        System.out.println("They are in the same region.");
        return true;
      }
      else {
        line ab = new line(a, b);
        root.pointCheck(root, ab);
      }
      return true;
  }

  public void clear (){ // clear the tree
    root.data = null;
    root.rightChild = null;
    root.leftChild = null;
  }

  public MyTreeNode lookup(line x){ //lookup
    if (root.data !=null)
      return root.lookup(x);

    return null;
  }

  public int externalNode (){
    if(root.data == null){
      return 0;
    }
    return root.externalNode(root);
  }

  public int externalPath(){
    if(root.data == null){
      return 0;
    }
    else{
      return root.externalPath(root);
    }
  }
}
