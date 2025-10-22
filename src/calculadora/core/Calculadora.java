package calculadora.core;

import calculadora.modelo.Operacion;
import calculadora.modelo.OpercionesMatematicas;

public class Calculadora {
	private double pantalla;
	private Memoria memoria;
	private HistorialOperaciones historial;
	private OpercionesMatematicas operaciones;
	
	public Calculadora() {
		this.pantalla = 0.0;
		this.memoria = new Memoria();
		this.historial = new HistorialOperaciones();
		this.operaciones = new OpercionesMatematicas();
		verificarIREP();
	}
	
	public void ingresarNumero(double n) {
		if(Double.isNaN(n) || Double.isInfinite(n)) {
			throw new IllegalArgumentException("El númmero ingresado no es válido");
		}
		this.pantalla = n;
		verificarIREP();
	}
	
	public void aplicarOperacion(Operacion op) {
		if(op == null) {
			throw new IllegalArgumentException("La operación no puede ser nula");
		}
		double resultado;
		switch(op.getNombre().toLowerCase()) {
		case "suma":
			resultado = operaciones.sumar(op.getOperandos()[0], op.getOperandos()[1]);
			break;
		case "resta":
			resultado = operaciones.restar(op.getOperandos()[0], op.getOperandos()[1]);
			break;
		case "multiplicacion":
			resultado = operaciones.multiplicar(op.getOperandos()[0], op.getOperandos()[1]);
			break;
		case "division":
			resultado = operaciones.dividir(op.getOperandos()[0], op.getOperandos()[1]);
			break;
		case "potencia":
			resultado = operaciones.potencia(op.getOperandos()[0], op.getOperandos()[1]);
			break;
		case "raiz":
			resultado = operaciones.raiz(op.getOperandos()[0]);
			break;
		case "seno":
			resultado = operaciones.seno(op.getOperandos()[0]);
			break;
		case "coseno":
			resultado = operaciones.coseno(op.getOperandos()[0]);
			break;
		case "log":
		case "logaritmo":
			resultado = operaciones.logaritmo(op.getOperandos()[0]);
			break;
		case "factorial":
			resultado = operaciones.factorial((int) op.getOperandos()[0]);
			break;
		default:
			throw new IllegalArgumentException("Operación no reconocida: " + op.getNombre());
		}
		op.setResultado(resultado);
		historial.agregar(op);
		this.pantalla = resultado;
		verificarIREP();
	}
	
	public void guardarEnMemoria() {
		memoria.guardar(pantalla);
	}
	
	public double recuperarMemoria() {
		double valor = memoria.recuperar();
		pantalla = valor;
		return valor;
	}
	
	private void verificarIREP() {
		if(Double.isNaN(pantalla) || Double.isInfinite(pantalla)) {
			throw new IllegalStateException("La pantalla contiene un valor no válido");
		}
		if(memoria == null){
			throw new IllegalStateException("La memoria no puede ser nula");
		}
		if(historial == null) {
			throw new IllegalStateException("El historial no puede ser nulo");
		}
	}
}
