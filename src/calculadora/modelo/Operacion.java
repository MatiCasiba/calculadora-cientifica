package calculadora.modelo;

public class Operacion {
	private String nombre;
	private double[] operandos;
	private double resultado;
	
	public Operacion(String nombre, double... operandos) {
		this.nombre = nombre.toLowerCase().trim();
		this.operandos = operandos.clone();
		
	}
	
	public double calcular() {
		switch(nombre) {
			case "suma":
				resultado = OpercionesMatematicas.sumar(operandos[0], operandos[1]);
				break;
			case "resta":
				resultado = OpercionesMatematicas.restar(operandos[0], operandos[1]);
				break;
			case "multiplicacion":
				resultado = OpercionesMatematicas.multiplicar(operandos[0], operandos[1]);
				break;
			case "division":
				resultado = OpercionesMatematicas.dividir(operandos[0], operandos[1]);
				break;
			case "potencia":
				resultado = OpercionesMatematicas.potencia(operandos[0], operandos[1]);
				break;
			case "raiz":
				resultado = OpercionesMatematicas.raiz(operandos[0]);
				break;
			case "seno":
				resultado = OpercionesMatematicas.seno(operandos[0]);
				break;
			case "coseno":
				resultado = OpercionesMatematicas.coseno(operandos[0]);
			case "logaritmo":
				resultado = OpercionesMatematicas.logaritmo(operandos[0]);
				break;
			case "factorial":
				resultado = OpercionesMatematicas.factorial((int) operandos[0]);
				break;
			default:
				throw new IllegalArgumentException("Operación desconocida: " + nombre);
		}
		return resultado;
	}
	
	public boolean esBinaria() {
		return switch(nombre) {
			case "suma","resta","multipliacion","divison","potencia" -> true;
			default -> false;
		};
	}
}
