package CITS2200;

import CITS2200.Stack;

import java.util.EmptyStackException;


import CITS2200.Overflow;
import CITS2200.Underflow;

public class StackBlock implements Stack {
	// TODO: Add any member variables you need
	private Object[] a;
	private int index;
	private int size;
	public StackBlock() {
		// TODO Auto-generated constructor stub
	}

	public StackBlock(int size) {
		// TODO: Construct StackBlock of given size
		this.a = new Object[size];
		this.index = -1;
		this.size=size;

	}

	public boolean isEmpty() {
		// TODO: Implement isEmpty()
		/*if(index<0){
			return true;
		}
		return false;*/
		return index==-1;
	}

	public boolean isFull() {
		// TODO: Implement isFull()
		/*if(index>=a.length-1){
			return true;
		}
		return false;*/
		return index==size-1;
	}

	public void push(Object item) throws Overflow {
		// TODO: Implement push()
		if (isFull()) {
			Overflow e =new Overflow("full");
			throw e;
					
		}
		index++;
		a[index] = item;
	}

	public Object examine() throws Underflow {
		// TODO: Implement examine()
		if(isEmpty()){
		Underflow e =new Underflow(null);
		throw e;
		}
		return a[index];
	}

	public Object pop() throws Underflow {
		// TODO: Implement pop()
		if(index<0){
			Underflow e =new Underflow("empty");
			throw e;
		}
		return a[index--];

	}
}
