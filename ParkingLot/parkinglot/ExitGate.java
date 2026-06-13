package parkinglot;

import spotManagers.ParkingSpotManager;

public class ExitGate {


        public void exitVehicle(Ticket t , ParkingSpotManager manager){
               manager.unPark(t.getSpot());
            System.out.println(
                    "Vehicle Exited : "
                            + t.getVehicle().getVehicleNumber()
            );
        }
}
