public class BinaryTreeNode {
	private Object val;
	private BinaryTreeNode left, right;

	public BinaryTreeNode(Object _val, BinaryTreeNode _left, BinaryTreeNode _right){
		val = _val;
		left = _left;
		right = _right;
	}

	public Object getValue() { return val;}
	public BinaryTreeNode getLeftChild() { return left;}
	public BinaryTreeNode getRightChild() { return right;}

	public boolean hasLeftChild() { return left != null;}
	public boolean hasRightChild() { return right != null;}

	@Override
	public String toString() {
		return "" + val;
	}
}
