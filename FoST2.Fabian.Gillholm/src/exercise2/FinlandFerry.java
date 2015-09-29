package exercise2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Fabian Gillholm on 2015-09-23.
 * Used to ship large amounts of drunk people to and from our neighbor in the east.
 * At least that's the official story. We actually just dump them and their vehicles in the ocean.
 */
public class FinlandFerry implements Ferry {
    private List<Vehicle> vehicles;
    private int moneyEarned;
    private int availableVehicleSpace;
    private int availablePassengerSpace;
    private int maxVehicleSpace = 200; // a bicycle is 1 unit, a car is 5, a bus is 20 and a lorry is 40
    private int maxPassengerSpace = 200; // 1 passenger is 1 unit


    public FinlandFerry() {
        this.moneyEarned = 0;
        init();
    }

    // Initialize/reset the ferry
    private void init() {
        this.availableVehicleSpace = this.maxVehicleSpace;
        this.availablePassengerSpace = this.maxPassengerSpace;
        this.vehicles = new ArrayList<Vehicle>();
    }

    // Check how much room is occupied by drunk assholes
    public int countPassengers() {
        return this.maxPassengerSpace - this.availablePassengerSpace;
    }

    // Check how much space is occupied by vehicles
    public int countVehicleSpace() {
        int count = 0;
        for(Vehicle vehicle : vehicles) {
            count += vehicle.getSpaceRequired();
        }
        return count / 5; // Divided by 5 since we want to know the number of car spaces that have been taken
    }

    // Returns the accumulated earnings
    public int countMoney() {
        return this.moneyEarned;
    }

    // No idea why we need this, but I hope you like it
    public Iterator iterator() {
        return new VehicleIterator();
    }

    // Embark a vehicle and possibly its passengers
    public void embark(Vehicle v) {
        if(!v.hasEmbarked() && hasSpaceFor(v)) {
            this.vehicles.add(v);
            this.moneyEarned += v.getFee();
            this.availableVehicleSpace -= v.getSpaceRequired();
            v.embark();
            for(Passenger p : v.passengers) {
                embark(p);
            }
        }
        else {
            System.out.println(v.toString() + " doesn't fit. Skipping.");
        }
    }

    // Load a passenger on the ship. If the passenger doesn't fit, steal their vehicle and leave them at port.
    public void embark(Passenger p) {
        if(!p.embarked() && hasRoomFor(p)) {
            this.moneyEarned += p.getFee();
            p.embark();
            this.availablePassengerSpace -= 1;
        }
        else {
            System.out.println(p.toString() + " doesn't fit. Skipping. Their vehicle is still embarked though. This is" +
                    " completely in accordance with the requirements for this assignment.");
        }
    }

    // Empty the ferry and disembark all passengers. Vehicles are disembarked but all wear the black mark of those who
    // have been foolish enough to journey on the Finland Ferry. Cursed are they, and may never return to whence they
    // came. At least not on this ship.
    public void disembark() {
        for(Vehicle vehicle : this.vehicles) {
            for(Passenger p : vehicle.passengers) {
                if(p.embarked()) {
                    p.disembark();
                }
            }
            // Here is where I would change the hasEmbarked of the vehicle to false, but since the requirements
            // stipulate that the same vehicle can't embark twice, then I will have to assume that the ferry will just
            // never ship that vehicle again. Weird, but it's what you asked for. Even if I suppose it is because the
            // program might be used with some sort of queue that will load up the ferry several times until the queue
            // is empty, it is still weird.
        }
        init();
    }

    // Return true if there's room for the vehicle
    public boolean hasSpaceFor(Vehicle v) {
        return v.getSpaceRequired() <= this.availableVehicleSpace;
    }

    // Returns true if there's room for this drunk asshole
    public boolean hasRoomFor(Passenger p) {
        return 1 <= this.availablePassengerSpace;
    }

    public String toString() {
        // Count all the different types of vehicles, passengers and empty spaces
        int bicycles = 0;
        int cars = 0;
        int buses = 0;
        int lorries = 0;
        int passengers = countPassengers();
        int vehicleSpace = (maxVehicleSpace / 5) - countVehicleSpace();
        for(Vehicle vehicle : this.vehicles) {
            if(vehicle.getClass() == Bicycle.class) {
                bicycles++;
            }
            else if(vehicle.getClass() == Car.class) {
                cars++;
            }
            else if(vehicle.getClass() == Bus.class) {
                buses++;
            }
            else if(vehicle.getClass() == Lorry.class) {
                lorries++;
            }
        }

        // Turn it into a beautiful text
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The ferry currently holds:\n");
        stringBuilder.append(bicycles + " bicycles\n");
        stringBuilder.append(cars + " cars\n");
        stringBuilder.append(buses + " buses\n");
        stringBuilder.append(lorries + " lorries\n");
        stringBuilder.append(passengers + " drunk sods\n");
        stringBuilder.append(vehicleSpace + " empty spaces left for additional vehicles");

        return stringBuilder.toString();
    }

    class VehicleIterator implements Iterator<Vehicle> {
        private int count = 0;
        public Vehicle next() {return vehicles.get(count++);}

        public boolean hasNext() {return count < vehicles.size();}
    }
}
