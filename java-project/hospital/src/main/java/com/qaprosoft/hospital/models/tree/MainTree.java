package com.qaprosoft.hospital.models.tree;

public class MainTree {
	public static void main(String args[]) {

		int[] arr = { 10, 9, 2, 3, 4, 5, 9, 12, 8, 18, 13, 16 };
		BST bst = new BST(new Integer(arr[0]));
		for (int i = 1; i < arr.length; i++) {
			bst.insert(bst.root, new Integer(arr[i]));
		}
		System.out.print("Elements in Increasing Order: ");
		bst.inOrder(bst.root);
		System.out.println();
		System.out.print("Elements in Decreasing Order: ");
		bst.descOrder(bst.root);
	}
}
