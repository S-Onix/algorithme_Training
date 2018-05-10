package ArrayGravity;

public class QueueEx {
	int front, rear;
	Object queue[];
	public QueueEx(int size) {
		this.queue = new Object[size];
		this.front = -1;
		this.rear = -1;
	}
	
	public void enQueue(Object item) {
		if(!isFull())
			queue[++rear] = item;
		else System.out.println("Queue is Full. can't enQueue");
	}
	
	public Object deQueue() {
		if(!isEmpty()) {
			return queue[++front];
		}else return false;
	}
	
	public boolean isFull() {
		if(rear == (queue.length-1))
			return true;
		else return false;
	}
	
	public boolean isEmpty() {
		if(front == rear) return true;
		else return false;
	}
	
	public Object Qpeek() {
		if(isEmpty()) return false;
		else return queue[front+1];
	}
	
}
