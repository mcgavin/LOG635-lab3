import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Network {
	Map<Integer, Layer> layers = new HashMap<Integer, Layer>();
	public Network(int input_count){
		Random rand = new Random();
		Layer layer = new Layer(input_count, true);
		int neural_count = layer.getNeuralCount();
		layers.put(1, layer);
		int layer_count = rand.nextInt(11)+10; //de 10 à 20 couches
		for(int i = 2; i<=layer_count; i++){
			layer = new Layer(neural_count, false);
			neural_count = layer.getNeuralCount();
			layers.put(i, layer);
		}
	}
	public float getResult(List<Float> input){
		Layer layer = layers.get(1);
		List<Float> results = layer.getValues(input);
		for(int i = 2; i<=layers.size(); i++){
			layer = layers.get(i);
			results = layer.getValues(results);
		}
		float total = 0;
		for (float result : results) {
			total += result;
		}
		total = total / results.size();
		return total;
	}
}
