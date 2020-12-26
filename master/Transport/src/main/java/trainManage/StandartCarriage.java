package trainManage;

import carriages.Carriage;
import carriages.ComfortLevel;



public class StandartCarriage extends Carriage {

    public StandartCarriage(ComfortLevel comfort,int capacityPassengers,int capasityLuggage){
        super(comfort,capacityPassengers,capasityLuggage);
    }

    @Override
    public int compareTo(Carriage carriage) {
        return 0;
    }
}

