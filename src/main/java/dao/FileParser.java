package dao;

import entity.City;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class FileParser {
    private List<City> cityList = new ArrayList<>();

    public List<City> readTxtCity(Path path) {
        try {
            Scanner scanner = new Scanner(path);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                cityList.add(new City(Long.parseLong(scanner.next().trim()), scanner.next().trim(), scanner.next().trim(),
                        scanner.next().trim(), Long.parseLong(scanner.next().trim()),
                        LocalDate.of(Integer.parseInt(scanner.next()), 1, 1)));
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e) {
            System.out.println("File read error");e.printStackTrace();
        }
        return cityList;
    }
}
