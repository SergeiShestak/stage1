package trainManage;

import carriages.Carriage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TrainManage {

    private int numberOfPassengers =0;
    private int weightOfLuggage=0;
    private ArrayList<Carriage> compound;

    public TrainManage(ArrayList<Carriage> compound) {

        this.compound = compound;
    }

    public int getCountCompoundPassengers(){
        for (Carriage carriage : compound) {
            numberOfPassengers += carriage.getCapacityPassenger();
        }
        return numberOfPassengers;
    }

    public int getWeightOfLuggage(){
        for (Carriage carriage : compound) {
            weightOfLuggage += carriage.getCapacityLuggage();
        }
        return weightOfLuggage;
    }

    public TrainManage sortCompoundByComfort(){
        Collections.sort(compound, new Comparator<Carriage>() {
            @Override
            public int compare(Carriage o1, Carriage o2) {
                return (o1.getComfort().compareTo(o2.getComfort()));
            }
        });return this;
    }

    @Override
    public String toString(){
        return "{" + compound.toString() +'}';
    }

    //public TrainManage(List<? extends Carriage> compound){this.compound=compound;}
}