import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Data {

	private List<Integer> listRental;
	private List<List<Float>> listOfListInputs;
	
	public Data(){
		try {
			listRental = new ArrayList<Integer>();
			
			listOfListInputs = new ArrayList<List<Float>>();
			ReadFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ReadFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("text.txt"));

		try {
			StringBuilder sb = new StringBuilder();
			//skip line 1
			br.readLine();
			
			//start at line 2 to gather data
			String line = br.readLine();
			List<Float> listInput;
			while (line != null) {
				// 0=id, *1=date, 2=saison(1-4), *3=année(0-1), 4=mois(1-12), *5=holiday(bool), *6=weekday(0-6), *7=workingday(bool), 8=weathersit(1-4)
				// 9=temp, 10=atemps, *11=hum, *12=windspeed, 13=rental
				sb.append(line);
				sb.append(System.lineSeparator());
				String[] splitedLine = line.split(",");
				//get rental and add it to listRental
				listRental.add(Integer.parseInt(splitedLine[13]));
				//get important inputs and add them to listInput
				listInput = new ArrayList<Float>();
				
				//SAISON
				switch (Integer.parseInt(splitedLine[2])) {
				case 1:listInput.add((float) 0.7);break;
				case 2:listInput.add((float) 1);break;
				case 3:listInput.add((float) 0.5);break;
				case 4:listInput.add((float) 0);break;
				default:
					break;
				}
				
				//MOIS
				switch (Integer.parseInt(splitedLine[4])) {
				case 1:listInput.add((float) 0);break;
				case 2:listInput.add((float) 0.05);break;
				case 3:listInput.add((float) 0.2);break;
				case 4:listInput.add((float) 0.3);break;
				case 5:listInput.add((float) 0.5);break;
				case 6:listInput.add((float) 0.8);break;
				case 7:listInput.add((float) 1);break;
				case 8:listInput.add((float) 0.9);break;
				case 9:listInput.add((float) 0.7);break;
				case 10:listInput.add((float) 0.4);break;
				case 11:listInput.add((float) 0.15);break;
				case 12:listInput.add((float) 0.1);break;					
				default:
					break;
				}
				
				//weather
				switch (Integer.parseInt(splitedLine[8])) {
				case 1:listInput.add((float) 1);break;
				case 2:listInput.add((float) 0.6);break;
				case 3:listInput.add((float) 0.3);break;
				case 4:listInput.add((float) 0);break;
				default:
					break;
				}
				
				listInput.add(Float.parseFloat(splitedLine[9]));
				listInput.add(Float.parseFloat(splitedLine[10]));
				
				listOfListInputs.add(listInput);
				line = br.readLine();
			}
			//String everything = sb.toString();
			
			//arrayValeur = everything.split(",");
			
		} finally {
			br.close();
		}
	}

	public List<List<Float>> getListOfInputs() {
		return listOfListInputs;
	}

	public List<Integer> getListRental() {
		return listRental;
	}
	
	public int getMaxRental(){
		int max = 0;
		for (int nombre : listRental) {
			if(max < nombre){
				max = nombre;
			}
		}
		return max;
	}
	
	public int getMinRental(){
		int min = Integer.MAX_VALUE;
		for (int nombre : listRental) {
			if(min > nombre){
				min = nombre;
			}
		}
		return min;
	}
}
