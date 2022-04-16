package CITS2200;

import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

public class DequeCyclic<E> implements Deque<E> {
	// TODO: Add any member variables you need
	private E[] obj;
	private int front;
	private int rear;
	private int size;

	@SuppressWarnings("unchecked")
	public DequeCyclic(int size) {
		// TODO: Construct empty DequeCyclic of given size
		obj = (E[]) new Object[size + 1];
		front = 0;
		rear = 0;
		this.size = 0;

	}

	public boolean isEmpty() {
		// TODO: Implement isEmpty()
		return front == rear && size == 0;
	}

	public boolean isFull() {
		// TODO: Implement isFull()
		return (rear + 1) % obj.length == front;
	}

	public void pushLeft(E item) throws Overflow {
		// TODO: Implement pushLeft()
		if (isFull()) {
			throw new Overflow("full");
		}
		front = (front - 1 + obj.length) % obj.length;
		obj[front] = item;
		size++;
	}

	public void pushRight(E item) throws Overflow {
		// TODO: Implement pushRight()
		if (isFull()) {
			throw new Overflow("full");
		}
		obj[rear] = item;
		rear = (rear + 1) % obj.length;
		size++;
	}

	public E peekLeft() throws Underflow {
		// TODO: Implement peekLeft()
		if(isEmpty()){
			throw new Underflow("empty");
		}
		return obj[front];

	}

	public E peekRight() throws Underflow {
		// TODO: Implement peekRight()
		if(isEmpty()){
			throw new Underflow("empty");
		}
		return obj[(rear-1+obj.length)%obj.length];
	}

	public E popLeft() throws Underflow {
		// TODO: Implement popLeft()
		if (isEmpty()) {
			throw new Underflow("empty");
		}
		E ret =obj[front];
		front=(front+1)%obj.length;
		size--;
		return ret;
		
		
	}

	public E popRight() throws Underflow {
		// TODO: Implement popRight()
		if (isEmpty()) {
			throw new Underflow("empty");
		}
		rear =(rear-1+obj.length)%obj.length;
		E ret =obj[rear];
		size--;
		return ret;
	}
}