package ArrayGravity;

public class CircularQueueEx {
	Object[] cQueue;
	int rear, front;

	public CircularQueueEx(int arraySize) {
		// TODO Auto-generated constructor stub
		this.cQueue = new Object[arraySize];
		this.rear = this.front = 0;
	}

	public boolean isEmpty() {
		if (front == rear)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		if (front == ((rear + 1) % cQueue.length))
			return true;
		else
			return false;
	}

	public void enQueue(Object item) {
		if (!isFull()) {
			rear = (rear + 1) % cQueue.length;
			cQueue[rear] = item;
		} else
			System.out.println("Queue is full. can't enQueue");
	}

	public Object deQueue() {
		if (!isEmpty()) {
			front = (front + 1) % cQueue.length;
			return cQueue[front];
		} else {
			System.out.println("Queue is empty. can't deQueue");
			return false;
		}
	}
}
