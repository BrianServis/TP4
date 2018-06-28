package paquete;

public class Main {

	public static void main(String[] args) {

		try {
			GrafoRegular grafoUno = new GrafoRegular(8, 4);
			grafoUno.generar();
			grafoUno.mostrarNodos();
			grafoUno.mostrarAristas();
			grafoUno.mostrarAdyacencia();
		} catch (Exception evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
		
		try {
			GrafoRegular grafoDos = new GrafoRegular(8, 0.57);
			grafoDos.generar();
			grafoDos.mostrarNodos();
			grafoDos.mostrarAristas();
			grafoDos.mostrarAdyacencia();
		} catch (Exception evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
		
		try {
			GrafoNPartito grafoTres = new GrafoNPartito(8, 2);
			grafoTres.generar();
			grafoTres.mostrarNodos();
			grafoTres.mostrarAristas();
			grafoTres.mostrarAdyacencia();
		} catch (Exception evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
	}
}
