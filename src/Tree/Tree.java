package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public Node root;

	public Tree() {
		root = null;
	}

	public Node returnRoot() {
		return root;
	}

	public void insert(int id) {
		Node newNode = new Node();
		newNode.item = id;
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (id < current.item) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void preOrder(Node Root) {
		if (Root != null) {
			System.out.print(Root.item + " ");
			preOrder(Root.leftChild);
			preOrder(Root.rightChild);
		}
	}

	public void inOrder(Node Root) {
		if (Root != null) {
			inOrder(Root.leftChild);
			System.out.print(Root.item + " ");
			inOrder(Root.rightChild);
		}
	}

	public void postOrder(Node Root) {
		if (Root != null) {
			postOrder(Root.leftChild);
			postOrder(Root.rightChild);
			System.out.print(Root.item + " ");
		}
	}

	public void byLevel(Node root){
	Queue<Node> level	= new LinkedList<Node>();
	level.add(root);

	while(!level.isEmpty()){
	Node node = level.poll();
	System.out.print(node.item + " ");
	if(node.leftChild!= null)
	level.add(node.leftChild);
	if(node.rightChild!= null)
	level.add(node.rightChild);
	}
	}

	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out
				.println("****......................................................****");
		while (isRowEmpty == false) {

			Stack localStack = new Stack();
			isRowEmpty = true;
			for (int j = 0; j < emptyLeaf; j++)
				System.out.print(' ');
			while (globalStack.isEmpty() == false) {
				Node temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.item);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < emptyLeaf * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out
				.println("****......................................................****");
	}
}
