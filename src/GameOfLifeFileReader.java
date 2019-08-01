import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GameOfLifeFileReader {
    static ArrayList<CoOrdinate> readInputFromFile(String filename){
        ArrayList<CoOrdinate> cells = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] tokens = str.split(", ");
                cells.add(new CoOrdinate(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
            }
            return cells;
        }
        catch (IOException e) {
            return null;
        }
    }

    static boolean matchOutputWithFile(String filename, List<CoOrdinate> cells){
        ArrayList<CoOrdinate> expected = readInputFromFile(filename);
        if(expected.size() != cells.size()){
            return false;
        }
        for(CoOrdinate coOrdinate: expected){
            if(!cells.contains(coOrdinate)){
                return false;
            }
        }
        return true;
    }
}
