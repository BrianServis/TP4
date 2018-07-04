package paquete;

public class GrafosAleatorios {

	public static void main(String[] args) throws Exception {
		GrafoAleatorio grafoUno = new GrafoAleatorio(10,0.6);
		grafoUno.generar();
		grafoUno.mostrarNodos();
		grafoUno.mostrarAristas();
		grafoUno.mostrarAdyacencia();
		
		GrafoAleatorio grafoDos = new GrafoAleatorio(0.7,10);
		grafoDos.generar();
		grafoDos.mostrarNodos();
		grafoDos.mostrarAristas();
		grafoDos.mostrarAdyacencia();
	}
}
