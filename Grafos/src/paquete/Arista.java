package paquete;

public class Arista {

	private Nodo origen;
	private Nodo destino;
	private int peso;
	
	public Arista() {
	}
	
	public Arista(Nodo origen, Nodo destino, int peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}
	
	public Arista(Nodo origen, Nodo destino) {
		this(origen, destino, 0);
	}
	
	public Nodo origen() {
		return this.origen;
	}
	
	public Nodo destino() {
		return this.destino;
	}
	
	public int peso() {
		return this.peso;
	}

	@Override
	public String toString() {
		return "Arista [" + this.origen + " <--( " + this.peso + " )--> " + this.destino + "]";
	}

	@Override
	public boolean equals(Object otro) {
		if (this == otro) return true;
		if (otro == null) return false;
		if (getClass() != otro.getClass()) return false;
		
		Arista arista = (Arista) otro;
		
		if (destino == null) {
			if (arista.destino != null) return false;
		} else if (!this.destino.equals(arista.destino) && !this.destino.equals(arista.origen))
			return false;
		
		if (origen == null) {
			if (arista.origen != null) return false;
		} else if (!this.origen.equals(arista.origen) && !this.origen.equals(arista.destino))
			return false;
		
		if (this.peso != arista.peso) return false;
		
		return true;
	}
	
	
}
