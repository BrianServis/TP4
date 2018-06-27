package paquete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestsArista {
	
	Arista auno, ados, atres, acuatro;
	
	@Before
	public void setUp() {
		Nodo nuno = new Nodo(1);
		Nodo ndos = new Nodo(2);
		Nodo ntres = new Nodo(3);
		
		auno = new Arista(nuno, ndos);
		ados = new Arista(ndos, nuno);
		atres = new Arista(nuno, ntres);
		acuatro = new Arista(nuno, ndos);
	}

	@Test
	public void testEquals1() {
		assertEquals(auno, acuatro);
	}
	
	@Test
	public void testEquals2() {
		assertEquals(auno, ados);
	}

	@Test
	public void testNotEquals() {
		assertNotEquals(auno, atres);
	}
}
