package exercise2;

/**
 * Created by Fabian Gillholm on 2015-09-23.
 */
public class FerryMain {
    public static void main(String[] args) {
        Ferry ferry = new FinlandFerry();

        // Create some buses and embark them
        for(int i = 0; i < 3; i++) {
            Vehicle bus = new Bus();
            for(int j = 0; j < bus.capacity; j++) {
                bus.addPassenger(new Passenger());
            }
            ferry.embark(bus);
        }

        // Create some lorries and embark them
        for(int i = 0; i < 2; i++) {
            Vehicle lorry = new Lorry();
            for(int j = 0; j < lorry.capacity; j++) {
                lorry.addPassenger(new Passenger());
            }
            ferry.embark(lorry);
        }

        // Create some cars and embark them
        for(int i = 0; i < 8; i++) {
            Vehicle car = new Car();
            for(int j = 0; j < car.capacity; j++) {
                car.addPassenger(new Passenger());
            }
            ferry.embark(car);
        }

        // Create some bikes and embark them
        for(int i = 0; i < 20; i++) {
            Vehicle bicycle = new Bicycle();
            for(int j = 0; j < bicycle.capacity; j++) {
                bicycle.addPassenger(new Passenger());
            }
            ferry.embark(bicycle);
        }

        // What is on the ferry?
        System.out.println(ferry.toString());

        // Drop the drunk suckers into the ocean as soon as we get out on international waters
        ferry.disembark();

        // Make sure we got rid of all the evidence
        System.out.println(ferry.toString());

        // Check on the loot
        System.out.println("Money made so far: " + ferry.countMoney());

        // Do it all over again in the next port
    }
}
