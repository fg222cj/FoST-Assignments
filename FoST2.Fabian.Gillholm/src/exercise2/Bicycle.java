package exercise2;

import java.util.ArrayList;

/**
 * Created by Fabian Gillholm on 2015-09-23.
 */
public class Bicycle extends Vehicle {
    public Bicycle() {
        this.spaceRequired = 1;
        this.passengerFee = 0;
        this.vehicleFee = 40;
        this.capacity = 1;
        this.passengers = new ArrayList<Passenger>();
    }
}
