package Tree;

public class Node {
	public int item;
	public Node leftChild;
	public Node rightChild;

	public void displayNode() {
		System.out.print("[");
		System.out.print(item);
		System.out.print("]");
	}
}
