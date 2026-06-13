import Entity.ParkingSpot;
import Entity.Vehicle;

import java.time.LocalDateTime;

public class Ticket {

       Vehicle vehicle;
       LocalDateTime entryTime;
       ParkingSpot spot;
        public Ticket(Vehicle vehicle,
                  ParkingSpot spot) {
        this.vehicle = vehicle;
//        this.level = level;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
