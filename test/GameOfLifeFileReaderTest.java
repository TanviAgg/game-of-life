import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOfLifeFileReaderTest {
    @Test
    void shouldNotReturnNullForTestInputFile(){
        List<Coordinate> result = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase2.txt");

        assertNotNull(result);
    }

    @Test
    void shouldReturnTrueForTestOutputFile(){
        List<Coordinate> result = GameOfLifeFileReader.readInputFromFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase2.txt");
        
        assertTrue(GameOfLifeFileReader.matchOutputWithFile("/Users/tanvi.aggarwal/IdeaProjects/GameOfLife/test/Testcase2.txt", result));
    }
}
