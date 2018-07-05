package paquete;

import java.io.FileNotFoundException;

public class Regular75 {

	public static void main(String[] args) throws FileNotFoundException {
		
		int coloresMinimos, iteracion = 0, cantidadCorridas = 1000;

		System.out.println();
		System.out.println("Grafo aleatorio %75");
		GrafoDeArchivo grafoCinco = new GrafoDeArchivo("grafos\\regular75.in");
		
		System.out.println("\nAleatorio");
		coloresMinimos = grafoCinco.coloreoAleatorio();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCinco.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		System.out.println("\nMatula");
		coloresMinimos = grafoCinco.coloreoMatula();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCinco.coloreoMatula();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		System.out.println("\nWelshPowell");
		coloresMinimos = grafoCinco.coloreoWelshPowell();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCinco.coloreoWelshPowell();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	}

}
