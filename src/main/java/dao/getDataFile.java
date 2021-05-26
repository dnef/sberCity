package dao;

import entity.City;

import java.nio.file.Path;
import java.util.List;

public interface getDataFile {
    List<City> getListCityFile(Path path);

    void addListSityDatabase(Path path);
}
