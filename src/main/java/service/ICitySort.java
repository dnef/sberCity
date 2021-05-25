package service;

import entity.City;

import java.util.List;
import java.util.Map;

public interface ICitySort {
    List<City> allCity(List allCity);
    List<City> sortName(List<City> allCity);
    List<City> sortNameDistrict(List<City> allCity);
    String maxPopulation(List<City> allCity);
    Map<String,Integer> cityForRegion(List<City> allCity);
}
