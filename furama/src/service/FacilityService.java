package service;

import model.Facility;

public interface FacilityService {
    void display();
    Facility getFacilityByName();
    void displayFacilityMaintenance();
    void repairFacility();
    void repairAllFacility();
}
