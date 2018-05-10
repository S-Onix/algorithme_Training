package ArrayGravity;

public class LinkedQueue {

	class Node {
		Node nextNode;
		Object item;
		public Node(Object item) {
			this.item = item;
			nextNode = null;
		}
	}
	
	private Node front;
	private Node rear;
	
	public LinkedQueue() {
		this.front = null;
		this.rear = null;
	}
	
	public boolean isEmpty() {
		return (front==null);
	}
	
	public void enQueue(Object item) {
		Node node = new Node(item);
		
		if(isEmpty()){
			front = node;
			rear = node;
		}else {
			rear.nextNode = node;
			rear = node;
		}
	}
	public Object deQueue() {
		if(isEmpty()) {
			return false;
		}else {
			Object item = front.item;
			front = front.nextNode;
			if(front == null) {
				rear = null;
			}
			return item;
		}
	}
	public Object qPeek() {
		if(isEmpty()) return false;
		else return front.item;
	}
}
