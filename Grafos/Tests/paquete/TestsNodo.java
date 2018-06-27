package paquete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestsNodo {

	Nodo uno, dos, tres;

	@Before
	public void setUp() {
		uno = new Nodo(1);
		dos = new Nodo(1);
		tres = new Nodo(2);
	}

	@Test
	public void testEquals() {
		assertEquals(uno, dos);
	}
	
	@Test
	public void testNotEquals() {
		assertNotEquals(uno, tres);
	}
}
