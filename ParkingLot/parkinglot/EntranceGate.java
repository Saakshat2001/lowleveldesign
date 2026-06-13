package parkinglot;

import Entity.ParkingSpot;
import Entity.Vehicle;
import spotManagers.ParkingSpotManager;

public class EntranceGate {

//    private final ParkingSpotManager parkingSpotManager;

//    public EntranceGate(ParkingSpotManager parkingSpotManager){
//        this.parkingSpotManager = parkingSpotManager;
//    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot){
        if (spot == null) {
            throw new RuntimeException("No Spot Available");
        }
        Ticket ticket =  new Ticket(vehicle, spot);
        System.out.println(
                "Ticket Generated. Vehicle: "
                        + vehicle.getVehicleNumber()
                        + ", Spot: "
                        + spot.getSpotId()
        );

        return ticket;
      }
}
