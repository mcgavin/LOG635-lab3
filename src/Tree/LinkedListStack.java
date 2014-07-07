package Tree;

public class LinkedListStack {
	private StackNode first;

	public LinkedListStack() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insert(Node key)// inserts at beginning of list
	{
		StackNode newLLNode = new StackNode(key);
		newLLNode.next = first;
		first = newLLNode;
	}

	public Node delete()// deletes at beginning of list
	{
		StackNode temp = first;
		first = first.next;
		return temp.item;
	}
}
