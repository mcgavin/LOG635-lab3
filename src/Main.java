import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	private static List<Integer> listRental;
	private static List<List<Float>> listOfInputs;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Starting process");
		Data data = new Data();
		listRental = data.getListRental();
		listOfInputs = data.getListOfInputs();
		int nbAttributs = listOfInputs.get(0).size();
		
	/*	List input = new ArrayList();
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
		*/
		
		Network n = new Network(nbAttributs);
		System.out.println("test");
		for (List<Float> list : listOfInputs) {
			System.out.println(n.getResult(list));
		}
		System.out.println("The end.");
	}
}
