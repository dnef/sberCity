package dao;

import entity.City;
import service.CitySort;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoSortDatabaseImpl implements IDaoSortDatabase {

    @Override
    public List<City> allCity() {
        Statement statement = new DataBaseConnection().connection();
        try{
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM CITY");
            List<City> cityList = new ArrayList<>();
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getLong("ID"));
                city.setName(resultSet.getString("NAME"));
                city.setRegion(resultSet.getString("REGION"));
                city.setDistrict(resultSet.getString("DISTRICT"));
                city.setDistrict(resultSet.getString("POPULATION"));
                LocalDate date = LocalDate.of(resultSet.getInt("FOUNDATION"), 1, 1);
                city.setFoundation(date);
                cityList.add(city);
            }
            return cityList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<City> sortByNameDESC() {
        Statement statement = new DataBaseConnection().connection();
        try{
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM CITY ORDER BY NAME DESC");
            List<City> cityList = new ArrayList<>();
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getLong("ID"));
                city.setName(resultSet.getString("NAME"));
                city.setRegion(resultSet.getString("REGION"));
                city.setDistrict(resultSet.getString("DISTRICT"));
                city.setDistrict(resultSet.getString("POPULATION"));
                LocalDate date = LocalDate.of(resultSet.getInt("FOUNDATION"), 1, 1);
                city.setFoundation(date);
                cityList.add(city);
            }
            return cityList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<City> sortByDistrictAndName() {
        Statement statement = new DataBaseConnection().connection();
        try{
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM CITY ORDER BY DISTRICT, NAME DESC");
            List<City> cityList = new ArrayList<>();
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getLong("ID"));
                city.setName(resultSet.getString("NAME"));
                city.setRegion(resultSet.getString("REGION"));
                city.setDistrict(resultSet.getString("DISTRICT"));
                city.setDistrict(resultSet.getString("POPULATION"));
                LocalDate date = LocalDate.of(resultSet.getInt("FOUNDATION"), 1, 1);
                city.setFoundation(date);
                cityList.add(city);
            }
            return cityList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public String maxPopulation() {
        Statement statement = new DataBaseConnection().connection();
        try{
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT MAX(POPULATION) FROM CITY ORDER BY DISTRICT, NAME DESC");
            int id = resultSet.getInt("ID");
            int max = resultSet.getInt("POPULATION");
            return id +" = "+ max;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List cityByForAndRegion() {
        List<City> list = (List<City>) new CitySort().cityByForAndRegion(allCity());
        return null;
    }
}
