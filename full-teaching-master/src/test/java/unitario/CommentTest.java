package unitario;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.fullteaching.backend.comment.*;
import com.fullteaching.backend.user.*;


public class CommentTest {

	private static Comment comment;
	
	@BeforeAll
	public static void inicializa() {
		User user = mock(User.class);
		comment = new Comment("teste", 8122020, user);
		comment.setId(8);
		comment.setDate(11112012);
		
		
	}

	@Test
	public void testa_mensagem() {
		assertEquals(comment.getMessage(), "teste");
		comment.setMessage("teste2");
		assertEquals(comment.getMessage(), "teste2");
		
	}
	
	@Test
	public void testa_id() {
		assertEquals(comment.getId(), 8);
		comment.setId(2);
		assertEquals(comment.getId(), 2);
		
	}
	
	@Test
	public void testa_data() {
		assertEquals(comment.getDate(), 11112012);
		comment.setDate(12112012);
		assertEquals(comment.getDate(), 12112012);
		
	}
	
	@Test
	public void testa_toString() {
		assertEquals(comment.toString(), "Comment[message: \"teste\", author: \"null\", parent: \"null\", #replies: 0date: \"11112012\"]");
		
		
		
	}
}
