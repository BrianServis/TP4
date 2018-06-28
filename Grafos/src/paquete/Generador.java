package paquete;

public abstract class Generador {
	
	protected MatrizSimetrica adycencia;
	protected Nodo[] nodos;
	protected Arista[] aristas;
	protected int cantidadAristas;
	
	public Generador() {

	}
	
	public abstract void generar();

	public void cargarNodos() {
		for (int i = 0; i < this.nodos.length; i++)
			nodos[i] = new Nodo(i, i + 1);
	}
	
	public void mostrarNodos() {
		System.out.println("Nodos:");
		for (int i = 0; i < this.nodos.length; i++)
			System.out.println(nodos[i]);
	}
	
	public void mostrarAristas() {
		System.out.println("Aristas:");
		for (int i = 0; i < this.cantidadAristas; i++)
			System.out.println(aristas[i]);
	}
	
	public void mostrarAdyacencia() {
		this.adycencia.verMatrizSimetrica();
	}
}
