package unitario;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.SpringVersion;

import com.fullteaching.backend.coursedetails.*;
import com.fullteaching.backend.filegroup.FileGroup;
import com.fullteaching.backend.forum.Forum;
import com.fullteaching.backend.course.Course;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class CourseDetailsTest {

	private static CourseDetails courseD;
	@BeforeAll
	public static void inicializa() {
		Course course = mock(Course.class);		
		courseD = new CourseDetails(course);
		
	}
	
	@Test
	public void testId() {
		courseD.setId(7);
		assertEquals(courseD.getId(), 7);
	}
	
	@Test
	public void testInfo() {
		courseD.setInfo("aaa");
		assertEquals(courseD.getInfo(), "aaa");
	}
	
	@Test
	public void testForum() {
		Forum forum = mock(Forum.class);
		when(forum.toString()).thenReturn("aaa");
		courseD.setForum(forum);
		assertEquals(courseD.getForum().toString(), "aaa");		
	}
	
	@Test
	public void testFiles() {
		FileGroup fileGroup = mock(FileGroup.class);
		when(fileGroup.getId()).thenReturn((long) 7);
		ArrayList<FileGroup> lista = new ArrayList<FileGroup>();
		lista.add(fileGroup);
		courseD.setFiles(lista);
		assertEquals(courseD.getFiles().size(), 1);
	}
	
	@Test
	public void testCourse() {
		Course course = mock(Course.class);
		when(course.getId()).thenReturn(7L);
		courseD.setCourse(course);
		assertEquals(courseD.getCourse().getId(), 7L);
	}
	
}
