import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileReaderTest {
    @Test
    void shouldNotReturnNullForTestInputFile(){
        List<Pair<Integer, Integer>> result = FileReader.readInputFromFile("/Testcase1.txt");

        assertNotNull(result);
    }

    @Test
    void shouldReturnTrueForTestOutputFile(){
        List<Pair<Integer, Integer>> result = null;
        
        assertTrue(FileReader.matchOutputWithFile("/Solution.txt", result));
    }
}
