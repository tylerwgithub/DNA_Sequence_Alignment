public class fastahandler{
	static final String[] codons = { 
            "TTT", "TTC", "TTA", "TTG", "TCT",
            "TCC", "TCA", "TCG", "TAT", "TAC", "TGT", "TGC", "TGG", "CTT",
            "CTC", "CTA", "CTG", "CCT", "CCC", "CCA", "CCG", "CAT", "CAC",
            "CAA", "CAG", "CGT", "CGC", "CGA", "CGG", "ATT", "ATC", "ATA",
            "ATG", "ACT", "ACC", "ACA", "ACG", "AAT", "AAC", "AAA", "AAG",
            "AGT", "AGC", "AGA", "AGG", "GTT", "GTC", "GTA", "GTG", "GCT",
            "GCC", "GCA", "GCG", "GAT", "GAC", "GAA", "GAG", "GGT", "GGC",
            "GGA", "GGG", };

	static final String[] aminos = { 
            "F", "F", "L", "L", "S", "S",
            "S", "S", "Y", "Y", "C", "C", "W", "L", "L", "L", "L", "P", "P",
            "P", "P", "H", "H", "Q", "Q", "R", "R", "R", "R", "I", "I", "I",
            "M", "T", "T", "T", "T", "N", "N", "K", "K", "S", "S", "R", "R",
            "V", "V", "V", "V", "A", "A", "A", "A", "D", "D", "E", "E", "G",
            "G", "G", "G", };
	public static String codonToamino(String c) {
		String res = "";
		for(int i = 0; i< codons.length; i++) {
			if (c.equals(codons[i])) res = aminos[i];
		}
		return res;
	}
	public static String aminoTocodon(String a) {
		String res = "";
		for(int i = 0; i< aminos.length; i++) {
			if (a.equals(aminos[i])) res = codons[i];
		}
		return res;
	}
}
