package uy.edu.cure.servidor.central.webapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import uy.edu.cure.servidor.central.webapp.rest.api.TestRestController;

@RunWith(JUnit4.class)
public class TestRestControllerTest {

	@Test
	public void getClichedMessageMessageTest() {
		String actual = new TestRestController().getClichedMessage();
		assertEquals("Hello JUnit", actual);
	}
	
	@Test
	public void testString() {
		String s1 = new String("hola");
		String s2 = new String("hola");
		Integer i1 = new Integer(123);
		int i2= 123;
		System.out.println(s1.equals(s2));
	}
}
