package spotManagers;

import Entity.ParkingSpot;
import LookUpStrategy.ParkingSpotLookUpStrategy;
import java.util.concurrent.locks.ReentrantLock;
import java.util.List;

public class ParkingSpotManager {

      protected final List<ParkingSpot> spots;
      ParkingSpotLookUpStrategy strategy;
    private final ReentrantLock lock = new ReentrantLock(true);

    public ParkingSpotManager(List<ParkingSpot> spots,
                                 ParkingSpotLookUpStrategy strategy) {
        this.spots = spots;
        this.strategy = strategy;
    }

    public ParkingSpot park(){
         lock.lock();
         try{
             ParkingSpot spot = strategy.selectSpots(spots);
             if(spot == null ) {
                 System.out.println("[PARKING_MANAGER] No free spot available.");
                 return null;
             }
             spot.occupySpot();
             System.out.println(
                     "[PARKING_MANAGER] Spot allocated: "
                             + spot.getSpotId()
             );
             return spot;

         }finally {
            lock.unlock();
         }
    }

    public void unPark(ParkingSpot spot){
            spot.releaseSpot();
        System.out.println(
                "[PARKING_MANAGER] Spot released: "
                        + spot.getSpotId()
        );
    }
    public boolean hasFreeSpot() {
        lock.lock();
        try {
            return spots.stream().anyMatch(ParkingSpot::isSpotFree);
        } finally {
            lock.unlock();
        }
    }
}
