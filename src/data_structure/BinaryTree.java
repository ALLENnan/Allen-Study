package data_structure;

import java.util.HashMap;

/**
 * @author Allen Lin
 * @date 2016-5-10
 * @desc binaryTree
 */
public class BinaryTree implements Itree {
	Node root = null;

	public BinaryTree() {
		root = new Node("A");
	}

	public void createBinTree(Node root) {
		Node newNodeB = new Node("B");
		Node newNodeC = new Node("C");
		Node newNodeD = new Node("D");
		Node newNodeE = new Node("E");
		Node newNodeF = new Node("F");
		root.leftChild = newNodeB;
		root.rightChild = newNodeC;
		root.leftChild.leftChild = newNodeD;
		root.leftChild.rightChild = newNodeE;
		root.rightChild.rightChild = newNodeF;
	}

	public void PreOrderTraverse(Node root) {
		if (root == null)
			return;
		System.out.print(root.data);
		PreOrderTraverse(root.leftChild);
		PreOrderTraverse(root.rightChild);
	}

	public void InOrderTraverse(Node root) {
		if (root == null) {
			return;
		}
		InOrderTraverse(root.leftChild);
		System.out.print(root.data);
		InOrderTraverse(root.rightChild);
	}

	public void PostOrderTraverse(Node root) {
		if (root == null) {
			return;
		}
		PostOrderTraverse(root.leftChild);
		PostOrderTraverse(root.rightChild);
		System.out.print(root.data);
	}

}
