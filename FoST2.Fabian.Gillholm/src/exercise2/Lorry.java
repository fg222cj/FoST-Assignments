package exercise2;

import java.util.ArrayList;

/**
 * Created by Fabian Gillholm on 2015-09-23.
 */
public class Lorry extends Vehicle {
    public Lorry() {
        this.spaceRequired = 40;
        this.passengerFee = 15;
        this.vehicleFee = 300;
        this.capacity = 2;
        this.passengers = new ArrayList<Passenger>();
    }
}
