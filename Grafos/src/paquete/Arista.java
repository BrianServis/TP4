package paquete;

public class Arista {

	private Nodo origen;
	private Nodo destino;
	private int peso;
	private boolean ponederada;
	
	public Arista() {
	}
	
	public Arista(Nodo origen, Nodo destino, int peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
		this.ponederada = true;
	}
	
	public Arista(Nodo origen, Nodo destino) {
		this.origen = origen;
		this.destino = destino;
		this.ponederada = false;
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
		if( this.ponederada )
			return "Arista [" + this.origen + " <--( " + this.peso + " )--> " + this.destino + "]";
		else
			return "Arista [" + this.origen + " <----> " + this.destino + "]";
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
