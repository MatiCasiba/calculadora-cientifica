package calculadora.modelo;

public class Operacion {
	private String nombre;
	private double[] operandos;
	private double resultado;
	
	public Operacion(String nombre, double... operandos) {
		this.nombre = nombre.toLowerCase().trim();
		this.operandos = operandos.clone();
		
	}
}
