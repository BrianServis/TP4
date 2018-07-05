package paquete;

import java.io.FileNotFoundException;

public class Aleatorio60 {

	public static void main(String[] args) throws FileNotFoundException {

		int coloresMinimos, iteracion = 0, cantidadCorridas = 1000;
		
		System.out.println();
		System.out.println("Grafo aleatorio %60");
		GrafoDeArchivo grafoDos = new GrafoDeArchivo("grafos\\aleatorio60.in");
		coloresMinimos = grafoDos.coloreoAleatorio();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoDos.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Aleatorio) 	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		coloresMinimos = grafoDos.coloreoMatula();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoDos.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Matula) 	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		coloresMinimos = grafoDos.coloreoWelshPowell();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoDos.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Welsh-Powell) 	Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	}
}
