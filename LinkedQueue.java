//package postfix;
// Name: Weiting Li, Lopsii Olagoke, Max Sotsky, Ayomide Adekiitan, Ayomide Adekiitan
public class LinkedQueue implements QueueADT {
	 /**
	  *  Attributes
	  */
	private int size;
	private Node front, rear;
	
	private static class Node {
		private Object data;
		private Node next;

		Node(Object data) {
			this.data = data;
			next = null;
		}

		public Node getNext() {
			return this.next;
		}

		public void setNext(Node nextRef) {
			this.next = nextRef;
		}

		public Object getData() {
			return this.data;
		}
	}
	
	/** 
	 * Constructor
	 */
	public LinkedQueue() {
		size = 0;
		front = rear = null;
	}
	
	/** 
	 * Add the given value to the queue 
	 * */
	public void enqueue(Object elt) {
		Node addNode = new Node(elt);
		if (isEmpty()) 
			front = addNode;
		else
			rear.setNext(addNode);
		rear = addNode;
		size++;
	}
	
	
	/** 
	 * Remove and return the value from the front of the queue 
	 * Assumes that your queue is not empty. 
	 * */
	
	public Object dequeue() {
		if (size == 0) throw new java.util.NoSuchElementException();
		Object result = front.getData();
		front = front.getNext();
		size--;
		if (isEmpty())
			rear = null;
		return result;
	}
	
	/** 
	 * Return the value that dequeue would provide without modifying the queue 
	 * */
	
	public Object peek() {
		return front.getData();
	}
	
	/** 
	 * Does the queue have any more elements 
	 * */
	
	public boolean isEmpty() {
		return (front==null);
	}
	
	/** 
	 * How many elements are in the queue? 
	 * */
	
	public int getSize() {
		return size;
	}

	public boolean isFull(){
		return false;
	}

	public void clear(){
		front = null;
	}

	@Override
	public String toString(){
		String str = "";
		Node curr = front;
		while(curr!=null){
			str+= curr.getData();
			curr = curr.getNext();
		}
		return str;
	}

}
