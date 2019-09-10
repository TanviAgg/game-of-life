import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GameOfLifeFileReader {
    static ArrayList<Coordinate> readInputFromFile(String filename){
        ArrayList<Coordinate> cells = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] tokens = str.split(", ");
                cells.add(new Coordinate(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
            }
            return cells;
        }
        catch (IOException e) {
            return null;
        }
    }

    static boolean matchOutputWithFile(String filename, List<Coordinate> cells){
        ArrayList<Coordinate> expected = readInputFromFile(filename);
        if(expected.size() != cells.size()){
            return false;
        }
        for(Coordinate coOrdinate: expected){
            if(!cells.contains(coOrdinate)){
                return false;
            }
        }
        return true;
    }
}
