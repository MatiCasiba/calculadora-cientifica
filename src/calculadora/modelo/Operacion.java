package calculadora.modelo;

public class Operacion {
	private String nombre;
	private double[] operandos;
	private double resultado;
	
	public Operacion(String nombre, double... operandos) {
		this.nombre = nombre.toLowerCase().trim();
		this.operandos = operandos.clone();
		verificarIREP();
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
	
	private void verificarIREP() {
		if(nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre de la operación no puede sr nulo o vacío");
		}
		if(operandos == null || operandos.length < 1) {
			throw new IllegalArgumentException("Debe haber al menos un operando");
		}
		if(nombre.equals("division") && operandos.length > 1 && operandos[1] == 0) {
			throw new IllegalArgumentException("No se puede dividir por cero");
		}
		if((nombre.equals("raiz") || nombre.equals("logaritmo")) && operandos[0] < 0) {
			throw new IllegalArgumentException("El operando debe ser mayor o igual a cero para " + nombre);
		}
	}
	
	public boolean esBinaria() {
		return switch(nombre) {
			case "suma","resta","multipliacion","divison","potencia" -> true;
			default -> false;
		};
	}
	
	//getters
	public String getNombre() {
		return nombre;
	}
	
	public double[] getOperandos() {
		return operandos.clone();
	}
	
	public double getResultado() {
		return resultado;
	}
}
