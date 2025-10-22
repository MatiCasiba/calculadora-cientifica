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
		verificarIREP();
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
