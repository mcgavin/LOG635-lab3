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
				listInput.add(Float.parseFloat(splitedLine[2]));
				listInput.add(Float.parseFloat(splitedLine[4]));
				listInput.add(Float.parseFloat(splitedLine[8]));
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
