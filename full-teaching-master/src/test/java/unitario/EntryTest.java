package unitario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.fullteaching.backend.entry.*;
import com.fullteaching.backend.user.*;
import com.fullteaching.backend.comment.*;

public class EntryTest {

	private static Entry entry;
	private static ArrayList<Comment> lista;
	@BeforeAll
	public static void inicializa() {
		entry	= new Entry();
		entry.setTitle("aaa");
		entry.setDate(8112020);
		entry.setId(7);
		User user = mock(User.class);
		when(user.getName()).thenReturn("luis");
		entry.setUser(user);
		lista = new ArrayList<Comment>();
		entry.setComments(lista);
	}
	
	@Test
	public void testa_id() {
		assertEquals(entry.getId(), 7L);
		entry.setId(8);
		assertEquals(entry.getId(), 8L);
	}
	
	@Test
	public void testa_title() {
		assertEquals(entry.getTitle(), "aaa");
		entry.setTitle("Title");
		assertEquals(entry.getTitle(), "Title");
	}
	@Test
	public void testa_data() {
		assertEquals(entry.getDate(), 8112020);
		entry.setDate(12112012);
		assertEquals(entry.getDate(), 12112012);
	}
	
	@Test
	public void testa_comment() {
		Comment coment = mock(Comment.class);
		Comment coment2 = mock(Comment.class);
		when(coment.getMessage()).thenReturn("comentario0");
		when(coment2.getMessage()).thenReturn("comentario1");
		
		
		lista.add(coment);
		lista.add(coment2);
		
		entry.setComments(lista);
		
		for(int i = 0; i<entry.getComments().size(); i++) {
			Comment idx = entry.getComments().get(i);
			assertEquals(idx.getMessage(), "comentario"+i);
		}
		
		
	}
	
	@Test
	public void testa_user() {
		assertEquals(entry.getUser().getName(), "luis");		
	}
	
	@Test
	public void test_entry_constructor() {
		User user = mock(User.class);
		when(user.getName()).thenReturn("aaaa");
		Entry entry = new Entry("Title", 8112020, user);
		assertEquals(entry.getUser().getName(), "aaaa");
		assertEquals(entry.getTitle(), "Title");
	}
	
	@Test
	public void testa_toString() {
		assertEquals(entry.toString(), "Entry[title: \"aaa\", author: \"null\", date: 8112020, #comments: 0]");		
	}
	
	
}
