package service;

import dao.GetListCity;
import entity.City;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class CitySort implements ICitySort {
    @Override
    public List<City> allCity(Path path) {
        return new GetListCity().getListCityFile(path);
    }

    @Override
    public List<City> sortByName(List<City> allCity) {
        Collections.sort(allCity,
                Comparator.comparing(City::getName, String::compareToIgnoreCase)
                        .reversed());
        return allCity;
    }

    @Override
    public List<City> sortByDistrictAndName(List<City> allCity) {
        Collections.sort(allCity,
                Comparator.comparing(City::getDistrict).thenComparing(City::getName)
                        .reversed());
        return allCity;
    }

    @Override
    public String maxPopulation(List<City> allCity) {
        City[] cities = allCity.toArray(new City[0]);
        City max = cities[0];
        int index = 0;
        for (int i = 1; i < cities.length; i++) {
            if (max.getPopulation() < cities[i].getPopulation()) {
                max = cities[i];
                index = i;
            }
        }
        return "[" + index + "] = " + max.getPopulation();
    }

    @Override
    public Map<String, Integer> cityByForAndRegion(List<City> allCity) {
        Map<String, Integer> mapSummCityRegion = allCity.stream().
                collect(Collectors.toMap(City::getRegion, city -> 1, Integer::sum));
        return mapSummCityRegion;
    }
}
