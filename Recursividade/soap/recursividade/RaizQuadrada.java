package recursividade;

public class RaizQuadrada {
	public static void main(String[] args) {
		double r = raizQuadrada(16.0);
		double r1 = Math.sqrt(16.0);
		System.out.println("comparativo");
		System.out.println("valor da funcao:  " + r);
		System.out.println("valor real:  " + r1);

	}

	private static double raizQuadrada(double x) {
		return raizQuadrada(0.0, x, x);
	}

	private static double raizQuadrada(double a, double b, double x) {
		double y = (a + b) / 2.0;
		if (Math.abs(y * y - x) <= 1.0e-15 || Math.abs(a - b) <= 1.0e-15) {
			return (int)y;
		} else if (y * y > x) {
			return raizQuadrada(a, y, x);
		} else {
			return raizQuadrada(y, b, x);
		}
	}
}
