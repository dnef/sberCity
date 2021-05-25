package dao;

import entity.City;

import java.nio.file.Path;
import java.util.List;

public interface getData {
    List<City> getListCityFile(Path path);
}
