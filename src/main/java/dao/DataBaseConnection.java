package dao;

import entity.City;
import service.CitySort;

import java.nio.file.Paths;
import java.sql.*;
import java.util.List;

public class DataBaseConnection {
    public Statement connection() {
        Statement st = null;
        try {
            Class.forName("org.h2.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:sber", "sa", "");
            st = conn.createStatement();
            return st;
        } catch (InstantiationException | SQLException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
