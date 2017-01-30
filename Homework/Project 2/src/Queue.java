//Code taken from previus Lab
public class Queue<AnyType>{
  private Node<AnyType> start;
  private Node<AnyType> end;

  public Queue(){ //initalize the start and end node and have them point to each other
    start = new Node<AnyType>();
    end = new Node<AnyType>();
    start.next = end;
    end.prev = start;
  }

  public void clear(){
    start.next = end;
    end.prev = start;
  }
  public void insert(AnyType x){

    if (lookup(x)){ //has O(n)
      return;
    }
    //rest is all constant
    Node<AnyType> e = end;
    Node<AnyType> in = new Node<AnyType>();
    in.data = x;
    in.prev = e.prev;
    in.next = e;
    e.prev.next = in;
    e.prev = in;
  }

  public void delete(AnyType x){
    if (lookup(x)){ //check to see the element is in there
      Node<AnyType> e = start;
      while(e.next.next != null){ //run through the elements
        if (e.next.data == x){ //ounce found remove it
          e.next.next.prev = e;
          e.next = e.next.next;
          return;
        }
        e = e.next;
      }
    }
  }
  public boolean lookup(AnyType x){
    Node<AnyType> e = start;
    while (e.next != null){ //run through the elements and check the data
      if (e.next.data == x){
        return true;
      }
      e = e.next;
    }
    return false;
  }
  public boolean isEmpty(){
    return (start.next.next == null);
  }
  public void printList(){
    Node<AnyType> e = start;
    while (e.next.next != null){ //run through the elements and print each one
      System.out.printf(e.next.data + ", ");
      e = e.next;
    }
    System.out.println();
  }
  public void printListRev(){
    Node<AnyType> e = end;
    while (e.prev.prev != null){ //run through the elements backwards printing each one
      System.out.printf(e.prev.data + ", ");
      e = e.prev;
    }
    System.out.println();
  }
  public void enqueue(AnyType x){
    insert(x);
  }
  public AnyType dequeue(){
    if(! isEmpty()){
      AnyType ans = firstItem();
      Node<AnyType> e = start;
      e.next.next.prev = e;
      e.next = e.next.next;
      return ans;
    }
    else{
      return null;
    }
  }
  public AnyType peek(){
    if (! isEmpty()){
      return firstItem();
    }
    else{
      return null;
    }
  }
  public AnyType firstItem (){
    return start.next.data;
  }
}
