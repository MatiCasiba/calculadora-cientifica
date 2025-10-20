package calculadora.core;

public class Memoria {
	private Double valor;
	
	public Memoria() {
		this.valor = null;
		
	}
	
	private void verificarIREP() {
		if(valor != null) {
			if(Double.isNaN(valor) || Double.isInfinite(valor)) {
				throw new IllegalStateException("La memoria contiene uun valor no válido");
			}
		}
	}
}
