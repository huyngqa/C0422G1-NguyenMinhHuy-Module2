package service.impl;

import model.Car;
import model.Transport;
import model.Trunks;
import service.IServiceRemoveAndSearch;

public class RemoveAndSearch implements IServiceRemoveAndSearch {
    @Override
    public String removeBySeaOfControl(String seaOfControl) {
        Transport transport = checkSeaOfControl(seaOfControl);
        if (transport instanceof Car) {
            CarService.carList.remove(transport);
        } else if (transport instanceof Trunks) {
            TrunksService.trunksList.remove(transport);
        } else {
            BikeService.bikeList.remove(transport);
        }
        return "Bạn đã xoá: " + transport;
    }

    @Override
    public void searchBySeaOfControl(String seaOfControl) {
        seaOfControl.toLowerCase();
        int count = 0;
        for (int i = 0; i < TrunksService.trunksList.size(); i++) {
            String tmp = TrunksService.trunksList.get(i).getSeaOfControl().toLowerCase();
            if (tmp.contains(seaOfControl)) {
                System.out.println(TrunksService.trunksList.get(i));
                count++;
            }
        }
        for (int i = 0; i < CarService.carList.size(); i++) {
            String tmp = CarService.carList.get(i).getSeaOfControl().toLowerCase();
            if (tmp.contains(seaOfControl)) {
                System.out.println(CarService.carList.get(i));
                count++;
            }
        }
        for (int i = 0; i < BikeService.bikeList.size(); i++) {
            String tmp = BikeService.bikeList.get(i).getSeaOfControl().toLowerCase();
            if (tmp.contains(seaOfControl)) {
                System.out.println(BikeService.bikeList.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có phương tiện nào được tìm thấy!");
        }
    }

    public Transport checkSeaOfControl(String seaOfControl) {
        for (int i = 0; i < TrunksService.trunksList.size(); i++) {
            if (TrunksService.trunksList.get(i).getSeaOfControl().equalsIgnoreCase(seaOfControl)) {
                return TrunksService.trunksList.get(i);
            }
        }
        for (int i = 0; i < CarService.carList.size(); i++) {
            if (CarService.carList.get(i).getSeaOfControl().equalsIgnoreCase(seaOfControl)) {
                return CarService.carList.get(i);
            }
        }
        for (int i = 0; i < BikeService.bikeList.size(); i++) {
            if (BikeService.bikeList.get(i).getSeaOfControl().equalsIgnoreCase(seaOfControl)) {
                return BikeService.bikeList.get(i);
            }
        }
        return null;
    }
}
