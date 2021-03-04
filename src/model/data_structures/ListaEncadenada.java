package model.data_structures;

import java.util.ArrayList;

public class ListaEncadenada<T extends Comparable<T>> implements ILista<T> {

	private Nodo<T> raiz;

	@Override
	public void addFirst(T element) {
		Nodo<T> primeroActual = raiz;
		Nodo<T> newNode = new Nodo<T>(element);
		if (primeroActual == null) {
			raiz = newNode;
		}

		else {
			newNode.setNext(primeroActual);
			raiz = newNode;
		}
	}

	@Override
	public void addLast(T element) {
		Nodo<T> actual = raiz;
		Nodo<T> newNode = new Nodo<T>(element);
		if (raiz == null) {
			raiz = newNode;
			return;
		}
		while (actual.getNext() != null) {
			actual = actual.getNext();
		}
		actual.setNext(newNode);
	}

	@Override
	public void insertElement(T element, int pos) {
		Nodo<T> nodoActual = raiz.getNext();
		Nodo<T> newNode = new Nodo<T>(element);
		int posit = 0;
		Nodo<T> anterior = raiz;

		if (posit == pos - 1) {
			addFirst(element);
		}
		posit++;
		while (nodoActual.getNext() != null && posit <= pos) {

			if (posit == pos) {
				anterior.setNext(newNode);
				newNode.setNext(nodoActual);
			}
			anterior = anterior.getNext();
			nodoActual = nodoActual.getNext();
			posit++;
		}

	}

	@Override
	public T removeFirst() {
		Nodo<T> eliminado = raiz;

		if (raiz.getNext() != null) {
			raiz = raiz.getNext();
		} else {
			raiz = null;
		}

		return (T) eliminado;
	}

	@Override
	public T removeLast() {
		Nodo<T> actual = raiz;
		Nodo<T> rta = null;
		while (actual.getNext() != null) {
			rta = actual;
			if (actual.getNext() == null) {
				actual = null;
			}
			actual = (Nodo<T>) actual.getNext();
		}

		return (T) rta;
	}

	@Override
	public T deleteElement(int pos) {
		// TODO Auto-generated method stub

		Nodo<T> actual = raiz.getNext();
		Nodo<T> anterior = raiz;
		Nodo<T> siguiente;
		int posit = 0;
		if (posit == pos - 1) {
			removeFirst();
		}

		while (actual.getNext() != null && posit <= pos) {

			if (posit == pos) {
				siguiente = actual.getNext();
				anterior.setNext(siguiente);
				actual.setNext(null);
			}
			anterior = anterior.getNext();
			actual = actual.getNext();
			posit++;
		}

		return (T) actual;
	}

	@Override
	public T firstElement() {
		return raiz.getElement();
	}

	@Override
	public T lastElement() {

		Nodo<T> actual = raiz;

		while (actual.getNext() != null) {
			actual = actual.getNext();
		}
		return actual.getElement();
	}

	@Override
	public T getElement(int pos) {

		Nodo<T> actual = raiz.getNext();
		int posit = 0;
		T rta = null;
		if (posit == pos - 1) {
			firstElement();
		}
		while (actual.getNext() != null && posit != pos - 1) {

			if (posit == pos) {
				rta = actual.getElement();
			}
			actual = (Nodo<T>) actual.getNext();
			posit++;
		}

		return (T) rta;

	}

	@Override
	public int size() {

		Nodo<T> actual = raiz;
		int rta = 0;
		if (raiz != null) {
			while (actual != null) {
				rta++;
				actual = (Nodo<T>) actual.getNext();
			}
		}

		return rta;
	}

	@Override
	public boolean isEmpty() {
		boolean rta = true;
		if (size() > 0) {
			rta = false;
		}
		return rta;
	}

	@Override
	public int isPresent(T element) {
		int rta = 0;
		Nodo<T> actual = raiz;
		while (actual != null) {
			if (actual.getElement().equals(element)) {
				rta = 1;
			}
			actual = (Nodo<T>) actual.getNext();
		}

		return rta;
	}

	@Override
	public void exchange(int pos1, int pos2) {

		ArrayList<Nodo<T>> arregloTemporal = new ArrayList<Nodo<T>>();
		Nodo<T> actual = raiz;

		while (actual != null) {
			arregloTemporal.add(actual);
			actual = actual.getNext();
		}
		Nodo<T> uno = arregloTemporal.get(pos1);
		Nodo<T> dos = arregloTemporal.get(pos2);
		Nodo<T> anteriorUno = arregloTemporal.get(pos1 - 1);
		Nodo<T> anteriorDos = arregloTemporal.get(pos2 - 1);

		if (uno != null && dos != null) {
			Nodo<T> Siguiente1 = uno.getNext();
			Nodo<T> Siguiente2 = dos.getNext();
			uno.setNext(Siguiente2);
			dos.setNext(Siguiente1);
			anteriorUno = dos;
			anteriorDos = uno;
		}
	}

	@Override
	public void changeInfo(int pos, T elem) {
		// TODO Auto-generated method stub
		Nodo<T> actual = raiz;
		int posit = 0;
		while (actual.getNext() != null && posit <= pos - 1) {

			if (posit == pos - 1) {
				actual.setElement(elem);
			}
			actual = actual.getNext();
		}
	}

	@Override
	public String toString() {
		Nodo<T> actual = raiz;
		String result = "";
		if (raiz == null)
			return "";
		while (actual.next != null) {
			result += " " + actual;
		}
		return result;
	}

	@Override
	public ListaEncadenada<T> sublista(int numElementos) {
		ListaEncadenada<T> rta = new ListaEncadenada<>();
		if (numElementos == 0) {
			return rta;
		}
		ListaEncadenada<T> newLinkedlist = new ListaEncadenada<>();
		Nodo<T> nuevoRaiz = new Nodo<T>(null);
		newLinkedlist.raiz = nuevoRaiz;
		Nodo<T> original = raiz;
		nuevoRaiz = original;

		while (original.getNext() != null && newLinkedlist.size() <= numElementos) {

			if (newLinkedlist.size() != numElementos) {
				nuevoRaiz.setNext(original.getNext());
			}
			original = original.getNext();
		}
		rta = newLinkedlist;
		return rta;
	}

	@Override
	public ListaEncadenada<T> subList(int pos, int size) {
		ListaEncadenada<T> result = new ListaEncadenada<>();
		int listSize = (size - pos > size()) ? size() : size;
		if (size == 0 || raiz == null) {
			return result;
		}
		Nodo<T> actual = raiz;
		for (int i = 0; i < pos; i++) {
			if (actual.getNext() != null) {
				actual = actual.getNext();
			} else {
				return result;
			}
		}
		System.out.println(actual);
		for (int i = 0; i < listSize; i++) {
			result.addLast(actual.getElement());
			actual = actual.getNext();
		}
		return result;
	}
}