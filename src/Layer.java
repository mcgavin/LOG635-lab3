import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Layer {
	List<Neurone> neurones = new ArrayList<Neurone>();
	public Layer(int input_count, boolean isFirstLayer){
		Random rand = new Random();
		int neural_count = rand.nextInt(11)+10; //de 10 à 20 neurones
		for(int i = 0; i<neural_count; i++){
			neurones.add(new Neurone(input_count, isFirstLayer));
		}
	}
	public int getNeuralCount(){
		return neurones.size();
	}
	public List getValues(List input){
		List<Float> results = new ArrayList<Float>();
		for (Neurone neurone : neurones) {
		    results.add(neurone.getValue(input));
		}
		return results;
	}
}
