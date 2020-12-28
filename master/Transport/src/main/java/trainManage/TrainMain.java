package trainManage;

import carriages.Carriage;

import java.io.IOException;
import java.util.ArrayList;

public class TrainMain {
    
    public static void main (String[] args) throws IOException {

        FileHandler handler = new FileHandler();
        ArrayList<Carriage> compound = handler.readFile();
        TrainManage manage = new TrainManage(compound);
        manage.getCountCompoundPassengers();
        System.out.println(manage.toString());
        int quantity = manage.getCountCompoundPassengers();
        System.out.println("Quantity of passengers: "+ quantity);
        int luggage = manage.getWeightOfLuggage();
        System.out.println("Weight of luggage: "+ luggage);
        System.out.println(manage.sortCompoundByComfort().toString());

    }
}