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
	
	public void mostrarTodas() {
		if(lista.isEmpty()) {
			System.out.println("El historial está vacío");
			return;
		}
		System.out.println("Historial de operaciones");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println((i+1) + ". " + lista.get(i).toString());
		}
	}
	
	public void limpiar() {
		lista.clear();
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
