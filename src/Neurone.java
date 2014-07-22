import java.util.Random;
import java.util.List;


public class Neurone {
	float[] weights;
	float seuil;
	int[] random_ids;
	float w0;
	public Neurone(int input_count, boolean isFirstLayer){
		Random rand = new Random();
		int link_count = 0;
		if(isFirstLayer){
			link_count = input_count; //prendre tout les input d'origine
		}else{
			link_count = rand.nextInt(101) + 100; //100 à 200 liens
		}
		seuil = rand.nextFloat(); //de 0 à 1
		weights = new float[link_count];
		random_ids = new int[link_count];
		w0 = rand.nextFloat()/2; //poids de 0 à 0.5
		for(int i = 0; i<link_count; i++){
			float weight = (float)(rand.nextFloat()/10+0.9); //poids de 0.9 à 1
			weights[i] = weight;
		}
		
		boolean[] selected = new boolean[input_count];
		for(int i = 0; i<link_count; i++){
			int random_id = 0;
			while(selected[random_id]){
				random_id = rand.nextInt(input_count);
			}
			random_ids[i] = random_id;
			selected[random_id] = true;
		}
	}
	public float getValue(List<Float> input){
		float sum = 0;
		for(int i = 0; i<weights.length; i++){
			float in = (float)input.get(random_ids[i]);
			sum = sum + (in * weights[i]);
		}
		float y = (sum/weights.length);
		
		//fonction d'activation: tangente hyperbolique
		//float y = (float) ((2.3432 / (1 + Math.exp(-0.667*sum))) - 1.1716);
		return y;
	}
}
