import java.util.Iterator;

public class tmain {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode("ciao",
												new BinaryTreeNode("Pippo", null, null),
												new BinaryTreeNode("pluto", null,null));
		Iterator<BinaryTreeNode> i = new BinaryTreePreIterator(root);
		while(i.hasNext()) {
			BinaryTreeNode node = i.next();
			System.out.println(node);
		}
	}
}
