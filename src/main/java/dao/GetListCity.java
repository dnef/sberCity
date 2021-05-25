package dao;

import entity.City;

import java.nio.file.Path;
import java.util.List;

public class GetListCity implements getData{
    @Override
    public List<City> getListCityFile(Path path){
        FileParser parser = new FileParser();
        List<City> cityList = parser.readTxtCity(path);
        return cityList;
    }
}
