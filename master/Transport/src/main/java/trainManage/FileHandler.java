package trainManage;

import carriages.Carriage;
import carriages.ComfortLevel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public ArrayList<Carriage> readFile() throws IOException {
        List<Carriage> compound = new ArrayList<>();
        String lineRead;
        String[] splitLine;
        Carriage carriage;

        try (BufferedReader reader = new BufferedReader(new FileReader("/home/sergei/savedfromgit/master/Transport/src/main/java/trainManage/compound.csv"))) {
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(" ");
                if (splitLine[0].toString().equals(ComfortLevel.LUX.toString())) {
                    carriage = new LuxCarriage(ComfortLevel.LUX, Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));
                    System.out.println(splitLine[0].toString() + " " + ComfortLevel.LUX.toString());
                }
                if (splitLine[0].toString().equals(ComfortLevel.STANDART.toString())) {
                    carriage = new StandartCarriage(ComfortLevel.STANDART, Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));

                } else {
                    carriage = new PublicCarriage(ComfortLevel.PUBLIC, Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));

                }
                compound.add(carriage);
                lineRead = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }return (ArrayList<Carriage>) compound;

    }
}
