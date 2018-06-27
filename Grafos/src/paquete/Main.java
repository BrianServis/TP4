package paquete;

public class Main {

	public static void main(String[] args) {

		try {
			GrafoRegular grafoUno = new GrafoRegular(3, 2);
			grafoUno.mostrarNodos();
			grafoUno.mostrarAristas();
			grafoUno.mostrarAdyacencia();
		} catch (Exception evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
		
		try {
			GrafoRegular grafoDos = new GrafoRegular(3, 0.5);
			grafoDos.mostrarNodos();
			grafoDos.mostrarAristas();
			grafoDos.mostrarAdyacencia();
		} catch (Exception evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
	}
}
