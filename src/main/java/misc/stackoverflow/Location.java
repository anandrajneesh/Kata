package misc.stackoverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Anand_Rajneesh on 11/2/2016.
 */
public class Location {
    public Location parentLocation;
    public String name;
    public int id;

    public Location(Location parentLocation, String name, int id) {
        this.parentLocation = parentLocation;
        this.name = name;
        this.id = id;
    }

    public Location(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString(){
        return parentLocation ==null ? name:parentLocation.name+name;
    }

    public static void main(String[] args) {
        List<Location> listOfCities = new ArrayList<>();
        Location usa = new Location("USA",0);
        Location mexico = new Location("Mexico",1);
        for(int i =2;i<14;i++){
            Location tmp = new Location(usa,"Chicago",i);
            listOfCities.add(tmp);
        }
        for(int i = 14;i<19;i++){
            Location tmp = new Location(usa,"Oregon",i);
            listOfCities.add(tmp);
        }
        Location tmp = new Location(usa,"New York",19);
        listOfCities.add(tmp);
        tmp = new Location(usa,"Atlanta",20);
        listOfCities.add(tmp);
        tmp = new Location(usa,"Atlanta",21);
        listOfCities.add(tmp);
        tmp = new Location(mexico,"Puebla",21);
        listOfCities.add(tmp);

        Map<String, Map<String,Integer>> countMap = new HashMap<>();

        System.out.println(listOfCities.stream()
                .collect(Collectors.groupingBy(x->x.parentLocation,Collectors.groupingBy(x->x.name,Collectors.counting())))
        );



    }
}


