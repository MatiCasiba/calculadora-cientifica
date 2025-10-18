package calculadora.modelo;

public class OpercionesMatematicas {
	
	public static double sumar(double a, double b) {
		return a + b;
	}
	
	public static double restar(double a, double b) {
		return a - b;
	}
	
	public static double multiplicar(double a, double b) {
		return a * b;
	}
	
	public static double dividir(double a, double b) {
		if(b==0) {
			throw new IllegalArgumentException("No se puede dividir por cero");
		}
		return a / b;
	}
	
	public static double potencia(double a, double b) {
		return Math.pow(a, b);
	}
	
	public static double raiz(double a) {
		if(a < 0) {
			throw new IllegalArgumentException("no se puede calcular");
		}
		return Math.sqrt(a);
	}
	
	public static double seno(double a) {
		return Math.sin(a);
	}
	
	public static double coseno(double a) {
		return Math.cos(a);
	}
	
	public static double logaritmo(double a) {
		if(a <= 0) {
			throw new IllegalArgumentException("No se puede calcular");
		}
		return Math.log(a);
	}
	
	public static int factorial(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("No se puede calcular");
		}
		int resultado = 1;
		for(int i = 2; i <= n; i++) {
			resultado *= i;
		}
		return resultado;
	}

}
