package unitario;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




import com.fullteaching.backend.session.*;


public class SessionTest {
	
	Session session  = new Session ("Titulo", "description", 123L);
	
	@Before
	public void inicializa() {
		session.setId(1L);	
	}
	
	@Test
	public void testaId() {
		assertNotEquals((long)session.getId(), 8L);
		session.setId(8L);
		assertEquals((long)session.getId(), 8L);
	}
	
	@Test
	public void testaTitulo() {
		assertNotEquals(session.getTitle(), "aaaa");
		session.setTitle("aaa");
		assertEquals(session.getTitle(), "aaa");
	}
	
	@Test
	public void testaDescription() {
		assertEquals(session.getDescription(), "description");
		session.setDescription("new description");
		assertEquals(session.getDescription(), "new description");
	}
	
	@Test
	public void testaData() {
		session.setDate(20082020);
		assertEquals(session.getDate(), 20082020);
	}
	
	@Test
	public void testaEquals() {
		Session session2  = new Session ("Titulo", "description", 123L);
		session2.setId(1L);
		assertFalse(session.equals(session2));
		assertTrue(session.equals(session));
	}
	
	@Test
	public void TestToString() {
		assertNotEquals(session.toString(), "Session fail");
	}
	
	
	
}
