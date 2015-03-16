package ru.kpfu.itis.group11408.Miftahutdinova.Mylist;

import java.util.LinkedList;
import java.util.Iterator;

public class Listik {

	private LinkedList<Integer> state;

	public static void main(String[] args) {
		
		LinkedList<Integer> state = new LinkedList<>();
		LinkedList<Integer> state2 = new LinkedList<>();
		
		state2.add(4);
		state2.add(10);
		state2.add(5);
		state2.add(3);
		state2.add(7);
		
		
		state.addFirst(12);
		System.out.println(state);
		state.addLast(24);
		System.out.println();
		System.out.println(state);
		state.getFirst();
		System.out.println();
		System.out.println(state.getFirst());
		state.getLast();
		System.out.println();
		System.out.println(state.getLast());
		state.add(1, 5);
		System.out.println();
		System.out.println(state);
		state.get(2);
		System.out.println();
		System.out.println(state.get(2));
		state.add(8);
		System.out.println();
		System.out.println(state);
		state.equals(state2);
		System.out.println();
		System.out.println("Результаты state.equals(state2) - " + state.equals(state2));
		state.addAll(state2);
		System.out.println();
		System.out.println(state);
		System.out.println();
		System.out.println("Результаты state.addAll(state2) - " + state.addAll(state2));
		state.addAll(3, state2);
		System.out.println();
		System.out.println(state);
		System.out.println("Результаты state.addAll(3, state2) - " + state.addAll(3, state2));
		state.element();
		System.out.println();
		System.out.println(state.element());
		state.contains(3);
		System.out.println();
		System.out.println(state.contains(3));
		state.peekFirst();
		System.out.println();
		System.out.println(state.peekFirst());
		state.peekLast();
		System.out.println();
		System.out.println(state.peekLast());
		state.pollFirst();
		System.out.println();
		System.out.println(state.pollFirst());
		state.pollLast();
		System.out.println();
		System.out.println(state.pollLast());
		state.remove();
		System.out.println();
		System.out.println(state);
		state.remove(4);
		System.out.println();
		System.out.println(state);
		state.remove(3);
		System.out.println();
		System.out.println(state);
		state.removeFirst();
		System.out.println();
		System.out.println(state);
		state.removeLast();
		System.out.println();
		System.out.println(state);
		state.removeFirstOccurrence(12);
		System.out.println();
		System.out.println(state);
		state.set(2, 100);
		System.out.println();
		System.out.println(state);
		state.size();
		System.out.println();
		System.out.println(state.size());
		state.hashCode();
		System.out.println();
		System.out.println(state.hashCode());
		state.clone();
		System.out.println();
		System.out.println(state.clone());
		state.toArray();
		System.out.println();
		System.out.println(state.toArray());
		state.clear();
		System.out.println();
		System.out.println(state);
	}
	
	private boolean add (int e) {
		state.add(e);
		return true;
	}
	
	private void add(int i, int e) {
		state.add(i, e);
	}
	
	private int get(int i) {
		return state.get(i);
	}
	
	private boolean addAll(LinkedList<Integer> a) {
		int m = state.size();
		state.addAll(a);
		int n = state.size();
		if (n == m) {
			return false;
		}else{
			return true;
		}
		
	}
	
	private boolean addAll(int i, LinkedList<Integer> a) {
		int m = state.size();
		state.addAll(a);
		int n = state.size();
		if (n == m) {
			return false;
		}else{
			return true;
		}
	}
	
	private void addFirst(int e) {
		state.add(0, e);
	}
	
	private int getFirst() {
		return state.getFirst();
	}
	
	private void addLast(int e) {
		state.add(e);
	}
	
	private int getLast() {
		return state.getLast();
	}
	
	private void clear() {
		state.clear();
	}
	
	public LinkedList<Integer> clone() {
		return (LinkedList<Integer>) state.clone();
	}
	
	private int element() {
		return state.getFirst();
	}
	
	private boolean contains(int a) {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			if (iter.next() == a) {
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	/*private Iterator<Integer> descendingIterator() {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			return state.descendingIterator();
		}
		return iter;
	}*/
	
	private int peekFirst() {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			if (iter.next() == null) {
				return 0;
			}else{
				return state.getFirst();
			}
		}
		return 0;
	}
	
	private int peekLast() {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			if (iter.next() == null) {
				return 0;
			}else{
				return state.getLast();
			}
		}
		return 0;
	}
	
	private int pollFirst() {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			if (iter.next() == null) {
				return 0;
			}else{
				state.removeFirst();
				return state.getFirst();
			}
		}
		return 0;
	}
	private int pollLast() {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			if (iter.next() == null) {
				return 0;
			}else{
				state.removeLast();
				return state.getLast();
			}
		}
		return 0;
	}
	
	private int remove() {
		state.remove(0);
		return state.getFirst();
	}
	
	private int removeIndex(int i) {
		state.remove(i);
		return state.get(i);
	}
	
	private boolean remove(int e) {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			if (iter.next() == e) {
				state.remove(e);
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	private int removeFirst() {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			if (iter.next() == null) {
				return 0;
			}else{
				int m = state.getFirst();
				state.removeFirst();
				return m;
			}
		}
		return 0;
	}
	
	private int removeLast() {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			if (iter.next() == null) {
				return 0;
			}else{
				int m = state.getLast();
				state.removeLast();
				return m;
			}
		}
		return 0;
	}
	
	private boolean removeFirstOccurrence(int e) {
		Iterator<Integer> iter = state.iterator();
		while (iter.hasNext()) {
			if (iter.next() == e) {
				state.removeFirstOccurrence(e);
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
//		private boolean removeLastOccurrence(int e) {
//		Iterator<Integer> iter = state.iterator();
//		while (iter.hasNext()) {
//			if (iter.next() == e) {
//				state.removeLastOccurrence(e);
//				return true;
//			}else{
//				return false;
//			}
//		}
//		return false;
//	}
	
	private int size() {
		return state.size();
	}
	
	private int set (int i, int e) {
		int p = state.get(i);
		state.add(i, e);
		return p;
	}
	
	private int[] toArray() {
		int n = state.size();
		int [] list = new int[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = state.get(i);
		}
		return list;
	}
	
	public int hashCode() {
		return state.hashCode();
	}
	
	private boolean equals(LinkedList<Integer> state2) {
		Iterator<Integer> iter = state.iterator();
		Iterator<Integer> iter2 = state2.iterator();
		while (iter.hasNext()) {
			while (iter2.hasNext()) {
				if (state.size() == state2.size()) {
					if (iter.next().equals(iter2.next())) {
						return true;
					}else{
						return false;
					}
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
