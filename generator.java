import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class generator {
	
	public static String[] dnaGenerator(int n, int a,  int c, int g, int t, int k, double p, String filename) {
		int s = a+c+g+t;
		String[] seq = new String[k];
		Arrays.fill(seq, "");
		for(int i = 0; i<n; i++) {
			seq[0] = seq[0] + getRandom(a,c,g,t,s);
		}
		char[] chars = seq[0].toCharArray();
		int count = 1;
		while (count < k) {
			Random random = new Random();
			for(int i = 0; i<chars.length; i++) {
				Double d = random.nextDouble();
				int coin = random.nextInt(2);
				if (d <= p && coin == 0) {
					seq[count] = seq[count] + getMutation(Character.toString(chars[i]));
				}
				else if(d > p) seq[count] = seq[count] + chars[i];
			}
			count++;
		}
		fileHandler.writeFile(seq, filename);
		fileHandler.aminoFile(seq, "amino" + filename);

        return seq;
        
	}
	
	
	public static String getMutation(String input) {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("C", 1);
		map.put("G", 1);
		map.put("T", 1);
		map.put(input, 0);
		int a = map.get("A");
		int c = map.get("C");
		int g = map.get("G");
		int t = map.get("T");
		Random random = new Random();
        int n = random.nextInt(3) + 1;
        if (n <= a)        return "A";
		else if (n <= a+c) return "C";
		else if (n <= a+c+g) return "G";
		else return "T";
	}
	public static String getRandom(int a,  int c, int g, int t, int s) {
		Random random = new Random();
        int n = random.nextInt(s) + 1;
		if (n <= a)        return "A";
		else if (n <= a+c) return "C";
		else if (n <= a+c+g) return "G";
		else return "T";
	}

}