package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoDeArchivo extends Grafo{

	public GrafoDeArchivo(String archivo) throws FileNotFoundException {
		Scanner entrada = new Scanner(new File(archivo));
		
		String[] linea = entrada.nextLine().split(" ");
		int cantidadNodos = Integer.parseInt(linea[0]);
		int cantidadAristas = Integer.parseInt(linea[1]);
		
		this.adycencia = new MatrizSimetrica(cantidadNodos);
		this.nodos = new Nodo[cantidadNodos];
		this.aristas = new Arista[cantidadAristas];
		this.cantidadAristas = 0;
		this.cargarNodos();
		
		for (int i = 0; i < cantidadAristas; i++) {
			int origen = entrada.nextInt() - 1;
			int destino = entrada.nextInt() - 1;
			
			this.aristas[this.cantidadAristas++] = new Arista(this.nodos[origen], this.nodos[destino], 1);
			this.adycencia.setFC(origen, destino, 1);
		}
		
		entrada.close();
	}

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}
}
