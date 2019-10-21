import java.io.IOException;
import java.util.*;

public class assembler {


//    public assembler(String input, int s, int r, int d, String output){
//        inputFile = input;
//        outputFile = output;
//        match = s;
//        replace = r;
//        delete = d;
//
//    }
    public static void alignmentOrder(String input, int s, int r, int d, String output) throws IOException {
        String[] sequences = fileHandler.readFile(input);
        int[][] order = new int[sequences.length][sequences.length];
        int[] max = new int[]{0,0};
        int maxScore = 0;
        for (int i = 0; i < sequences.length; i++) {
            for (int j = 0; j < sequences.length; j++) {
                if (i != j) {
                    order[i][j] = score(sequences[i], sequences[j], s, d, r);
                    if (order[i][j] > maxScore) {
                        maxScore = order[i][j];
                        max[0] = i;
                        max[1] = j;
                    }
                }
            }
        }

        LinkedList<String> joined = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        joined.add(sequences[max[0]]);
        joined.add(sequences[max[1]]);
        set.add(max[0]);
        set.add(max[1]);
        while (joined.size() != sequences.length) {
            int fIndex = max[1];
            TreeMap<Integer, LinkedList<Integer[]>> map = new TreeMap<>();
            for (int j = 0; j < sequences.length; j++) {
                if (!set.contains(j)) {
                    if (map.containsKey(order[fIndex][j])) {
                        map.get(order[fIndex][j]).add(new Integer[]{fIndex, j});
                    } else {
                        LinkedList<Integer[]> list = new LinkedList<>();
                        list.add(new Integer[]{fIndex, j});
                        map.put(order[fIndex][j], list);
                    }
                }
            }

            LinkedList<Integer[]> list = map.get(map.lastKey());
            int index = list.getFirst()[1];
            joined.add(sequences[index]);
            set.add(index);
            max[0] = fIndex;
            max[1] = index;
        }

        int score = 0;

        while (joined.size() > 1) {
            String str1 = joined.get(0);
            joined.remove();
            String str2 = joined.get(0);
            joined.remove();
            if (str1.length() > str2.length() + 10) {
                String prefix = str1.substring(0, str1.length() - str2.length());
                String suffix = str1.substring(str1.length() - str2.length());
                score = score(suffix, str2, s, r, d);
                if (score < 0) {
                    joined.addFirst(str1);
                    break;
                }
                suffix = dovetail(suffix, str2, s, r, d);
                str1 = prefix + suffix;
            } else {
                score = score(str1, str2, s, r, d);
                if (score < 0) {
                    joined.addFirst(str1);
                    break;
                }
                str1 = dovetail(str1, str2, s, r, d);
            }
            joined.addFirst(str1);

        }

        String[] res = new String[]{joined.getFirst()};
        fileHandler.writeFile(res, output);

    }

    public static int score(String s, String t, int match, int delete, int replace) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                dp[i][j] = Math.max(dp[i-1][j] + delete, dp[i][j-1] + delete);
                if (s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + match);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + replace);
                }
            }
        }
        int maxScore = 0;
        for (int j = 1; j < t.length() + 1; j++) {
            if (dp[s.length()][j] > maxScore){
                maxScore = dp[s.length()][j];
            }
        }
        return maxScore;
    }

    public static String dovetail(String s, String t, int match, int replace, int delete) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                dp[i][j] = Math.max(dp[i-1][j] + delete, dp[i][j-1] + delete);
                if (s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + match);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + replace);
                }
            }
        }
        int maxScore = 0;
        int[] position = new int[]{0,0};

        for (int j = 1; j < t.length() + 1; j++) {
            if (dp[s.length()][j] > maxScore){
                maxScore = dp[s.length()][j];
                position[0] = s.length();
                position[1] = j;
            }
        }

        LinkedList<Character> list = new LinkedList<>();
        int x = position[0];
        int y = position[1];
        for (int i = s.length(); i > x; i--) {
            list.addFirst(s.charAt(i-1));
        }
        for (int j = t.length(); j > y; j--) {
            list.addFirst(t.charAt(j-1));
        }
        char add;
        while (x > 0 && y > 0) {
            if (dp[x-1][y] > dp[x][y-1]) {
                if (dp[x-1][y] > dp[x-1][y-1]) {
                    add = s.charAt(x - 1);
                    x--;
                } else {
                    add = t.charAt(y - 1);
                    x--;
                    y--;
                }
            } else {
                if (dp[x][y-1] > dp[x-1][y-1]) {
                    add = t.charAt(y-1);
                    y--;
                } else {
                    add = t.charAt(y-1);
                    x--;
                    y--;
                }
            }
            list.addFirst(add);
        }
        while (x > 0) {
            list.addFirst(s.charAt(x-1));
            x--;
        }

        while (y > 0) {
            list.addFirst(t.charAt(y-1));
            y--;
        }


        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        return sb.toString();
    }
}