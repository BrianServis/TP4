package paquete;

public abstract class Generador {
	
	protected MatrizSimetrica adycencia;
	
	public Generador() {

	}
	
	public abstract void generarDadoGrado(int g);

	public void mostrarNodos(Nodo[] nodos) {
		System.out.println("Nodos:");
		for (int i = 0; i < nodos.length; i++)
			System.out.println(nodos[i]);
	}
	
	public void mostrarArsitas(Arista[] aristas) {
		System.out.println("Aristas:");
		for (int i = 0; i < aristas.length; i++)
			System.out.println(aristas[i]);
	}
}
