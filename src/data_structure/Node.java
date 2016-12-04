package data_structure;

/**
 * @author Allen Lin
 * @date 2016-5-10
 * @desc
 */
public class Node {
	public Object data; // 该节点存储的值。
	public Node leftChild; // 指向左子节点的引用。
	public Node rightChild; // 指向右子节点的引用。

	public Node(Object value) {
		this.data = value;
		leftChild = null;
		rightChild = null;
	}
}
