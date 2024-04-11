package com.bst;

public class BST {
	
	private Node root;
	
	public BST() {
		root = null;
	}
	
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	private void insertNode(int data) {
		root = insertRecursive(root, data);
	}
	
	private Node insertRecursive(Node root, int data) {
		if(root == null) {
			Node node = new Node(data);
			return node;
		}
		if(data < root.data) 
			root.left = insertRecursive(root.left, data);
		else if(data > root.data)
			root.right = insertRecursive(root.right, data);
		return root;
	}
	
	private void delete(int data) {
		delete_recursive(root, data);
	}
	
	private Node delete_recursive(Node root, int data) {
		if(root == null) 
			return root;
		if(data < root.data)
			root.left = delete_recursive(root.left, data);
		else if(data > root.data)
			root.right = delete_recursive(root.right, data);
		else {
			//if node has only one child.
			if(root.left == null)
				return root.right;
			else if(root.right == null) 
				return root.left;
			
		}
		return null;
	}
	
	int minValue(Node root) {
		int minValue = root.data;
		while(root.left != null) {
			minValue = root.left.data;
			root = root.left;
		}
		return minValue;
	}

	private boolean searchNode(int data) {
		root = search_recursive(root, data);
		if(root == null) 
			return false;
		return true;
	}

	private Node search_recursive(Node root, int data) {
		if(root == null || root.data == data) 
			return root;
		if(root.data > data)
			return search_recursive(root.left, data);
		else 
			return search_recursive(root.right, data);
	}
	
	private void inorder_traversal() {
		inorder_traversal(root);
	}

	private void inorder_traversal(Node root) {
		if(root != null) {
			inorder_traversal(root.left);
			System.out.println(root.data);
			inorder_traversal(root.right);
		}
	}

	public static void main(String... unused) {
		
	}
}