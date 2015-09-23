package exercise2;

import java.util.ArrayList;

/**
 * Created by Fabian Gillholm on 2015-09-23.
 */
public class Car extends Vehicle {
    public Car() {
        this.spaceRequired = 5;
        this.passengerFee = 15;
        this.vehicleFee = 100;
        this.capacity = 4;
        this.passengers = new ArrayList<Passenger>();
    }
}
