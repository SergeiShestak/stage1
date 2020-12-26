package trainManage;

import carriages.Carriage;
import carriages.ComfortLevel;


public class LuxCarriage extends Carriage {

    protected LuxCarriage(ComfortLevel comfort,int capacityPassengers, int capacityLuggage) {
        super(comfort,capacityPassengers,capacityLuggage);
    }

    @Override
    public int compareTo(Carriage carriage) {
        return 0;
    }
}
