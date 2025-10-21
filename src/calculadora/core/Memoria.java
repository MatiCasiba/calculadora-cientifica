package calculadora.core;

public class Memoria {
	private Double valor;
	
	public Memoria() {
		this.valor = null;
		verificarIREP();
	}
	
	public void guardar(double v) {
		if(Double.isNaN(v) || Double.isInfinite(v)) {
			throw new IllegalArgumentException("El valor guardado debe ser un número real válido");
		}
		this.valor = v;
		verificarIREP();
	}
	
	public double recuperar() {
		if(estaVacia()) {
			throw new IllegalStateException("La memoria está vacía");
		}
		return valor;
	}
	
	public boolean estaVacia() {
		return this.valor == null;
	}
	
	private void verificarIREP() {
		if(valor != null) {
			if(Double.isNaN(valor) || Double.isInfinite(valor)) {
				throw new IllegalStateException("La memoria contiene uun valor no válido");
			}
		}
	}
}
