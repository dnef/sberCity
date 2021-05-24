import entity.City;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("c://temp/city.txt");
        FileParser parser = new FileParser();
        List<City> cityList = parser.readTxtCity(path);
        cityList.forEach(System.out::println);


        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (true){
            str = scanner.nextLine();
            switch (str){
                case "1": new CitySort().AllCity(cityList);
                    cityList.forEach(System.out::println);break;
                case "2": new CitySort().sortName(cityList);
                    cityList.forEach(System.out::println);break;
                case "3": new CitySort().sortNameRegion(cityList);
                    cityList.forEach(System.out::println);break;
                case "4":
                    System.out.println(new CitySort().maxPopulation(cityList));
                    break;
                case "5":
                    Map<String,Integer> summCity = new CitySort().cityForRegion(cityList);
                    summCity.entrySet().forEach(entry->{
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    });
                break;
                case "exit":System.exit(0); break;
            }
        }
    }
}
