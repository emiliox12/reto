package model.data_structures;

public class Nodo<T extends Comparable<T>> {

	public Nodo next;
	private T element;
	
	public Nodo(T element) {
		this.element = element;
	}

	public Nodo getNext() {
		return next;
	}
	
	public T getElement() {
		return element;
	}

	public void setElement(T elemnt) {
		this.element = elemnt;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}
}
