package carriages;

public abstract class Carriage implements Comparable<Carriage> {
     private int capacityPassengers;
     private int capacityLuggage;
     private ComfortLevel comfort;

    public Carriage(ComfortLevel comfort, int capacityPassengers, int capacityLuggage) {
        this.comfort = comfort;
        this.capacityPassengers = capacityPassengers;
        this.capacityLuggage = capacityLuggage;

    }

    public int getCapacityLuggage(){
        return capacityLuggage;
    }

    public ComfortLevel getComfort(){
        return comfort;
    }


    public int getCapacityPassenger(){
        return capacityPassengers;
    }

    @Override
    public int compareTo(Carriage carriage){
        return comfort.compareTo(carriage.getComfort());
    }

    @Override
    public  String toString(){
        return "Carriage {" + "comfort: " + comfort + ";  passengers: " + capacityPassengers + ";  luggage: "+ capacityLuggage+ ";}" +'\n';
    }

}
