package LookUpStrategy;

import Entity.ParkingSpot;

import java.util.List;

public class RandomLookUpStrategy implements ParkingSpotLookUpStrategy{
    @Override
    public ParkingSpot selectSpots(List<ParkingSpot> spots){
        for(ParkingSpot spot : spots){
            if(spot.isSpotFree()) return spot;
        }
        return null;
    }
}
