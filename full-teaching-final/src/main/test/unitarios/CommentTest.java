package unitarios;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.user.User;


public class CommentTest {

	private static Comment comment;
	
	@BeforeAll
	public static void inicializa() {
		User user = mock(User.class);
		when(user.getName()).thenReturn("luis");
		
		comment = new Comment();
		comment.setMessage("teste");
		comment.setDate(8122020);
		comment.setUser(user);
		comment.setId(8);
		comment.setDate(11112012);		
	}

	@Test
	public void testa_construct() {
		User user_new = mock(User.class);
		when(user_new.getName()).thenReturn("Carlos");
		Comment comment_new = new Comment("aaa", 2112020, user_new);
		assertEquals(comment_new.getUser().getName(), "Carlos");
		
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
	
	
	
	@Test
	public void test_replay() {
		User user_replay = mock(User.class);
		when(user_replay.getName()).thenReturn("luis");
		Comment replay = new Comment("aaa", 20082020, user_replay, comment);
		ArrayList<Comment> list_replay = new ArrayList<Comment>();
		list_replay.add(replay);
		comment.setReplies(list_replay);
		assertEquals(comment.getReplies().size(), 1);

	}
	
	@Test
	public void set_User() {
		assertEquals(comment.getUser().getName(), "luis");
		User user_new = mock(User.class);
		when(user_new.getName()).thenReturn("Carlos");
		comment.setUser(user_new);
		assertEquals(comment.getUser().getName(), "Carlos");		
	}
	
	@Test
	public void comment_Test() {
		User user_new = mock(User.class);
		when(user_new.getName()).thenReturn("Carlos");
		Comment commentParent = new Comment("aaa", 20082020, user_new, comment);
		comment.setCommentParent(commentParent);
		assertEquals(comment.getCommentParent().getUser().getName(), "Carlos");	
	}
	
	
}
