package com.qaprosoft.hospital.models.tree;

public class Node {
	public Object element;
	public Node left;
	public Node right;

	public Node(Object theElement) {
		this(theElement, null, null);
	}

	public Node(Object theElement, Node lLink, Node rLink) {
		element = theElement;
		this.left = lLink;
		this.right = rLink;
	}

}
