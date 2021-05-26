package controller;

import dao.DaoDatabaseImpl;
import dao.GetListCityFile;
import entity.City;
import service.CitySort;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserMenu {
    public static void menu() {
        System.out.println("Путь к файлу :");
        Scanner scanner = new Scanner(System.in);
        //String strPath = scanner.nextLine();
        String strPath = "c:/temp/city.txt";
        Path path = Paths.get(strPath);
        List<City> cityList = new GetListCityFile().getListCityFile(path);
        List<City> cityListDatabase = new ArrayList<>();
        CitySort citySort = new CitySort();
        DaoDatabaseImpl daoSortDatabase = new DaoDatabaseImpl();
        System.out.println("1-список объектов City " +
                "\n2-Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра" +
                "\n3-Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра" +
                "\n4-Необходимо преобразовать список городов в массив и путем перебора массива найти индекс элемента и значение с наибольшим количеством жителей города" +
                "\n5-Необходимо определить количество городов в разрезе регионов" +
                "\n6-Загрузить из файла в базу данных" +
                "\n7-DB Список объектов City" +
                "\n8-DB Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра" +
                "\n9-DB Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра" +
                "\n10-DB Необходимо преобразовать список городов в массив и путем перебора массива найти индекс элемента и значение с наибольшим количеством жителей города" +
                "\n11-DB Необходимо определить количество городов в разрезе регионов" +
                "\nexit - выход");
        System.out.println("Действие:");
        String str = "";
        while (true) {
            str = scanner.nextLine();
            switch (str) {
                case "1":
                    citySort.allCity(path).forEach(System.out::println);
                    break;
                case "2":
                    citySort.sortByName(cityList).forEach(System.out::println);
                    break;
                case "3":
                    citySort.sortByDistrictAndName(cityList).forEach(System.out::println);
                    break;
                case "4":
                    System.out.println(citySort.maxPopulation(cityList));
                    break;
                case "5":
                    Map<String, Integer> summCity = citySort.cityByForAndRegion(cityList);
                    summCity.entrySet().forEach(entry ->
                            System.out.println(entry.getKey() + " " + entry.getValue()));
                    break;
                case "6":
                    new GetListCityFile().addListSityDatabase(path);
                    break;
                case "7":
                    daoSortDatabase.allCity().forEach(System.out::println);
                    break;
                case "8":
                    daoSortDatabase.sortByNameDESC().forEach(System.out::println);
                    break;
                case "9":
                    daoSortDatabase.sortByDistrictAndName().forEach(System.out::println);
                    break;
                case "10":
                    System.out.println(daoSortDatabase.maxPopulation());
                    break;
                case "11":
                    Map<String, Integer> summCityDb = daoSortDatabase.cityByForAndRegion();
                    summCityDb.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
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
