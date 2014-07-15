import java.util.Random;
import java.util.List;


public class Neurone {
	int[] weights;
	int[] random_ids;
	public Neurone(int input_count, boolean isFirstLayer){
		Random rand = new Random();
		int link_count = 0;
		if(isFirstLayer){
			link_count = input_count; //prendre tout les input d'origine
		}else{
			link_count = rand.nextInt(11) + 10; //10 à 20 liens
		}
		weights = new int[link_count];
		random_ids = new int[link_count];
		for(int i = 0; i<link_count; i++){
			int weight = rand.nextInt(101); //poids de 0 à 100
			weights[i] = weight;
		}
		
		boolean[] selected = new boolean[input_count];
		for(int i = 0; i<link_count; i++){
			int random_id = 0;
			while(selected[random_id]){
				random_id = rand.nextInt(input_count);
			}
			random_ids[i] = random_id; //poids de 0 à 100
			selected[random_id] = true;
		}
	}
	public float getValue(List input){
		float sum = 0;
		for(int i = 0; i<weights.length; i++){
			float in = (float)input.get(random_ids[i]);
			sum = in * weights[i];
		}
		
		//fonction d'activation to add
		return 0;
	}
}
