import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Layer {
	List<Neurone> neurones = new ArrayList<Neurone>();
	public Layer(int input_count, boolean isFirstLayer){
		Random rand = new Random();
		int neural_count = rand.nextInt(501)+500; //de 500 à 1000 neurones
		for(int i = 0; i<neural_count; i++){
			neurones.add(new Neurone(input_count, isFirstLayer));
		}
	}
	public int getNeuralCount(){
		return neurones.size();
	}
	public List<Float> getValues(List<Float> input){
		List<Float> results = new ArrayList<Float>();
		for (Neurone neurone : neurones) {
		    results.add(neurone.getValue(input));
		}
		return results;
	}
}
