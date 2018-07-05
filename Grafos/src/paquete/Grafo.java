package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Grafo {
	
	protected MatrizSimetrica adycencia;
	protected Nodo[] nodos;
	protected Arista[] aristas;
	protected int cantidadAristas;
	private int[] colorDelNodo;
	
	public Grafo() {

	}
	
	public void grabar(String archivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		
		salida.print(this.nodos.length + " " + this.cantidadAristas + " ");
		salida.print(String.format("%.2f ", (float)(2*this.cantidadAristas) / (this.nodos.length * this.nodos.length - this.nodos.length)));
		salida.print(this.adycencia.gradoMaximo() + " " + this.adycencia.gradoMinimo());
		salida.println();
		for (int i = 0; i < aristas.length; i++)
			salida.println(aristas[i].origen().valor() + " " + aristas[i].destino().valor());
		
		salida.close();
	}
	
	public abstract void generar();

	protected void cargarNodos() {
		for (int i = 0; i < this.nodos.length; i++)
			nodos[i] = new Nodo(i, i + 1);
	}
	
	public void cargarGrados() {
		for (int i = 0; i < nodos.length; i++) {
			this.nodos[i].setGrado(this.adycencia.gradoNodo(i));
//			this.nodos[i].mostrar();
		}
	}
	
	public int coloreoWelshPowell() {
		cargarGrados();
		PriorityQueue<Nodo> monticuloMaximo = new PriorityQueue<Nodo>(Collections.reverseOrder(new Nodo()));
		for (int i = 0; i < nodos.length; i++)
			monticuloMaximo.add(this.nodos[i]);
		
//		while (!monticuloMaximo.isEmpty())
//			monticuloMaximo.poll().mostrar();
		
		return colorearGrafo(monticuloMaximo);
	}
	
	public int coloreoMatula() {
		cargarGrados();
		PriorityQueue<Nodo> monticuloMinimo = new PriorityQueue<Nodo>(new Nodo());
		for (int i = 0; i < nodos.length; i++)
			monticuloMinimo.add(this.nodos[i]);
		
//		while (!monticuloMinimo.isEmpty())
//			monticuloMinimo.poll().mostrar();
		
		return colorearGrafo(monticuloMinimo);
	}
	
	public int coloreoAleatorio() {
		ArrayList<Nodo> nodosDesordenados = new ArrayList<>();
		
		for (int i = 0; i < nodos.length; i++)
			nodosDesordenados.add(this.nodos[i]);
		
//		System.out.println("Ordenados");
//		for (Nodo nodo : nodosDesordenados) {
//			System.out.println(nodo);
//		}
		Collections.shuffle(nodosDesordenados);
//		System.out.println("Desordenados");
//		for (Nodo nodo : nodosDesordenados) {
//			System.out.println(nodo);
//		}
//		System.out.println("Monticulo");
		Queue<Nodo> monticuloAleaotrio = new LinkedList<>();
		for (Nodo nodo : nodosDesordenados)
			monticuloAleaotrio.add(nodo);
		
//		while (!monticuloAleaotrio.isEmpty())
//			monticuloAleaotrio.poll().mostrar();
		
		return colorearGrafo(monticuloAleaotrio);
	}
	
	private int colorearGrafo(Queue<Nodo> cola) {
		boolean[] estaColoreado = new boolean[this.nodos.length];
		this.colorDelNodo = new int[this.nodos.length];
		int cantidadColores = 0;
		
		while (!cola.isEmpty()) {
			Nodo siguiente = cola.poll();
			int color = 1;
			int nodo = siguiente.posicion();
			boolean puedoColorear;
			do {
				puedoColorear = true;
				for (int i = 0; i < nodos.length && puedoColorear; i++)
				if( this.adycencia.getFC(nodo, i) != null && estaColoreado[i] == true && this.colorDelNodo[i] == color ) {
					puedoColorear = false;
					color++;
				}
				
			} while (puedoColorear == false);
			
			this.colorDelNodo[nodo] = color;
			estaColoreado[nodo] = true;
			cantidadColores = Math.max(cantidadColores, color);
		}
		
		return cantidadColores;
	}
	
	public void grbarColoreoWelshPowell(String archivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		
		int cantidadColores = coloreoWelshPowell();
		
		salida.print(this.nodos.length + " " + cantidadColores +  " " + this.cantidadAristas + " ");
		salida.print(String.format("%.2f ", (float)(2*this.cantidadAristas) / (this.nodos.length * this.nodos.length - this.nodos.length)));
		salida.print(this.adycencia.gradoMaximo() + " " + this.adycencia.gradoMinimo());
		salida.println();
		
		for (int i = 0; i < nodos.length; i++)
			salida.println(this.nodos[i].valor() + " " + colorDelNodo[i]);
		
		
		salida.close();
	}
	
	public void grbarColoreoMatula(String archivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		
		int cantidadColores = coloreoMatula();
		
		salida.print(this.nodos.length + " " + cantidadColores +  " " + this.cantidadAristas + " ");
		salida.print(String.format("%.2f ", (float)(2*this.cantidadAristas) / (this.nodos.length * this.nodos.length - this.nodos.length)));
		salida.print(this.adycencia.gradoMaximo() + " " + this.adycencia.gradoMinimo());
		salida.println();
		
		for (int i = 0; i < nodos.length; i++)
			salida.println(this.nodos[i].valor() + " " + colorDelNodo[i]);
		
		
		salida.close();
		}
	
	public void grbarColoreoAleatorio(String archivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		
		int cantidadColores = coloreoAleatorio();
		
		salida.print(this.nodos.length + " " + cantidadColores +  " " + this.cantidadAristas + " ");
		salida.print(String.format("%.2f ", (float)(2*this.cantidadAristas) / (this.nodos.length * this.nodos.length - this.nodos.length)));
		salida.print(this.adycencia.gradoMaximo() + " " + this.adycencia.gradoMinimo());
		salida.println();
		
		for (int i = 0; i < nodos.length; i++)
			salida.println(this.nodos[i].valor() + " " + colorDelNodo[i]);
		
		
		salida.close();
	}
	
	public void desordenar() {
		Random rnd = ThreadLocalRandom.current();
		for (int i = nodos.length-1; i > 0 ; i--) {
			int index = rnd.nextInt(i+1);
			Nodo swap = this.nodos[index];
			this.nodos[index] = this.nodos[i];
			this.nodos[i] = swap;
		}
	}
	
	public void mostrarNodos() {
		System.out.println("Nodos:");
		for (int i = 0; i < this.nodos.length; i++)
			System.out.println(nodos[i]);
	}
	
	public void mostrarAristas() {
		System.out.println("Aristas:");
		for (int i = 0; i < this.cantidadAristas; i++)
			System.out.println(aristas[i]);
	}
	
	public void mostrarAdyacencia() {
		this.adycencia.verMatrizSimetrica();
	}
}
