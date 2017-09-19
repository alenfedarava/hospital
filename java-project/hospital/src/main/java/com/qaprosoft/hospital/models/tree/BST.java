package com.qaprosoft.hospital.models.tree;

public class BST {
	public Node root;

	public BST(Object x) {
		root = new Node(x);
	}

	public Node insert(Node node, Integer x) {
		if (node == null) {
			return node = new Node(x);
		}
		if (x < (Integer) node.element) {
			node.left = insert(node.left, x);
		} else {
			node.right = insert(node.right, x);
		}
		return node;
	}

	public Node delete(Node root, Integer x) {
		if (root == null) {
			return root;
		}
		if (x > (Integer) root.element) {
			root.left = delete(root.right, x);
		} else if (x > (Integer) root.element) {
			root.right = delete(root.right, x);
		} else if (root.left != null && root.right != null) {
			root.element = (minValue(root.right)).element;
			root.right = delete(root.right, (Integer) root.element);
		} else if (root.left != null && root.right == null) {
			root = root.left;
		} else if (root.left == null && root.right != null) {
			root = root.right;
		} else {
			root = null;
		}
		return root;
	}

	private Node minValue(Node x) {
		if (x.left == null) {
			return x;
		} else {
			return minValue(x.left);
		}

	}

	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(((Integer) node.element).intValue() + ",");
			inOrder(node.right);
		}
	}

	public void descOrder(Node node) {
		if (node != null) {
			descOrder(node.right);
			System.out.print(((Integer) node.element).intValue() + ",");
			descOrder(node.left);
		}
	}
}
