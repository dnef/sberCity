import com.sun.jmx.remote.internal.ArrayQueue;
import entity.City;

import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class FileParser {
   private List<City> cityList = new ArrayList<>();
 public List<City> readTxtCity (Path path){
     try {
         Scanner scanner = new Scanner(path);
         scanner.useDelimiter(System.getProperty("line.separator"));
         while (scanner.hasNext()){
             String[] cityString = scanner.next().split(";");
             System.out.println(cityString[0]);
             System.out.println(cityString[5]);
             LocalDate localDate = LocalDate.of(Integer.parseInt(cityString[5]),1,1);
             cityList.add(new City(Long.parseLong(cityString[0]),cityString[1],cityString[2],cityString[3],Long.parseLong(cityString[4]),
                     localDate));
         }
         scanner.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
     return cityList;
 }
}
