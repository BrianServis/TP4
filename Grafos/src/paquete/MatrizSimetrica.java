package paquete;

import java.util.Arrays;

public class MatrizSimetrica {
	
	private Integer[] vector;
	private int n;
	
	public MatrizSimetrica(int cantidadNodos) {
		this.n = cantidadNodos;
		int tam = (cantidadNodos * cantidadNodos - cantidadNodos)/2;
		vector = new Integer[tam];
	}

	public void setFC(int f, int c, int valor) {
		if( f == c )
			return;
		
		int i;
		
		if( f > c ) {
			i = f; f = c; c = i;
		}

		i = f * this.n + c - (f * f + 3 * f + 2)/2;
		this.vector[i] = valor;
	}
	
	public Integer getFC(int f, int c) {
		if( f == c )
			return null;
		
		if( f > c )
			return getFC(c, f);
		
		int i = f * this.n + c - (f * f + 3 * f + 2)/2;
		return this.vector[i];
	}
	
	public void verMatrizSimetrica() {
		System.out.println("Matriz simetrica");
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++)
				System.out.print(String.format("%-2s ", getFC(i, j) == null ? "-" : String.valueOf(getFC(i, j))));
			System.out.println();
		}
	}
	
	public Integer gradoMaximo() {
		int maximo = 0;
		
		for (int i = 0; i < this.n; i++) {
			int grado = 0;
			for (int j = 0; j < this.n; j++)
				if( getFC(i, j) != null )
					grado++;
			maximo = Math.max(maximo, grado);
		}
		
		return maximo;
	}
	
	public Integer gradoMinimo() {
		int minimo = this.n-1;
		
		for (int i = 0; i < this.n; i++) {
			int grado = 0;
			for (int j = 0; j < this.n; j++)
				if( getFC(i, j) != null )
					grado++;
			minimo = Math.min(minimo, grado);
		}
		
		return minimo;
	}
	
	public int gradoNodo(int n) {
		int grado = 0;
		
		for (int i = 0; i < this.n; i++)
			if( getFC(n, i) != null )
				grado++;
		
		return grado;
	}
	
	@Override
	public String toString() {
		return "MatrizSimetrica " + Arrays.toString(vector);
	}

	
}
