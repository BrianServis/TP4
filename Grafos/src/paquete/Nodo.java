package paquete;

import java.util.Comparator;
import java.util.Random;

public class Nodo implements Comparator<Nodo>{

	private int posicion;
	private int valor;
	private int grado;
	
	public Nodo() {
	}
	
	public Nodo(int posicion, int valor) {
		this.posicion = posicion;
		this.valor = valor;
	}
	
	public Nodo(int valor) {
		this(0,valor);
	}
	
	public int valor() {
		return this.valor;
	}
	
	public int posicion() {
		return this.posicion;
	}
	
	public void setGrado(int g) {
		this.grado = g;
	}
	
	public void mostrar() {
		System.out.println(posicion + ".Nodo [" + valor + "] grado:" + grado);
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
		Random rand = new Random();
		if( uno.grado != dos.grado )
		return uno.grado - dos.grado;
		if( rand.nextInt() % 2 == 0 )
			return -1;
		else
			return 1;
	}
}
