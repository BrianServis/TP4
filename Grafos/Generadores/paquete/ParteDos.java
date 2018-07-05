package paquete;

public class ParteDos {

	public static void main(String[] args) throws Exception {

		GrafoAleatorio aleatorio40 = new GrafoAleatorio(600, 0.4);
		aleatorio40.generar();
		aleatorio40.grabar("grafos\\aleatorio40.in");
		
		GrafoAleatorio aleatorio60 = new GrafoAleatorio(600, 0.6);
		aleatorio60.generar();
		aleatorio60.grabar("grafos\\aleatorio60.in");
		
		GrafoAleatorio aleatorio90 = new GrafoAleatorio(600, 0.9);
		aleatorio90.generar();
		aleatorio90.grabar("grafos\\aleatorio90.in");
		
		GrafoRegular regular50 = new GrafoRegular(1000, .5);
		regular50.generar();
		regular50.grabar("grafos\\regular50.in");
		
		GrafoRegular regular75 = new GrafoRegular(1000, .75);
		regular75.generar();
		regular75.grabar("grafos\\regular75.in");
		
		
	}

}
