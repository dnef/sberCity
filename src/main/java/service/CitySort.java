package service;

import entity.City;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class CitySort implements ICitySort{
    //список объектов City
    @Override
    public List<City> allCity(List allCity){
        return allCity;
    }
    //Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра
    @Override
    public List<City> sortName(List<City> allCity){
        Collections.sort(allCity,
                Comparator.comparing(City::getName,String::compareToIgnoreCase)
                        .reversed());
        return allCity;
    }
   //Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра
    @Override
    public List<City> sortNameDistrict(List<City> allCity){
        Collections.sort(allCity,
                Comparator.comparing(City::getDistrict).thenComparing(City::getName)
                        .reversed());
        return allCity;
    }
    //Необходимо преобразовать список городов в массив и путем перебора массива найти индекс элемента и значение с наибольшим количеством жителей города
    @Override
    public String maxPopulation(List<City> allCity){
        City[] cities = allCity.toArray(new City[0]);
        City max = cities[0];
        int index =0;
        for (int i=1;i< cities.length;i++) {
            if (max.getPopulation()<cities[i].getPopulation()){
                max=cities[i];
                index = i;
            }
        }
        return new String("["+index+"] = "+max.getPopulation());
    }
    //Необходимо определить количество городов в разрезе регионов
    @Override
    public Map<String,Integer> cityForRegion(List<City> allCity){
        Map<String,Integer> mapSummCityRegion = allCity.stream().
                collect(Collectors.toMap(City::getRegion,city -> 1,Integer::sum));
        return mapSummCityRegion;
}
}
