package recursividade;

public class sdadsad {
	public static void main(String[] args) {
	System.out.println(pes(10));
	}


public static int pes(int n) {
	int cont =0;
	cont++;
	if(n > 1) {
		n = n*n*n;
		System.out.println(cont);
		return pes( n/3);
		
	}
	return n;
	}
}