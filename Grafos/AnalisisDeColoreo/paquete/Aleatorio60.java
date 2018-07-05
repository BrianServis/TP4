package paquete;

import java.io.FileNotFoundException;

public class Aleatorio60 {

	public static void main(String[] args) throws FileNotFoundException {

		int coloresMinimos, iteracion, cantidadCorridas = 50;
		
		System.out.println();
		System.out.println("Grafo aleatorio %60");
		GrafoDeArchivo grafoDos = new GrafoDeArchivo("grafos\\aleatorio60.in");
		
		System.out.println("\nAleatorio");
		coloresMinimos = grafoDos.coloreoAleatorio();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoDos.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		System.out.println("\nMatula");
		coloresMinimos = grafoDos.coloreoMatula();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoDos.coloreoMatula();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " + iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		System.out.println("\nWelshPowell");
		coloresMinimos = grafoDos.coloreoWelshPowell();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoDos.coloreoWelshPowell();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	}
}
