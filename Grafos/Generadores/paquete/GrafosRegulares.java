package paquete;

public class GrafosRegulares {

	public static void main(String[] args) throws Exception {
		
		GrafoRegular grafoUno = new GrafoRegular(10, 5);
		grafoUno.generar();
		grafoUno.mostrarNodos();
		grafoUno.mostrarAristas();
		grafoUno.mostrarAdyacencia();
		
		GrafoRegular grafoDos = new GrafoRegular(10, 0.7);
		grafoDos.generar();
		grafoDos.mostrarNodos();
		grafoDos.mostrarAristas();
		grafoDos.mostrarAdyacencia();
	}

}
