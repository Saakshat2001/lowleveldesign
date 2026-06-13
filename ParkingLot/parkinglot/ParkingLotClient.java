package parkinglot;

import Entity.ParkingSpot;
import Entity.Vehicle;
import LookUpStrategy.ParkingSpotLookUpStrategy;
import LookUpStrategy.RandomLookUpStrategy;
import enums.VehicleType;
import spotManagers.ParkingSpotManager;

import java.util.List;

public class ParkingLotClient {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("UP09GU5606", VehicleType.TWO_WHEELER);
    List<ParkingSpot> spots = List.of(
            new ParkingSpot("P1"),
            new ParkingSpot("P2"),
            new ParkingSpot("P3")
    );
    ParkingSpotLookUpStrategy psl = new RandomLookUpStrategy();

        ParkingSpotManager psm = new ParkingSpotManager(spots , psl);

        EntranceGate eg= new EntranceGate();
        ParkingLot parkingLot = new ParkingLot(psm, eg, new ExitGate());
        Ticket ticket1 = parkingLot.parkVehicle(v);
       // parkingLot.unParkVehicle(ticket1);

        Vehicle v2 = new Vehicle("UP09GA4555", VehicleType.TWO_WHEELER);
        Ticket ticket2 = parkingLot.parkVehicle(v2);
        //parkingLot.unParkVehicle(ticket2);

        Vehicle v3 = new Vehicle("UP09GA9999", VehicleType.FOUR_WHEELER);
        Ticket ticket3 = parkingLot.parkVehicle(v3);
        parkingLot.unParkVehicle(ticket3);

        Vehicle v4 = new Vehicle("UP09GA1223", VehicleType.TWO_WHEELER);
        Ticket ticket4 = parkingLot.parkVehicle(v4);
        parkingLot.unParkVehicle(ticket4);

    }

}
