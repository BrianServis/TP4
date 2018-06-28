package paquete;

public class GrafoNPartito extends Generador{
	
	private int grupos;
	
	public GrafoNPartito() {
	}
	
	public GrafoNPartito(int n, int g) throws Exception {
		if (n < 1)
			throw new Exception("La cantidad (" + n + ") de nodos debe ser positiva");
		
		if (g < 1)
			throw new Exception("La cantidad (" + g + ") de grupos debe ser positiva");
		
		if (n < g)
			throw new Exception("La cantidad (" + g + ") de grupos no debe ser mayor que la cantidad (" + n + ") de nodos");
		
		this.adycencia = new MatrizSimetrica(n);
		this.nodos = new Nodo[n];
		this.aristas = new Arista[(n * n - n) / 2];
		this.cantidadAristas = 0;
		this.grupos = g;
		super.cargarNodos();
	}

	@Override
	public void generar() {
		this.generarDadoNodoGrupos();
	}

	public void generarDadoNodoGrupos() {
		Nodo[][] grupos = new Nodo[this.grupos][];
		
		int n = this.nodos.length;
		int cantidad = n / this.grupos;
		int resto = n % this.grupos;
		int nodo = 0;
		for (int i = 0; i < grupos.length; i++) {
			grupos[i] = new Nodo[cantidad +  (i < this.grupos - resto ? 0 : 1)];
			for (int j = 0; j < grupos[i].length; j++) 
				grupos[i][j] = this.nodos[nodo++];
		}
		
		for (int i = 0; i < grupos.length; i++) 
		for (int j = i + 1; j < grupos.length; j++) 
		for (int k = 0; k < grupos[i].length; k++) 
		for (int l = 0; l < grupos[j].length; l++) {
			this.aristas[this.cantidadAristas++] = new Arista(grupos[i][k], grupos[j][l]);
			this.adycencia.setFC(grupos[i][k].posicion(), grupos[j][l].posicion(), 1);
//			System.out.println(this.aristas[this.cantidadAristas-1]);
		}
		
		Arista[] aristasAux = new Arista[this.cantidadAristas];
		
		for (int i = 0; i < aristasAux.length; i++)
			aristasAux[i] = this.aristas[i];
		
		this.aristas = aristasAux;
	}
}
