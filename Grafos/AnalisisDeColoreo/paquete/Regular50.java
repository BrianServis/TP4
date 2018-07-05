package paquete;

import java.io.FileNotFoundException;

public class Regular50 {

	public static void main(String[] args) throws FileNotFoundException {

		int coloresMinimos, iteracion, cantidadCorridas = 1000;
		
		
		System.out.println();
		System.out.println("Grafo regular %50");
		GrafoDeArchivo grafoCuatro = new GrafoDeArchivo("grafos\\regular50.in");
		
		System.out.println("\nAleatorio");
		coloresMinimos = grafoCuatro.coloreoAleatorio();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCuatro.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		System.out.println("\nMatula");
		coloresMinimos = grafoCuatro.coloreoMatula();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCuatro.coloreoMatula();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		System.out.println("\nWelshPowell");
		coloresMinimos = grafoCuatro.coloreoWelshPowell();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCuatro.coloreoWelshPowell();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	}

}
