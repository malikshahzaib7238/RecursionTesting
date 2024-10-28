import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

public class RecursiveFileSearchTest {

    private final String testDirPath = "testDir"; 
    @Test
    public void testFileFound() throws IOException {
        createTestFiles();
        assertTrue(RecursiveFileSearch.searchFile(new File(testDirPath), "file1.txt"));
    }

    @Test
    public void testFileNotFound() throws IOException {
        createTestFiles();
        assertFalse(RecursiveFileSearch.searchFile(new File(testDirPath), "nonexistent.txt"));
    }

    @Test
    public void testInvalidDirectory() {
        assertThrows(IllegalArgumentException.class, () -> {
            RecursiveFileSearch.searchFile(new File("invalidDir"), "file1.txt");
        });
    }

    private void createTestFiles() throws IOException {
        new File(testDirPath).mkdir();
        File file1 = new File(testDirPath + "/file1.txt");
        file1.createNewFile();
        File subDir = new File(testDirPath + "/subDir");
        subDir.mkdir();
        File file2 = new File(subDir, "file2.txt");
        file2.createNewFile();
    }

    private void cleanUp() throws IOException {
        deleteDirectory(new File(testDirPath));
    }

    private void deleteDirectory(File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    deleteDirectory(f);
                }
            }
        }
        file.delete();
    }
}
