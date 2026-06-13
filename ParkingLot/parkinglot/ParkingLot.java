package parkinglot;

import Entity.ParkingSpot;
import Entity.Vehicle;
import spotManagers.ParkingSpotManager;

public class ParkingLot {

    private final EntranceGate entranceGate;
    private final ExitGate exitGate;

    private final ParkingSpotManager manager;
    public ParkingLot(ParkingSpotManager manager,
                      EntranceGate entranceGate,
                      ExitGate exitGate) {

        this.manager = manager;
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;
    }

    public Ticket parkVehicle(Vehicle v){
        ParkingSpot spot = manager.park();
        return entranceGate.generateTicket(
                v,
                spot
        );
    }

    public void unParkVehicle(Ticket t){
            exitGate.exitVehicle(t, manager);
    }

}
