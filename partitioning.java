import java.io.IOException;
import java.util.*;
public class partitioning{
	public static String[] dnaPartitioning(String input, int x, int y, String output) throws IOException {
		String[] seq = fileHandler.readFile(input);
		Random random = new Random();
//		int n = random.nextInt(y - x + 1) + x;
		List<String> list = new ArrayList<>();
		for (int i = 0; i < seq.length; i++) {
			int index = 0;
			while (index < seq[i].length()) {
				
				if (seq[i].length() - index < x) break;
				int l = random.nextInt(y - x + 1) + x;
				if (index + l > seq[i].length()) index = seq[i].length() - l;
				list.add(seq[i].substring(index, index + l));
				index = index + l;
			}
		}
//        System.out.println(n);
        String[] res = list.toArray(new String[0]);
        fileHandler.writeFile(res, output);
        fileHandler.aminoFile(res, "amino" + output);
        return res;
    }
}