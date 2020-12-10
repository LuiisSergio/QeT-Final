package unitarios;


import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.user.User;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class courseTest {

    @Mock
    private User EXPECTED_TEACHER;

    @Mock
    private CourseDetails EXPECTED_DETAILS;

    private String EXPECTED_TITLE = "titulo";
    private String EXPECTED_IMAGE = "img.png";
    private long EXPECTED_ID = 10;

    @Test
    public void when_emptyConstructor_then_emptyObject() {
        Course course = new Course();

        assertEquals(course.getId(),0);
    }

    @Test
    public void when_constructorWithTitleImageTeacher_then_createdObject() {
        Course course = new Course(EXPECTED_TITLE, EXPECTED_IMAGE, EXPECTED_TEACHER);

        assertEquals(course.getTitle(), EXPECTED_TITLE);
        assertEquals(course.getImage(), EXPECTED_IMAGE);
        assertEquals(course.getTeacher(), EXPECTED_TEACHER);
    }

    @Test
    public void when_completedConstructor_then_completedObject() {
        Course course = new Course(EXPECTED_TITLE, EXPECTED_IMAGE, EXPECTED_TEACHER, EXPECTED_DETAILS);

        assertEquals(course.getTitle(), EXPECTED_TITLE);
        assertEquals(course.getImage(), EXPECTED_IMAGE);
        assertEquals(course.getTeacher(), EXPECTED_TEACHER);
        assertEquals(course.getTeacher(), EXPECTED_DETAILS);
    }

    @Test
    public void when_setTitle_then_changeObject() {
        Course course = new Course(EXPECTED_TITLE, EXPECTED_IMAGE, EXPECTED_TEACHER, EXPECTED_DETAILS);

        course.setTitle("novo titulo");

        assertEquals(course.getTitle(), "novo titulo");
    }

    @Test
    public void when_setImage_then_changeObject() {
        Course course = new Course(EXPECTED_TITLE, EXPECTED_IMAGE, EXPECTED_TEACHER, EXPECTED_DETAILS);

        course.setImage("nova_img.png");

        assertEquals(course.getImage(), "nova_img.png");
    }

    @Test
    public void when_setTeacher_then_changeObject() {
        Course course = new Course(EXPECTED_TITLE, EXPECTED_IMAGE, EXPECTED_TEACHER, EXPECTED_DETAILS);
        User novoTeacher = new User();

        course.setTeacher(novoTeacher);

        assertEquals(course.getTeacher(), novoTeacher);
    }

    @Test
    public void when_setCourseDetails_then_changeObject() {
        Course course = new Course(EXPECTED_TITLE, EXPECTED_IMAGE, EXPECTED_TEACHER, EXPECTED_DETAILS);
        CourseDetails novosDetalhes = new CourseDetails();

        course.setCourseDetails(novosDetalhes);

        assertEquals(course.getCourseDetails(), novosDetalhes);
    }

    @Test
    public void when_setId_then_changeObject() {
        Course course = new Course();

        course.setId(EXPECTED_ID);

        assertEquals(course.getId(), EXPECTED_ID);
    }
    
}
