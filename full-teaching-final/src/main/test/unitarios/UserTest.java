package unitarios;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.user.User;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;



public class UserTest {
				
		static User usuario	= new User("luis", "123", "L", "", "a", "b");
		
		static ArrayList<String> lista = new  ArrayList<String>();
		
		
		@BeforeAll
		public static void inicializa() {
			lista.add("a");
			lista.add("b");
			lista.add("c");
			usuario.setId((long) 7);
			usuario.setPicture("/usr/local/images/luis");
			usuario.setRegistrationDate(1607394394847L);
		}
			
		@Test
		public void troca_de_nome() {
			assertEquals(usuario.getName(), "luis");
			usuario.setName("luis sergio");
			assertEquals(usuario.getName(), "luis sergio");
		}
		
		@Test
		public void troca_de_id() {
			assertEquals((long)usuario.getId(), 7L);
			usuario.setId(8L);
			assertEquals((long)usuario.getId(), 8L);
		}
		
		@Test
		public void troca_de_nicK() {
			assertEquals(usuario.getNickName(), "L");
			usuario.setNickName("Ls");
			assertEquals(usuario.getNickName(), "Ls");
		}
		
		@Test
		public void verificarLista() {
			assertNotEquals(usuario.getRoles(), lista);
			usuario.setRoles(lista);
			assertEquals(usuario.getRoles(), lista);
		}
		
		@Test
		public void verificaPicture() {
			assertEquals(usuario.getPicture(), "/usr/local/images/luis");
		}
		
		@Test
		public void verificaDatas() {
			assertNotEquals(usuario.getRegistrationDate(), 1607394394837L);
			assertEquals(usuario.getRegistrationDate(), 1607394394847L);	
		}
		
		@Test
		public void comparaUsuarios() {
			User usuario2 = new User();
			assertFalse(usuario.equals(usuario2));	
		}
		
		@Test
		public void verificaStrings() {
			assertEquals(usuario.toString(), "Ls");
			assertEquals(usuario.hashCode(), "luis sergio".hashCode());	
		}
		
		@Test
		public void verificaPasswd() {
			assertNotEquals(usuario.getPasswordHash(), "123");
			usuario.setPasswordHash("123");
			assertEquals(usuario.getPasswordHash(), "123");
		}
		
		
		
		
}
