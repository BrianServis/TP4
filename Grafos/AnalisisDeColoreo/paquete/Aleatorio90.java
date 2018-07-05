package paquete;

import java.io.FileNotFoundException;

public class Aleatorio90 {

	public static void main(String[] args) throws FileNotFoundException {

		int coloresMinimos, iteracion = 0, cantidadCorridas = 1000;
		
		System.out.println();
		System.out.println("Grafo aleatorio %90");
		GrafoDeArchivo grafoTres = new GrafoDeArchivo("grafos\\aleatorio90.in");
		coloresMinimos = grafoTres.coloreoAleatorio();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoTres.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Aleatorio)	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		coloresMinimos = grafoTres.coloreoMatula();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoTres.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Matula) 	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		coloresMinimos = grafoTres.coloreoWelshPowell();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoTres.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Welsh-Powell) 	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	}

}
