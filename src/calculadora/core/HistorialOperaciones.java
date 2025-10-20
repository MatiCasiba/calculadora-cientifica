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
	
	public void agregar(Operacion op) {
		if(op == null) {
			throw new IllegalArgumentException("No se puede agregar una operación nula al historial");
		}
		lista.add(op);
		verificarIREP();
	}
	
	public Operacion obtenerUltima() {
		if(lista.isEmpty()) {
			return null;
		}
		return lista.get(lista.size()-1);
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
