package paquete;

import java.io.FileNotFoundException;

public class Regular50 {

	public static void main(String[] args) throws FileNotFoundException {

		int coloresMinimos, iteracion = 0, cantidadCorridas = 1000;
		
		
		System.out.println();
		System.out.println("Grafo regular %50");
		GrafoDeArchivo grafoCuatro = new GrafoDeArchivo("grafos\\regular50.in");
		coloresMinimos = grafoCuatro.coloreoAleatorio();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCuatro.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Aleatorio)	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		coloresMinimos = grafoCuatro.coloreoMatula();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCuatro.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Matula) 	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		coloresMinimos = grafoCuatro.coloreoWelshPowell();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoCuatro.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Welsh-Powell) 	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	}

}
