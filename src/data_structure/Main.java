package data_structure;

/**
 * @author Allen Lin
 * @date 2016-5-10
 * @desc
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree aBinaryTree = new BinaryTree();
		aBinaryTree.createBinTree(aBinaryTree.root);

		aBinaryTree.InOrderTraverse(aBinaryTree.root);
		System.out.println("");
		aBinaryTree.PreOrderTraverse(aBinaryTree.root);
		System.out.println("");
		aBinaryTree.PostOrderTraverse(aBinaryTree.root);
	}

}
