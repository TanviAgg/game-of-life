import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GameOfLifeFileReader {
    static ArrayList<Pair<Integer, Integer>> readInputFromFile(String filename){
        ArrayList<Pair<Integer, Integer>> cells = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] tokens = str.split(", ");
                cells.add(new Pair<>(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
            }
            return cells;
        }
        catch (IOException e) {
            return null;
        }
    }

    static boolean matchOutputWithFile(String filename, List<Pair<Integer, Integer>> cells){
        ArrayList<Pair<Integer, Integer>> expected = readInputFromFile(filename);
        if(expected.size() != cells.size()){
            return false;
        }
        for(Pair<Integer, Integer> pair: expected){
            if(!cells.contains(pair)){
                return false;
            }
        }
        return true;
    }
}
