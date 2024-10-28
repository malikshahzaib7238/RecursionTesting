import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class StringPermutationsTest {

    @Test
    public void testPermutationsForNonEmptyString() {
        String input = "abc";
        List<String> result = StringPermutations.generatePermutations(input);
        assertEquals(6, result.size());
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    public void testPermutationsForEmptyString() {
        String input = "";
        List<String> result = StringPermutations.generatePermutations(input);
        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }

    @Test
    public void testPermutationsForSingleCharacter() {
        String input = "a";
        List<String> result = StringPermutations.generatePermutations(input);
        assertEquals(1, result.size());
        assertEquals("a", result.get(0));
    }
}
