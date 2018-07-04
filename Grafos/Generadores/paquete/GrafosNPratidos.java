package paquete;

public class GrafosNPratidos {

	public static void main(String[] args) throws Exception {

		GrafoNPartito grafoUno = new GrafoNPartito(8, 3);
		grafoUno.generar();
		grafoUno.mostrarNodos();
		grafoUno.mostrarAristas();
		grafoUno.mostrarAdyacencia();
	}

}
