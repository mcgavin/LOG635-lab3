import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	private static String[] arrayValeur;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("hello world");
		ReadFile();
		System.out.println(arrayValeur[5]);
		
		
		List input = new ArrayList();
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
	}

	private static void ReadFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("text.txt"));

		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			
			arrayValeur = everything.split(",");
			
		} finally {
			br.close();
		}
	}
}
