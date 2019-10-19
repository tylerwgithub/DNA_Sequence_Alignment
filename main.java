import java.io.IOException;

public class main{
	public static void main(String[] args) throws IOException {
		test1();
		test2();
        
    }
	public static void test1(){
		int n = 2000; //sequence length
		int a = 1;
		int c = 1;
		int g = 1;
		int t = 1;
		int k = 10; //number of sequences
        double p = 0.01; //p mutation probability in [0:1] interval
        String output = "generator.txt";//output file name
        
        String[] res = generator.dnaGenerator(n, a, c, g, t, k, p, output);
        
        for (int i = 0; i < res.length; i++) {
        	System.out.println(res[i]);
        }
	}
	public static void test2() throws IOException{
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