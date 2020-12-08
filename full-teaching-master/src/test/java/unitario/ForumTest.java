package unitario;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.fullteaching.backend.forum.*;
import org.mockito.*;

public class ForumTest {

	static Forum forum = new Forum(false);

	@BeforeAll
	public static void inicializa() {
		forum.setActivated(true);
	}
	
	@Test
	public void troca_de_id() {
		assertNotEquals((long)forum.getId(), 7L);
		forum.setId(8L);
		assertEquals((long)forum.getId(), 8L);
	}
	
	@Test
	public void testa_se_esta_ativado() {
		assertTrue(forum.isActivated());
		forum.setActivated(false);
		assertFalse(forum.isActivated());
	}
	
	@Test
	public void testeToString() {
		assertEquals(forum.toString(), "Forum[activated: \"true\", #entries: \"0\", #comments: \"0\"]");
	}
}
