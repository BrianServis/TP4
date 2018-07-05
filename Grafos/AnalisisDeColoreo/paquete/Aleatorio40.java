package paquete;

import java.io.IOException;

public class Aleatorio40 {

	public static void main(String[] args) throws IOException {
		
		int coloresMinimos, iteracion, cantidadCorridas = 10000;
		
		System.out.println("Grafo aleatorio %40");
		GrafoDeArchivo grafoUno = new GrafoDeArchivo("grafos\\aleatorio40.in");
		
		System.out.println("\nAleatorio");
		coloresMinimos = grafoUno.coloreoAleatorio();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoUno.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		System.out.println("\nMatula");
		coloresMinimos = grafoUno.coloreoMatula();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoUno.coloreoMatula();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " + iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		System.out.println("\nWelshPowell");
		coloresMinimos = grafoUno.coloreoWelshPowell();
		iteracion = 0;
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoUno.coloreoWelshPowell();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
				System.out.println("\tNuevo minimo: " + coloresMinimos + " en iteracion " +iteracion);
			}
		}
		System.out.println("\n\tCantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);

	}

}
