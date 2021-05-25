package controller;

import dao.GetListCity;
import entity.City;
import service.CitySort;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserMenu {
    public static void menu() {
        System.out.println("Путь к файлу :");
        Scanner scanner = new Scanner(System.in);
        String strPath = scanner.nextLine();
        Path path = Paths.get(strPath);
        List<City> cityList = new GetListCity().getListCityFile(path);
        CitySort citySort = new CitySort();
        System.out.println("Действие:");
        String str = "";
        while (true) {
            str = scanner.nextLine();
            switch (str) {
                case "1":
                    citySort.allCity(cityList).forEach(System.out::println);
                    break;
                case "2":
                    citySort.sortName(cityList).forEach(System.out::println);
                    break;
                case "3":
                    citySort.sortNameDistrict(cityList).forEach(System.out::println);
                    break;
                case "4":
                    System.out.println(citySort.maxPopulation(cityList));
                    break;
                case "5":
                    Map<String, Integer> summCity = citySort.cityForRegion(cityList);
                    summCity.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    });
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Нет в меню !");
            }
        }
    }
}
