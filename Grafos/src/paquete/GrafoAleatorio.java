package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GrafoAleatorio extends Grafo{
	
	private double probabilidadArista;
	private boolean dadoPorcentaje;
	
	public GrafoAleatorio() {

	}
	
	public GrafoAleatorio(double p, int n) throws Exception {
		if(n < 1)
			throw new Exception("La cantidad (" + n + ") de nodos debe ser positiva");
		
		if( p < 0 || 1 < p )
			throw new Exception("El porcentaje de adyacencia (" + p + ") debe ser 0 <= p <= 1");
		
		this.probabilidadArista = p;
		this.adycencia = new MatrizSimetrica(n);
		this.nodos = new Nodo[n];
		this.cantidadAristas = 0;
		this.aristas = new Arista[(n*n-n)/2];
		this.dadoPorcentaje = false;
		super.cargarNodos();
	}

	public GrafoAleatorio(int n, double p) throws Exception{
		if(n < 1)
			throw new Exception("La cantidad (" + n + ") de nodos debe ser positiva");
		
		if( p < 0 || 1 < p )
			throw new Exception("El porcentaje de adyacencia (" + p + ") debe ser 0 <= p <= 1");
		
		int ca = (int) Math.round(p * ( (n * n - n) / 2) );
//		System.out.println("Cantidad de aristas: " + ca);
		this.adycencia = new MatrizSimetrica(n);
		this.nodos = new Nodo[n];
		this.aristas = new Arista[ca];
		this.cantidadAristas = 0;
		this.dadoPorcentaje = true;
		super.cargarNodos();
	}

	@Override
	public void generar() {
		if( this.dadoPorcentaje)
			this.generarAristasAleatorias();
		else
			this.generarDadaProbabilidad();
	}
	
	private void generarDadaProbabilidad() {
		Random rand = new Random();
		
		for (int i = 0; i < nodos.length; i++)
		for (int j = i + 1; j < nodos.length; j++)
			if( rand.nextDouble() <= this.probabilidadArista ) {
				this.aristas[this.cantidadAristas++] = new Arista(this.nodos[i], this.nodos[j], 1);
				this.adycencia.setFC(i, j, 1);
			}
	}
	
	private void generarAristasAleatorias() {
		ArrayList<Arista> aristasTotales = new ArrayList<>();
		
		for (int i = 0; i < nodos.length; i++) 
			for (int j = i+1; j < nodos.length; j++) 
				aristasTotales.add(new Arista(this.nodos[i], this.nodos[j]));
			
		Collections.shuffle(aristasTotales);
		
		for (int i = 0; i < this.aristas.length; i++) {
			this.aristas[i] = aristasTotales.get(i);
			this.adycencia.setFC(this.aristas[i].origen().posicion(), this.aristas[i].destino().posicion(), 1);
		}
		this.cantidadAristas = this.aristas.length;
		aristasTotales.clear();
	}
}
