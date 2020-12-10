package unitarios;

import com.fullteaching.backend.file.File;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTest {

    @Test
    public void when_emptyConstructor_then_createdObject() {
        File file = new File();

        assertEquals(file.getId(), 0);
    }


    @Test
    public void when_constructorWithTypeName_then_createdObject() {
        File file = new File(0, "file.txt");

        assertEquals(file.getType(), 0);
        assertEquals(file.getName(), "file.txt");
    }

    @Test
    public void when_constructorWithTypeNameLink_then_createdObject() {
        File file = new File(0, "file.txt", "https://google.com");

        assertEquals(file.getType(), 0);
        assertEquals(file.getName(), "file.txt");
        assertEquals(file.getLink(), "https://google.com");
    }

    @Test
    public void when_completeConstructor_then_createdObject() {
        File file = new File(0, "file.txt", "https://google.com", 1);

        assertEquals(file.getType(), 0);
        assertEquals(file.getName(), "file.txt");
        assertEquals(file.getLink(), "https://google.com");
        assertEquals(file.getIndexOrder(), 1);
    }

    @Test
    public void when_setId_then_changeObject() {
        File file = new File();

        file.setId(10);

        Assert.assertEquals(file.getId(), 10);
    }

    @Test
    public void when_setName_then_changeObject() {
        File file = new File();

        file.setName("novo_nome.txt");

        Assert.assertEquals(file.getName(), "novo_nome.txt");
    }

    @Test
    public void when_setType_then_changeObject() {
        File file = new File();

        file.setType(1);

        Assert.assertEquals(file.getType(), 1);
    }

    @Test
    public void when_setNameIdent_then_changeObject() {
        File file = new File();

        file.setNameIdent("novo_nome_identado.txt");

        Assert.assertEquals(file.getNameIdent(), "novo_nome_identado.txt");
    }

    @Test
    public void when_setLink_then_changeObject() {
        File file = new File();

        file.setLink("https://google.com.br");

        Assert.assertEquals(file.getLink(), "https://google.com.br");
    }

    @Test
    public void when_setIndexOrder_then_changeObject() {
        File file = new File();

        file.setIndexOrder(2);

        Assert.assertEquals(file.getIndexOrder(), 2);
    }

    @Test
    public void when_equalFiles_then_returnTrue() {
        File file1 = new File(0, "file.txt");
        File file2 = new File(0, "file.txt");

        assertTrue(file1.equals(file2));
    }

    @Test
    public void when_sameFile_then_returnTrue() {
        File file1 = new File(0, "file.txt");

        assertTrue(file1.equals(file1));
    }

    @Test
    public void when_differentFiles_then_returnFalse() {
        File file1 = new File(0, "file.txt");
        File file2 = new File(0, "file2.txt");
        file2.setId(1);

        assertFalse(file1.equals(file2));
    }

    @Test
    public void when_getExtensionOfTxt_then_returnTxt() {
        File file = new File(0, "file.txt");

        assertEquals(file.getFileExtension(), "txt");
    }

    @Test
    public void when_toString_then_returnFile() {
        File file = new File(0, "file.txt", "https://google.com", 1);
        String nameIdent = file.getNameIdent();
        final String EXPECTED_STRING = "File[name: \"file.txt\", id: \""+nameIdent+"\", link: \"https://google.com, indexOrder: 1]";

        assertEquals(file.toString(), EXPECTED_STRING);
    }
}
