import java.util.Iterator;
import java.util.LinkedList;

public class BinaryTreePreIterator implements Iterator<BinaryTreeNode>{
	private LinkedList<BinaryTreeNode> s;
	BinaryTreeNode curr = null;

	public BinaryTreePreIterator(BinaryTreeNode root) {
		curr = root;
		s = new LinkedList<BinaryTreeNode>();
	}

	@Override
	public boolean hasNext() {
		if(curr != null)
			return true;
		return false;
	}

	@Override
	public BinaryTreeNode next() {
		if(hasNext()) {
			BinaryTreeNode old_curr = curr;
			if(curr.hasLeftChild()) {
				if(curr.hasRightChild())
					s.push(curr.getRightChild());
				curr = curr.getLeftChild();
			}else if(curr.hasRightChild()){
				curr = curr.getRightChild();
			}else {
				if(!s.isEmpty())
					curr = s.pop();
				else
					curr = null;
			}
			return old_curr;
		}
		throw new NoSuchElementException("No element");
	}
}
