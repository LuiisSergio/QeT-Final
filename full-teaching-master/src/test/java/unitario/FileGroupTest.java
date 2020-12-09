package unitario;

import com.fullteaching.backend.file.File;
import com.fullteaching.backend.filegroup.FileGroup;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileGroupTest {

    @Test
    public void when_emptyConstructor_then_createdObject() {
        FileGroup fileGroup = new FileGroup();

        assertEquals(fileGroup.getId(), 0);
    }

    @Test
    public void when_ConstructorWithTitle_then_createdObject() {
        FileGroup fileGroup = new FileGroup("titulo");

        assertEquals(fileGroup.getTitle(), "titulo");
    }

    @Test
    public void when_ConstructorWithTitleParent_then_createdObject() {
        FileGroup parent = new FileGroup("parent");
        FileGroup fileGroup = new FileGroup("titulo", parent);

        assertEquals(fileGroup.getTitle(), "titulo");
        assertTrue(fileGroup.getFileGroupParent().equals(parent));
    }

    @Test
    public void when_setId_then_changeObject() {
        FileGroup fileGroup = new FileGroup();

        fileGroup.setId(10);

        assertEquals(fileGroup.getId(), 10);
    }

    @Test
    public void when_setTitle_then_changeObject() {
        FileGroup fileGroup = new FileGroup();

        fileGroup.setTitle("novoTitulo");

        assertEquals(fileGroup.getTitle(), "novoTitulo");
    }

    @Test
    public void when_setFileGroupParent_then_changeObject() {
        FileGroup parent = new FileGroup("parent");
        FileGroup fileGroup = new FileGroup();

        fileGroup.setFileGroupParent(parent);

        assertEquals(fileGroup.getFileGroupParent(), parent);
    }

    @Test
    public void when_differentFileGroups_then_returnFalse() {
        FileGroup fileGroup1 = new FileGroup();
        FileGroup fileGroup2 = new FileGroup();
        fileGroup2.setId(10);

        assertNotEquals(fileGroup2, fileGroup1);
    }

    @Test
    public void when_toString_then_returnString() {
        FileGroup fileGroup = new FileGroup("titulo");
        final String EXPECTED_STRING = "FileGroup[title: \"titulo\", parentFileGroup: \"null\", #files: 0, #childrenFileGroups: 0]";

        assertEquals(fileGroup.toString(), EXPECTED_STRING);
    }

}
