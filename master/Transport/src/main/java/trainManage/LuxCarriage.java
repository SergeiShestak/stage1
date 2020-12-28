package trainManage;

import carriages.Carriage;
import carriages.ComfortLevel;


public class LuxCarriage extends Carriage {

    protected LuxCarriage(ComfortLevel comfort,int capacityPassengers, int capacityLuggage) {
        super(ComfortLevel.LUX, capacityPassengers, capacityLuggage);

    }
}
