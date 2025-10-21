package calculadora.core;

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
	}
}
