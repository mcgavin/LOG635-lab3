import java.util.ArrayList;
import java.util.List;
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
				int result = (int)(n.getResult(list)*10000);
				error_total += Math.abs(result - listRental.get(error_count));
				error_count++;
			}
			mean_error = error_total / error_count;
			System.out.println("found "+mean_error);
			if(kept_mean_error > mean_error){
				count = 0;
				keeper = n;
				kept_mean_error=mean_error;
				System.out.println("keep "+kept_mean_error);
			}
			if(count > 10){
				break;
			}
		}
		System.out.println("final "+kept_mean_error);
		

		List<Float> newList = new ArrayList<Float>();
		newList.add((float) 0.7);
		newList.add((float) 0.1);
		newList.add((float) 1);
		newList.add((float) 0.274783);
		newList.add((float) 0.279961);
		int result = (int)(keeper.getResult(newList)*10000);
		System.out.println("Prediction 1:" + result);

		newList = new ArrayList<Float>();
		newList.add((float) 1);
		newList.add((float) 0.3);
		newList.add((float) 1);
		newList.add((float) 0.4257);
		newList.add((float) 0.452637);
		result = (int)(keeper.getResult(newList)*10000);
		System.out.println("Prediction 2:" + result);

		newList = new ArrayList<Float>();
		newList.add((float) 0.5);
		newList.add((float) 1);
		newList.add((float) 1);
		newList.add((float) 0.430833);
		newList.add((float) 0.484987);
		result = (int)(keeper.getResult(newList)*10000);
		System.out.println("Prediction 3:" + result);

		newList = new ArrayList<Float>();
		newList.add((float) 0.5);
		newList.add((float) 0.9);
		newList.add((float) 1);
		newList.add((float) 0.521667);
		newList.add((float) 0.508204);
		result = (int)(keeper.getResult(newList)*10000);
		System.out.println("Prediction 4:" + result);
		
		System.out.println("The end.");
	}
}
