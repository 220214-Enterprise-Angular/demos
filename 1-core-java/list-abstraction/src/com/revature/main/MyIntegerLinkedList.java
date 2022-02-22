package com.revature.main;

public class MyIntegerLinkedList implements MyIntegerList {

	private int numOfElements;
	private Node head; // head of the list
	
	// WE have a local class called Node that we can utilize for this other class
	class Node {
		Integer data;
		Node next;
		
		Node(Integer element) {
			this.data = element;
		}
	}
	
	// O(n), because to add a new element, you need to traverse through the entire LinkedList
	// Singly linked lists suffer from bad time complexity for adding elements (at the end)
	public void add(Integer element) {
		// If head is null, then we have zero elements, so we want to add the first element
		// and have it as head
		if (this.head == null) {
			this.head = new Node(element);
		} else {
			Node currentNode = this.head;
			
			// Traverse through the LinkedList
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			
			currentNode.next = new Node(element);
		}
		
		this.numOfElements++;
	}
	
	// O(n)
	public Integer get(int index) {
				
		if(index > numOfElements - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		Node returnNode = this.head;
		
		for (int i = 0; i < index; i++) {
			returnNode = returnNode.next;
		}
		
		return returnNode.data;
	}
	
	public int size() {
		return this.numOfElements;
	}
	
}
