package paquete;

import java.io.IOException;

public class Aleatorio40 {

	public static void main(String[] args) throws IOException {
		
		int coloresMinimos, iteracion = 0, cantidadCorridas = 10000;
		
		System.out.println("Grafo aleatorio %40");
		GrafoDeArchivo grafoUno = new GrafoDeArchivo("grafos\\aleatorio40.in");
		
		coloresMinimos = grafoUno.coloreoAleatorio();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoUno.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Aleatorio)	 Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
		
		coloresMinimos = grafoUno.coloreoMatula();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoUno.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Matula)	 Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);
	
		coloresMinimos = grafoUno.coloreoWelshPowell();
		for (int i = 1; i < cantidadCorridas; i++) {
			int cantidadColoresActual = grafoUno.coloreoAleatorio();
			if( cantidadColoresActual < coloresMinimos ) {
				coloresMinimos = cantidadColoresActual;
				iteracion = i;
			}
		}
		System.out.println("(Welsh-Powell)	 Cantidad minima de colores " + coloresMinimos + " en iteracion " + iteracion);

	}

}
