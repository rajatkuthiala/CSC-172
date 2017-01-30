//Code taken from previus Lab
public class Stack<AnyType> {
  private Node<AnyType> start;

  public Stack(){
    start = new Node<AnyType>();
  }

  public void clear(){
    start.next = null;
  }

  public void insert(AnyType x){ //insert item at the end of the list

   if (lookup(x)){ // looks up if the item is already in the list, if it is, does nothing
      return;
    }
    Node<AnyType> in = new Node<AnyType>(); //sets up new Node to add to list
    in.data = x;
    in.next = start.next;
    start.next = in; //adds the new node.
  }

  public AnyType pop() {
    if (! isEmpty()){
      AnyType ans = start.next.data;
      start.next = start.next.next;
      return ans;
    }
    return null;

  }
  public void push(AnyType x){
    Node<AnyType> in = new Node<AnyType>(); //sets up new Node to add to list
    in.data = x;
    in.next = start.next;
    start.next = in; //adds the new node.
  }
  public AnyType peek(){
    if (! isEmpty()){
      return start.next.data;
    }
    return null;
  }

  public void delete(){
    start.next = start.next.next;
    return;
  }
  public boolean lookup(AnyType x){ //originaly returned AnyType, not bool.
    Node<AnyType> e = start;
    while (e.next !=null){ //run through the list
      if (e.next.data == x){ //it the data is found return true
        return true;
      }
      e = e.next;
    }
    return false; //return false if not found
  }

  public boolean isEmpty(){ //check if the list is empty
    return (start.next == null); //if the next element after the starting one is null the list is empty
  }
  public void printList(){ //prints out the elements of the list
    Node<AnyType> e = start;
    while (e.next != null){ //if the next item isn't empty (runs through the list)
      System.out.printf(e.next.data + ", "); //print out the data for the next item
      e = e.next;
    }
    System.out.println();
  }

  public AnyType firstItem(){
    return start.next.data;
  }
}
