import java.io.IOException;

public class main{
	public static void main(String[] args) throws IOException {
		switch(args[0]) {
			case "hw1-1":
				int n = Integer.parseInt(args[1]);
				int a = Integer.parseInt(args[2]);
				int c = Integer.parseInt(args[3]);
				int g = Integer.parseInt(args[4]);
				int t = Integer.parseInt(args[5]);
				int k = Integer.parseInt(args[6]);
				double p = Double.parseDouble(args[7]);
				String output = args[8];
				String[] res = generator.dnaGenerator(n, a, c, g, t, k, p, output);
				break;
			case "hw1-2":
				String input = args[1];
				int x = Integer.parseInt(args[2]);
				int y = Integer.parseInt(args[3]);
				output = args[4];
				res = partitioning.dnaPartitioning(input, x, y, output);
				break;
			case "hw1-3":
				input = args[1];
				int s = Integer.parseInt(args[2]);
				int r = Integer.parseInt(args[3]);
				int d = Integer.parseInt(args[4]);
				output = args[5];
				assembler.alignmentOrder(input,s,r,d,output);
				break;
		}
    }
//	public static void test1(){
//		int n = 2000; //sequence length
//		int a = 1;
//		int c = 1;
//		int g = 1;
//		int t = 1;
//		int k = 10; //number of sequences
//        double p = 0.01; //p mutation probability in [0:1] interval
//        String output = "generator.txt";//output file name
//
//        String[] res = generator.dnaGenerator(n, a, c, g, t, k, p, output);
//
////        for (int i = 0; i < res.length; i++) {
////        	System.out.println(res[i]);
////        }
//	}
//	public static void test2() throws IOException {
//		String input = "generator.txt"; //input file name
//		int x = 10; //minimum fragment length
//		int y = 20; //maximum fragment length (y ≥ x)
//		String output = "partitioning.txt"; //output file name
//
//		String[] res = partitioning.dnaPartitioning(input, x, y, output);
//
////		for (int i = 0; i < res.length; i++) {
////		    System.out.println(res[i]);
////		}
//	}
//
//	public static void test3() throws IOException {
//		String input = "partitioning.txt";
//		String output = "dovetailAlignment.txt";
//		int s = 5;
//		int r = -5;
//		int d = -2;
//		assembler.alignmentOrder(input,s,r,d,output);
//	}
	
	
}