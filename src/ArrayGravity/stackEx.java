package ArrayGravity;

public class stackEx {
	private int top;
	private int maxSize;
	private Object[] stackArray;
	
	public stackEx(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new Object[maxSize];
		this.top = -1;
	}
	
	public boolean isEmpty() {
		if(top == -1)
			return true;
		else return false;
	}
	
	public boolean isFull() {
		if(top == maxSize-1) return true;
		else return false;
	}
	
	public void push(Object item) {
		if(isFull()) {
			System.out.println("더이상 넣을 수 없습니다.");
		}else {
			stackArray[++top] = item;
		}
			
	}
	
	public Object pop() {
		if(isEmpty()) {
			return false;
		}else {
			Object popItem = stackArray[top];
			top--;
			return popItem;
		}
	}
	

}
