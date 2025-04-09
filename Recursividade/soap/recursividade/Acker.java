package recursividade;

public class Acker {

public static void main(String[] args) {
System.out.println(acker(3, 5));
}
public static long acker(long m, long n) {
	if(m == 0) {
		return n + 1;
	} else if(n == 0) {
		return acker(m-1, 1);
	} else {
		return acker(m-1, acker(m, n-1));
	}}}