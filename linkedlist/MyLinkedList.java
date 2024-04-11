package com.linkedlist;

public class MyLinkedList {
	
	static class Node {
		double data;
		Node next;
		Node() {
			data = Integer.MIN_VALUE;
			next = null;
		}
		Node(double data) {
			this.data = data;
			next = null;
		}
	}
	
	private static void printList(Node node1) {
		while(node1 != null) {
			System.out.print(node1.data + " -> ");
			node1 = node1.next;
		}
		System.out.print("null");
	}
	
	private static void insertAtEnd(Node node1, Node nodeToBeInserted) {
		Node currentNode = node1;
		do {
			currentNode = currentNode.next;
		} while(currentNode.next != null);
		currentNode.next = nodeToBeInserted;
		printList(node1);
	}
	
	private static void insertAtTheBeginning(Node node1, Node nodeToBeInserted) {
		nodeToBeInserted.next = node1;
		printList(nodeToBeInserted);
	}
	
	private static void insertInTheMiddle(Node node1, Node nodeToBeInserted) {
		Node currentNode = node1;
		Node prev = null;
		while(currentNode.data < nodeToBeInserted.data) {
			prev = currentNode;
			currentNode = currentNode.next;
		}
		nodeToBeInserted.next = currentNode;
		prev.next = nodeToBeInserted;
		printList(node1);
	}
	
	private static void deleteLastNode(Node node) {
		Node currentNode = node;
		Node prev = null;
		while(currentNode.next != null) {
			prev = currentNode;
			currentNode = currentNode.next;
		}
		prev.next = null;
		printList(node);
	}
	
	private static void deleteFirstNode(Node node) {
		Node first = node.next;
		node.next = null;
		printList(first);
	}
	
	private static void deleteRandomNode(Node node, Node nodeToBeDeleted) {
		Node currentNode = node;
		Node prev = null;
		while(currentNode.data != nodeToBeDeleted.data) {
			prev = currentNode;
			currentNode = currentNode.next;
		}
		prev.next = currentNode.next;
		printList(node);
	}
	
	private static void reverseList(Node node) {
		Node prevNode = null;
		Node nextNode = null;
		Node currentNode = node;
		Node head = node;
		while(currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		prevNode = head;
	}
	
	private static void MergeLists(Node node1, Node node2) {
		
	}
	
	
	
	public static void main(String... unused) {
		Node node1 = new Node(1);
		node1.next = new Node(2);
		node1.next.next = new Node(3);
		node1.next.next.next = new Node(4);
		node1.next.next.next.next = new Node(5);
		
		printList(node1);
		System.out.println("-------deleteRandom--------");
		deleteRandomNode(node1, new Node(3));
		System.out.println();
		Node nodeToBeInserted = new Node(6);
		insertAtEnd(node1,nodeToBeInserted);
		Node nodeAtTheStart = new Node(0);
		System.out.println();
		insertAtTheBeginning(node1, nodeAtTheStart);
		System.out.println();
		Node nodeInTheMiddle = new Node(3.5);
		insertInTheMiddle(node1, nodeInTheMiddle);
		System.out.println();
		deleteLastNode(node1);
		System.out.println();
		deleteFirstNode(node1);
		System.out.println();
	}

}