package exercise2;

import java.util.ArrayList;

/**
 * Created by Fabian Gillholm on 2015-09-23.
 */
public class Bus extends Vehicle {
    public Bus() {
        this.spaceRequired = 20;
        this.passengerFee = 10;
        this.vehicleFee = 200;
        this.capacity = 20;
        this.passengers = new ArrayList<Passenger>();
    }
}
