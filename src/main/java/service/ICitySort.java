package service;

import entity.City;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface ICitySort {
    List<City> allCity(Path path);
    List<City> sortByName(List<City> allCity);
    List<City> sortByDistrictAndName(List<City> allCity);
    String maxPopulation(List<City> allCity);
    Map<String,Integer> cityByForAndRegion(List<City> allCity);
}
