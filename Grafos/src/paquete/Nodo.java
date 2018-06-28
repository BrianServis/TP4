package paquete;

import java.util.Comparator;

public class Nodo implements Comparator<Nodo>{

	private int posicion;
	private int valor;
	
	public Nodo() {
	}
	
	public Nodo(int posicion, int valor) {
		this.posicion = posicion;
		this.valor = valor;
	}
	
	public Nodo(int valor) {
		this(0,valor);
	}
	
	public int posicion() {
		return this.posicion;
	}

	@Override
	public String toString() {
		return "Nodo [" + valor + "]";
	}
	
	@Override
	public boolean equals(Object otro) {
		if (this == otro) return true;
		if (otro == null) return false;
		if (getClass() != otro.getClass()) return false;
		
		Nodo nodo = (Nodo) otro;
		
		if (this.posicion != nodo.posicion) return false;
		if (this.valor != nodo.valor) return false;
		
		return true;
	}

	@Override
	public int compare(Nodo uno, Nodo dos) {
		return uno.valor - dos.valor;
	}
	
	
}
