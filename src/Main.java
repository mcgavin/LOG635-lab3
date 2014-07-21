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
		Network keeper = null;
		float mean_error = 10000, kept_mean_error = 10000;
		int count = 0;
		
		while (mean_error > 1000){
			count++;
			Network n = new Network(nbAttributs);
			int error_total = 0;
			int error_count = 0;
			for (List<Float> list : listOfInputs) {
				error_total += Math.abs(n.getResult(list)*10000 - listRental.get(error_count));
				//System.out.println(n.getResult(list)*10000);
				error_count++;
			}
			mean_error = error_total / error_count;
			if(kept_mean_error > mean_error){
				count = 0;
				keeper = n;
				kept_mean_error=mean_error;
			}
			if(count > 100){
				break;
			}
		}
		System.out.println(kept_mean_error);
		System.out.println("The end.");
	}
}
