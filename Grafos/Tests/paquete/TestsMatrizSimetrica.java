package paquete;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestsMatrizSimetrica {
	
	MatrizSimetrica adyacencia;
	int tam;
	
	@Before
	public void setUp() {
		this.tam = 4;
		this.adyacencia = new MatrizSimetrica(tam);
	}

	@Test
	public void testSetGet() {
		Integer[] valor = { 1, 2, 3, 4, 5, 6};

		this.adyacencia.setFC(0, 1, 1);
		assertEquals(valor[0], this.adyacencia.getFC(1, 0));

		this.adyacencia.setFC(0, 2, 2);
		assertEquals(valor[1], this.adyacencia.getFC(2, 0));
		
		this.adyacencia.setFC(0, 3, 3);
		assertEquals(valor[2], this.adyacencia.getFC(3, 0));
		
		this.adyacencia.setFC(1, 2, 4);
		assertEquals(valor[3], this.adyacencia.getFC(2, 1));
		
		this.adyacencia.setFC(1, 3, 5);
		assertEquals(valor[4], this.adyacencia.getFC(3, 1));
		
		this.adyacencia.setFC(2, 3, 6);
		assertEquals(valor[5], this.adyacencia.getFC(3, 2));
		
		assertEquals(null, this.adyacencia.getFC(0, 0));
	}

	@After
	public void testSyso() {	
		System.out.println(adyacencia);
		adyacencia.verMatrizSimetrica();
	}
}
