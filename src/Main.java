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
