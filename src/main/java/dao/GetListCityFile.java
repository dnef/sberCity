package dao;

import entity.City;

import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetListCityFile implements getDataFile {
    @Override
    public List<City> getListCityFile(Path path) {
        FileParser parser = new FileParser();
        List<City> cityList = parser.readTxtCity(path);
        return cityList;
    }

    @Override
    public void addListSityDatabase(Path path) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Statement statement = dataBaseConnection.connection();
        try {
            //statement.execute("DROP TABLE CITY");
            statement.execute("CREATE TABLE IF NOT EXISTS CITY(ID INT, NAME VARCHAR ,REGION VARCHAR," +
                    "DISTRICT VARCHAR ,POPULATION INT,FOUNDATION INT)");
            List<City> cityList = getListCityFile(path);
            for (City city : cityList) {
                statement.execute("INSERT INTO CITY VALUES(" + city.getId() + ",'" + city.getName() + "','" + city.getRegion() + "','"
                        + city.getDistrict() + "'," + city.getPopulation() + "," + city.getFoundation().getYear() + ")");
            }

            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
