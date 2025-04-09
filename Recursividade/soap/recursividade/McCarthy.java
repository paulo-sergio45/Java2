package recursividade;


public class McCarthy {

    public static int mcCarthy(int n) {
        if (n > 100)
            return n - 10;
        return mcCarthy(mcCarthy(n+11));
    }

    public static void main(String[] args) {
        int n = 99;
        System.out.println(mcCarthy(n));
    }
}