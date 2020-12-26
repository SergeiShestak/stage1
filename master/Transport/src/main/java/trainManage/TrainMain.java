package trainManage;

import carriages.Carriage;
import carriages.ComfortLevel;
import trainManage.TrainManage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainMain {
     static List<Carriage> compound = Arrays.asList(
             new LuxCarriage(ComfortLevel.LUX,75,800),
             new LuxCarriage(ComfortLevel.LUX,50,750),
             new StandartCarriage(ComfortLevel.STANDART,100,500),
             new PublicCarriage(ComfortLevel.PUBLIC,120,600),
             new PublicCarriage(ComfortLevel.PUBLIC,150,900),
             new PublicCarriage(ComfortLevel.PUBLIC,120,600),
             new StandartCarriage(ComfortLevel.STANDART,100,500),
             new StandartCarriage(ComfortLevel.STANDART,100,500),
             new LuxCarriage(ComfortLevel.LUX,75,800),
             new StandartCarriage(ComfortLevel.STANDART,100,500),
             new StandartCarriage(ComfortLevel.STANDART,100,500),
             new StandartCarriage(ComfortLevel.STANDART,100,500)
     );
    public static void main (String[] args) {
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