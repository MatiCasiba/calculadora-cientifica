package calculadora.core;

import java.util.ArrayList;
import java.util.List;
import calculadora.modelo.Operacion;

public class HistorialOperaciones {
	private List<Operacion> lista;
	
	public HistorialOperaciones() {
		this.lista = new ArrayList<>();
		verificarIREP();
	}
	
	private void verificarIREP() {
		if(lista == null) {
			throw new IllegalStateException("La lista de operaciones no puede ser nula");
		}
		for(Operacion op : lista) {
			if(op == null) {
				throw new IllegalStateException("El historial contiene una operación nula");
			}
		}
	}
}
