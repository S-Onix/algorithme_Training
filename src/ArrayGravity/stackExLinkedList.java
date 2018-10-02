package ArrayGravity;

public class stackExLinkedList {
	private Node top;

	private class Node {
		private Object data;
		private Node nextNode;

		public Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}
	
	public stackExLinkedList() {
		this.top = null;
	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	public void push(Object item) {
		Node newNode = new Node(item);
		newNode.nextNode = top;
		top = newNode;
	}
	
	
	public Object pop() {
		Object item = top.data;
		top = top.nextNode;
		return item;
	}

}
