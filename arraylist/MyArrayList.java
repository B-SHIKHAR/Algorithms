package com.arraylist;

import java.util.Arrays;

public class MyArrayList<E> {
	
	private Object[] arrayStore;
	
	private int actSize = 0;
	
	public MyArrayList() {
		this.arrayStore = new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if(index < actSize) {
			return (E)arrayStore[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void add(E element) {
		if(arrayStore.length - actSize <=5) {
			ensureCapacity();
			addToTheList(element);
		} else {
			addToTheList(element);
		}
	}
	
	private void ensureCapacity() {
		arrayStore = Arrays.copyOf(arrayStore, arrayStore.length*2);
	}
	
	private void addToTheList(E element) {
		arrayStore[actSize++] = element;
	}
	
	public Object remove(int index) {
		Object element;
		if(index < actSize) {
			element = arrayStore[index];
			arrayStore[index] = null;
			int tmp = index;
			while(tmp < actSize) {
				arrayStore[tmp] = arrayStore[tmp+1];
				arrayStore[tmp+1] = null;
				tmp++;
			}
			actSize--;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
		return element;
	}
	
	public int size() {
		return actSize;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < arrayStore.length; i++) {
			sb.append(arrayStore[i]);
		}
		return sb.toString();
	}
	
	public static void main(String... args) {
		MyArrayList<Integer> list =  new MyArrayList<Integer>();
		list.add(1); list.add(10); list.add(4); list.add(8);
		list.remove(0);
		System.out.println(list);
	}
	
	
}