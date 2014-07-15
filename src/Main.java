import java.util.ArrayList;
import java.util.List;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List input = new ArrayList();
		input.add((float)0.5);
		input.add((float)0.1);
		input.add((float)0.2);
		input.add((float)0.3);
		input.add((float)0.4);
		input.add((float)0.6);
		input.add((float)0.7);
		Network n = new Network(input.size());
		System.out.println("test");
		System.out.println(n.getResult(input));
	}
}
