package unitarios;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.fullteaching.backend.forum.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.fullteaching.backend.entry.*;


public class forumTest {

	static Forum forum ;

	@BeforeAll
	public static void inicializa() {
		forum = new Forum();
		forum.setActivated(true);
	}
	@Test
	public void test_construtor_boolean() {
		Forum forum_true = new Forum(true);
		assertEquals(forum_true.getEntries().size(), 0);
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
		assertEquals(forum.toString(), "Forum[activated: \"true\", #entries: \"1\", #comments: \"0\"]");
	}
	
	@Test
	public void testList() {
		Entry entry = mock(Entry.class);
		when(entry.getTitle()).thenReturn("aaa");
		ArrayList<Entry> lista = new ArrayList<Entry>();
		lista.add(entry);
		forum.setEntries(lista);
		assertEquals(forum.getEntries().size(), 1);
		
		
	}
}
