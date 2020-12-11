package unitarios;

import com.fullteaching.backend.file.File;
import com.fullteaching.backend.filegroup.FileGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileGroupTest {

    FileGroup fileGroup;

    @BeforeEach
    void resetFileGroup() {
        fileGroup = new FileGroup();
    }

    @Test
    public void when_emptyConstructor_then_createdObject() {
        assertEquals(fileGroup.getId(), 0);
    }

    @Test
    public void when_ConstructorWithTitle_then_createdObject() {
        fileGroup = new FileGroup("titulo");

        assertEquals(fileGroup.getTitle(), "titulo");
    }

    @Test
    public void when_ConstructorWithTitleParent_then_createdObject() {
        FileGroup parent = new FileGroup("parent");
        fileGroup = new FileGroup("titulo", parent);

        assertEquals(fileGroup.getTitle(), "titulo");
        assertTrue(fileGroup.getFileGroupParent().equals(parent));
    }

    @Test
    public void when_setId_then_changeObject() {
        fileGroup = new FileGroup();

        fileGroup.setId(10);

        assertEquals(fileGroup.getId(), 10);
    }

    @Test
    public void when_setTitle_then_changeObject() {
        fileGroup = new FileGroup();

        fileGroup.setTitle("novoTitulo");

        assertEquals(fileGroup.getTitle(), "novoTitulo");
    }

    @Test
    public void when_setFiles_then_changeObject() {
        fileGroup = new FileGroup();
        List<File> files = new ArrayList<>();

        fileGroup.setFiles(files);

        assertEquals(fileGroup.getFiles(), files);
    }

    @Test
    public void when_setFileGroups_then_changeObject() {
        fileGroup = new FileGroup();
        List<FileGroup> fileGroups = new ArrayList<>();

        fileGroup.setFileGroups(fileGroups);

        assertEquals(fileGroup.getFileGroups(), fileGroups);
    }

    @Test
    public void when_updateFileIndexOrder_then_updateList() {
        File file0 = new File();
        file0.setIndexOrder(1);
        File file1 = new File();
        file1.setIndexOrder(1);

        List<File> files = new ArrayList<>();
        files.add(file0);
        files.add(file1);
        fileGroup.setFiles(files);

        fileGroup.updateFileIndexOrder();

        assertEquals(fileGroup.getFiles().get(0).getIndexOrder(),0);
        assertEquals(fileGroup.getFiles().get(1).getIndexOrder(),1);
    }

    @Test
    public void when_setFileGroupParent_then_changeObject() {
        FileGroup parent = new FileGroup("parent");
        fileGroup = new FileGroup();

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
    public void when_equalFileGroups_then_returnTrue() {
        FileGroup fileGroup1 = new FileGroup();
        fileGroup1.setId(0);
        FileGroup fileGroup2 = new FileGroup();
        fileGroup2.setId(0);

        assertEquals(fileGroup2, fileGroup1);
    }

    @Test
    public void when_sameFileGroup_then_returnTrue() {
        FileGroup fileGroup1 = new FileGroup();

        assertEquals(fileGroup1, fileGroup1);
    }

    @Test
    public void when_toString_then_returnString() {
        fileGroup = new FileGroup("titulo");
        final String EXPECTED_STRING = "FileGroup[title: \"titulo\", parentFileGroup: \"null\", #files: 0, #childrenFileGroups: 0]";

        assertEquals(fileGroup.toString(), EXPECTED_STRING);
    }

}