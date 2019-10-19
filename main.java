import java.io.IOException;

public class main{
	public static void main(String[] args) throws IOException {
		String[] t1 = test1();
		test2(t1);
        
    }
	public static String[] test1(){
		int n = 2000; //sequence length
		int a = 1;
		int c = 1;
		int g = 1;
		int t = 1;
		int k = 4; //number of sequences
        double p = 0.1; 
        String output = "generator.txt";//output file name
//        System.out.println();
        String[] res = generator.dnaGenerator(n, a, c, g, t, k, p, output);
//        System.out.println(res[0].length());
        for (int i = 0; i < res.length; i++) {
        	System.out.println(res[i]);
        }
        return res;
	}
	public static void test2(String[] seq) throws IOException{
		String input = "generator.txt"; //input file name
		int x = 10; //minimum fragment length
		int y = 20; //maximum fragment length (y ≥ x) 
		String output = "partitioning.txt"; //output file name
		String[] res = partitioning.dnaPartitioning(input, x, y, output);
		for (int i = 0; i < res.length; i++) {
		    System.out.println(res[i]);
		}
	}
	
	
}