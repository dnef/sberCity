package dao;
import entity.City;

import java.util.List;
import java.util.Map;

public interface IDaoSortDatabase {
    List<City> allCity();
    List<City> sortByNameDESC();
    List<City> sortByDistrictAndName();
    String maxPopulation();
    List cityByForAndRegion() ;
}
