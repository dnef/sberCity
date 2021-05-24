import entity.City;

import java.util.*;
import java.util.stream.Collectors;

public class CitySort {
    public List<City> AllCity(List allCity){
        return allCity;
    }
    public List<City> sortName(List<City> allCity){
        Collections.sort(allCity,
                Comparator.comparing(City::getName,String::compareToIgnoreCase)
                        .reversed());
        return allCity;
    }
    public List<City> sortNameRegion(List<City> allCity){
        Collections.sort(allCity,
                Comparator.comparing(City::getName).thenComparing(City::getRegion)
                        .reversed());
        return allCity;
    }
    public String maxPopulation(List<City> allCity){
        City[] cities = allCity.toArray(new City[0]);
        City temp = cities[0];
        int index =0;
        for (int i=1;i< cities.length;i++) {
            if (temp.getPopulation()<cities[i].getPopulation()){
                temp=cities[i];
                index = i;
            }
        }
        return new String("["+index+"] = "+temp.getPopulation());
    }
public Map<String,Integer> cityForRegion(List<City> allCity){
        Map<String,Integer> mapSummCityRegion = allCity.stream().collect(Collectors.toMap(City::getRegion,city -> 1,Integer::sum));
        return mapSummCityRegion;
}
   // Map<Integer,Integer> mapSolvedTask = sortDate(after,before).stream().filter(p->p.getEvent().equals(Event.SOLVE_TASK)).collect(Collectors.toMap(Log::getEventNumb, log -> 1,Integer::sum));
}
