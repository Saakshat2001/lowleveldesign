package LookUpStrategy;

import Entity.ParkingSpot;

import java.util.List;

public interface ParkingSpotLookUpStrategy {

    ParkingSpot selectSpots(List<ParkingSpot> spots);

}
