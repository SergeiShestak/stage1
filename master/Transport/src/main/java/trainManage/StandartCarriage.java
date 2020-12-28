package trainManage;

import carriages.Carriage;
import carriages.ComfortLevel;



public class StandartCarriage extends Carriage {

    public StandartCarriage(ComfortLevel comfort,int capacityPassengers,int capasityLuggage){
        super(ComfortLevel.STANDART,capacityPassengers,capasityLuggage);
    }
}

