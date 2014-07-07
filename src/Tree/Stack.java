package Tree;

public class Stack {
	private LinkedListStack listObj;

	public Stack() {
		listObj = new LinkedListStack();
	}

	public void push(Node num) {
		listObj.insert(num);
	}

	public Node pop() {
		return listObj.delete();
	}

	public boolean isEmpty() {
		return listObj.isEmpty();
	}
}
