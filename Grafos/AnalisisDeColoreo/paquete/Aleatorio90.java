package paquete;

import java.io.FileNotFoundException;

public class Aleatorio90 {

	public static void main(String[] args) throws FileNotFoundException {

		int coloresMinimos, iteracion, cantidadCorridas = 1000;
		
		System.out.println();
		System.out.println("Grafo aleatorio %90");
		GrafoDeArchivo grafoTres = new GrafoDeArchivo("grafos\\aleatorio90.in");
		
		System.out.println("\nAleatorio");
		coloresMinimos = grafoTres.coloreoAleatorio();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoTres.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		System.out.println("\nMatula");
		coloresMinimos = grafoTres.coloreoMatula();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoTres.coloreoMatula();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " + iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		System.out.println("\nWelshPowell");
		coloresMinimos = grafoTres.coloreoWelshPowell();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoTres.coloreoWelshPowell();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	}

}
