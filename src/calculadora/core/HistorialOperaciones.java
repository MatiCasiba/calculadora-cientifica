package calculadora.core;

import java.util.ArrayList;
import java.util.List;
import calculadora.modelo.Operacion;

public class HistorialOperaciones {
	private List<Operacion> lista;
	
	public HistorialOperaciones() {
		this.lista = new ArrayList<>();
	}
}
