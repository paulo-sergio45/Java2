package recursividade;

public class Fibonacci {

	
public static void main(String[] args) {
		
		System.out.println(FibonacciMatriz(17));

}


public static double FibonacciMatriz(int n) {
    //long startTime = System.nanoTime();    
    long[][] mat = {{1, 0}, {0, 1}};
    long[][] mat2 = {{1, 1}, {1, 0}};
    boolean l = true;
    if (n < 2) {
        return n;
    } else {
        while (l) {
            if (n <= 0) {
                l = false;
            } else {
                if (n % 2 == 1) {
                    long[][] aux2 = {{mat[0][0] * mat2[0][0] + mat[0][1] * mat2[1][0],
                        mat[0][0] * mat2[0][1] + mat[0][1] * mat2[1][1]},
                    {mat[1][0] * mat2[0][0] + mat[1][1] * mat2[1][0],
                        mat[1][0] * mat2[0][1] + mat[1][1] * mat2[1][1]}};
                    mat = aux2;
                }
                long[][] aux = {{mat2[0][0] * mat2[0][0] + mat2[0][1] * mat2[1][0],
                    mat2[0][0] * mat2[0][1] + mat2[0][1] * mat2[1][1]},
                {mat2[1][0] * mat2[0][0] + mat2[1][1] * mat2[1][0],
                    mat2[1][0] * mat2[0][1] + mat2[1][1] * mat2[1][1]}};
                mat2 = aux;

                n = n / 2;
            }
        }
    }

    //long estimatedTime = System.nanoTime() - startTime;
    //        System.out.println(estimatedTime);
    return mat[0][1];

}
}
