package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class City implements Serializable {
    public City() {
    }

    public City(Long id, String name, String region, String district, Long population, LocalDate foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    // Порядковый номер записи справочника
    private Long id;
    // наименование города
    private String name;
    //регион
    private String region;
    //федеральный округ
    private String district;
    //количество жителей города
    private Long population;
    // дата основания или первое упоминание
    private LocalDate foundation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public LocalDate getFoundation() {
        return foundation;
    }

    public void setFoundation(LocalDate foundation) {
        this.foundation = foundation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (region != null ? !region.equals(city.region) : city.region != null) return false;
        if (district != null ? !district.equals(city.district) : city.district != null) return false;
        if (population != null ? !population.equals(city.population) : city.population != null) return false;
        return foundation != null ? foundation.equals(city.foundation) : city.foundation == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (foundation != null ? foundation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation.getYear() +'\''+
                '}';
    }
}
