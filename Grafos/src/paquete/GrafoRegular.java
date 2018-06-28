package paquete;

public class GrafoRegular extends Generador {
	
	private int grado;

	public GrafoRegular() {

	}

	public GrafoRegular(int n, int g) throws Exception {
		if (n < 1)
			throw new Exception("La cantidad (" + n + ") de nodos debe ser positiva");

		if (g >= n)
			throw new Exception("El grado (" + g + ") debe ser menor que la cantidad (" + n + ") de nodos");

		if (n % 2 != 0 && g % 2 != 0)
			throw new Exception("Si la cantidad (" + n + ") de nodos es impar el grado (" + g + ") debe ser par");

		this.adycencia = new MatrizSimetrica(n);
		this.nodos = new Nodo[n];
		this.aristas = new Arista[(n * g) / 2];
		this.cantidadAristas = 0;
		this.grado = g;
		super.cargarNodos();
	}
	
	public GrafoRegular(int n, double p) throws Exception{
		if (n < 1)
			throw new Exception("La cantidad (" + n + ") de nodos debe ser positiva");
		
		if( p < 0 || 1 < p )
			throw new Exception("El porcentaje de adyacencia (" + p + ") debe ser 0 <= p <= 1");

		int g = (int) Math.round(p*(n-1));
		this.grado = g + ( ( n % 2 != 0 && g % 2 != 0 )? 1 : 0);
		
		this.adycencia = new MatrizSimetrica(n);
		this.nodos = new Nodo[n];
		this.aristas = new Arista[(n * this.grado) / 2];
		this.cantidadAristas = 0;
		super.cargarNodos();
	}

	@Override
	public void generar() {
		this.generarDadoGrado(this.grado);
	}
	
	public void generarDadoGrado(int g) {
		if (g == 0)
			return;

		if (g == 1) {
			int mitad = this.nodos.length / 2;
			for (int i = 0; i < mitad; i++) {
				this.aristas[this.cantidadAristas++] = new Arista(this.nodos[i], this.nodos[i + mitad]);
				this.adycencia.setFC(i, i + mitad, 1);
			}
			return;
		}
		
		if( g % 2 == 0 ) {
			generarDadoGrado(g-2);
			int offset = g / 2;
			for (int i = 0; i < this.nodos.length; i++) {
				this.aristas[this.cantidadAristas++] = new Arista(this.nodos[i], this.nodos[(i+offset) % this.nodos.length]);
				this.adycencia.setFC(i, (i+offset) % this.nodos.length, 1);
			}
		}
		else {
			generarDadoGrado(1);
			generarDadoGrado(g-1);
		}

	}
}
