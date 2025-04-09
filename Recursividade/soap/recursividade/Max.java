package recursividade;

public class Max {
	public static void main(String[] args) {
		int[] vet = {1,20,3,50,5,10,15,56,12};
		System.out.println(maxr(vet,vet.length));
		}
	public static int maxr (int[] v, int n)
	{ 
	   if (n == 1) { return v[0];}
	   else {
	      int x;
	      x = maxr(v, n-1);
	      if (x > v[n-1]) { return x;}
	      else {return v[n-1];} 
	   }
	}
	
}
