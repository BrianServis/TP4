package paquete;

import java.io.FileNotFoundException;

public class Regular75 {

	public static void main(String[] args) throws FileNotFoundException {
		
		int coloresMinimos, iteracion = 0, cantidadCorridas = 1000;

		System.out.println();
		System.out.println("Grafo aleatorio %75");
		GrafoDeArchivo grafoCinco = new GrafoDeArchivo("grafos\\regular75.in");
		coloresMinimos = grafoCinco.coloreoAleatorio();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCinco.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Aleatorio) 	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		coloresMinimos = grafoCinco.coloreoMatula();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCinco.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Matula) 	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		coloresMinimos = grafoCinco.coloreoWelshPowell();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCinco.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Welsh-Powell)	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	}

}
