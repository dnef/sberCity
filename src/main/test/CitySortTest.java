import entity.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.CitySort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CitySortTest {
    List<City> cityActual;
    List<City> cityExpected;
    CitySort citySort = new CitySort();
    @Before
    public void setUp() throws Exception {
        City city1 = new City(1L,"А","А","Ю",12248L, LocalDate.of(1973,1,1));
        City city2 = new City(2L,"М","А","Ю",144246L, LocalDate.of(1857,1,1));
        City city3 = new City(3L,"Г","Б","С",56928L, LocalDate.of(1830,1,1));
        City city4 = new City(4L,"Ю","Х","С",17111L, LocalDate.of(1867,1,1));
        cityActual = Arrays.asList(city1,city2,city3,city4);
    }

    @Test
    public void allCity() {
        cityExpected = citySort.allCity(cityActual);
        Assert.assertEquals(cityExpected,cityActual);
    }

    @Test
    public void sortName() {
        City city1 = new City(1L,"А","А","Ю",12248L, LocalDate.of(1973,1,1));
        City city2 = new City(2L,"М","А","Ю",144246L, LocalDate.of(1857,1,1));
        City city3 = new City(3L,"Г","Б","С",56928L, LocalDate.of(1830,1,1));
        City city4 = new City(4L,"Ю","Х","С",17111L, LocalDate.of(1867,1,1));
        cityExpected = Arrays.asList(city4,city2,city3,city1);
        Assert.assertEquals(cityExpected,citySort.sortName(cityActual));

    }

    @Test
    public void sortNameRegion() {
        City city1 = new City(1L,"А","А","Ю",12248L, LocalDate.of(1973,1,1));
        City city2 = new City(2L,"М","А","Ю",144246L, LocalDate.of(1857,1,1));
        City city3 = new City(3L,"Г","Б","С",56928L, LocalDate.of(1830,1,1));
        City city4 = new City(4L,"Ю","Х","С",17111L, LocalDate.of(1867,1,1));
        cityExpected = Arrays.asList(city2,city1,city4,city3);
        Assert.assertEquals(cityExpected,citySort.sortNameDistrict(cityActual));
    }

    @Test
    public void maxPopulation() {
        String str = citySort.maxPopulation(cityActual);
        Assert.assertEquals("[2] = 144246");
    }

    @Test
    public void cityForRegion() {
    }
}