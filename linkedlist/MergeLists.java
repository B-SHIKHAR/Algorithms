package com.linkedlist;

import com.linkedlist.MyLinkedList.Node;

public class MergeLists {
	
		private static Node merge(Node node1, Node node2) {
			Node dummyNode = new Node(Integer.MIN_VALUE);
			Node tail = dummyNode;
			while(true) {
				if(node1.next == null) {
					tail.next = node2;
					break;
				}
				if(node2.next == null) {
					tail.next = node1;
					break;
				}
				if(node1.data < node2.data) {
					tail.next = new Node(node1.data);
					node1.next = node1;
				} else {
					tail.next = new Node(node2.data);
					node2.next = node2;
				}
				tail = tail.next;
			}
			return dummyNode.next;
		}
		
		private static void findLoop(Node node) {
			
		}
		
		public static void main(String... unused) {
			Node node1 = new Node(1);
			node1.next = new Node(5);
			node1.next.next = new Node(8);
			node1.next.next.next = new Node(9);
			node1.next.next.next.next = new Node(10);
			
			Node node2 = new Node(2);
			node2.next = new Node(3);
			node2.next.next = new Node(4);
			node2.next.next.next = new Node(11);
			Node head = merge(node1, node2);
			System.out.println(head);
			while(head != null) {
				System.out.print(head.data+" -> ");
				head = head.next;
			}
	}
}