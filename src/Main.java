import Tree.Tree;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello world");
		int value;
		Tree theTree = new Tree();
		theTree.insert(42);
		theTree.insert(25);
		theTree.insert(65);
		theTree.insert(12);
		theTree.insert(37);
		theTree.insert(13);
		theTree.insert(30);
		theTree.insert(43);
		theTree.insert(87);
		theTree.insert(99);
		theTree.insert(9);

		System.out.println("Displaying the tree");
		theTree.displayTree();

		System.out.println("Inorder traversal");
		theTree.inOrder(theTree.returnRoot());
		System.out.println(" ");

		System.out.println("Preorder traversal");
		theTree.preOrder(theTree.returnRoot());
		System.out.println(" ");

		System.out.println("Postorder traversal");
		theTree.postOrder(theTree.returnRoot());
		System.out.println(" ");

		System.out.println("By Level");
		theTree.byLevel(theTree.returnRoot());
		System.out.println(" ");
	}

}
