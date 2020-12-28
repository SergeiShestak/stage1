package trainManage;

import carriages.Carriage;
import carriages.ComfortLevel;
import com.sun.istack.internal.localization.NullLocalizable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class FileHandler {
    public FileHandler(List<Carriage> compound) {
        return;
    }

    public List<Carriage> readFile() {
        List<Carriage> compound = Arrays.asList();
        String lineRead;
        String[] splitLine;
        Carriage carriage;

        try (BufferedReader reader = new BufferedReader(new FileReader("compound.csv"))) {
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(" ");
                if (splitLine[0].equals(ComfortLevel.LUX.toString())) {
                    carriage = new LuxCarriage(ComfortLevel.LUX, Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));
                }
                if (splitLine[0].equals(ComfortLevel.STANDART.toString())) {
                    carriage = new StandartCarriage(ComfortLevel.STANDART, Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));
                } else {
                    carriage = new PublicCarriage(ComfortLevel.PUBLIC, Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));
                }
            compound.add(carriage);
            lineRead = reader.readLine();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compound;
    }
}
