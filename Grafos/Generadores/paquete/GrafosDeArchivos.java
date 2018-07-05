package paquete;

import java.io.FileNotFoundException;

public class GrafosDeArchivos {

	public static void main(String[] args) throws FileNotFoundException {

		GrafoDeArchivo grafo = new GrafoDeArchivo("grafos\\grafo.in");
		grafo.mostrarNodos();
		grafo.mostrarAristas();
		grafo.mostrarAdyacencia();
	}

}
