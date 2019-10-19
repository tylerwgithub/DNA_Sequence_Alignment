import java.io.*;
import java.util.*;

public class fileHandler {
	public static void aminoFile(String[] input, String filename) {
		FileWriter fw;
		try {
			fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i< input.length; i++) {
				int index = 0;
				int l = 0;
				bw.write("|>\n");
				while (index < input[i].length()) {
					if (index + 3 > input[i].length()) break;
					if (l == 80) {
						bw.write("\n");
						l = 0;
					}
					String s = fastahandler.codonToamino(input[i].substring(index, index + 3));
					if (!s.equals("")) {
						bw.write(s);
						l++;
					}
					index = index + 3;
				}
				bw.write("\n");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void writeFile(String[] input, String filename) {
		FileWriter fw;
		try {
			fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i< input.length; i++) {
				int index = 0;
				int l = 0;
				bw.write("|>\n");
				while (index < input[i].length()) {
					int upper = index + 80;
					if (upper > input[i].length()) upper = input[i].length();
					bw.write(input[i].substring(index, upper));
					bw.write("\n");
					index = index + 80;
				}
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String[] readFile(String filename) throws IOException {
		FileReader fr;
		String line;
		List<String> list = new ArrayList<>();
		try {
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			int i = -1;
			while (true) {
				line = br.readLine();
				if (line == null) break;
				if (line.equals("|>")) {
					i++;
					list.add("");
				}
				else {
					list.set(i, list.get(i) + line);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] res = list.toArray(new String[0]);
		return res;
	}
	
}
