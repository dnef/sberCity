package dao;

import entity.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoDatabaseImpl implements IDaoDatabase {

    @Override
    public List<City> allCity() {
        try (Statement statement = new DataBaseConnection().connection()) {
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
            resultSet.close();
            return cityList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public List<City> sortByNameDESC() {
        try (Statement statement = new DataBaseConnection().connection()) {
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
            resultSet.close();
            return cityList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<City> sortByDistrictAndName() {
        try (Statement statement = new DataBaseConnection().connection()) {
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM CITY ORDER BY NAME , DISTRICT DESC");
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
            resultSet.close();
            return cityList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public String maxPopulation() {
        try (Statement statement = new DataBaseConnection().connection()) {
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT ID,POPULATION FROM CITY WHERE POPULATION = (SELECT MAX(POPULATION) FROM CITY)");
            resultSet.next();
            //System.out.println(resultSet.getString("ID")+"-"+resultSet.getString("POPULATION"));
            resultSet.close();
            return resultSet.getString("ID") + "-" + resultSet.getString("POPULATION");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Integer> cityByForAndRegion() {
        Map<String, Integer> mapCountName = new HashMap<>();
        try (Statement statement = new DataBaseConnection().connection()) {
            ResultSet resultSet;
            resultSet = statement.executeQuery("select REGION , COUNT(*) AS COUNT from CITY GROUP BY NAME");
            while (resultSet.next()) {
                mapCountName.put(resultSet.getString("REGION"), resultSet.getInt("COUNT"));
            }
            resultSet.close();
            return mapCountName;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // List<City> list = (List<City>) new CitySort().cityByForAndRegion(allCity());
}
