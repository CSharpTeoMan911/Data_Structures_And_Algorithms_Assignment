package assignment2_1;

import java.util.ArrayList;
import java.util.List;

public class Airline {

    private List<Flight> FlightList = new ArrayList<Flight>();

    public boolean joinFlight(Flight f) {
        return FlightList.add(f);
    }


    public boolean landFlight(Flight f) {
        int element_index = FlightList.indexOf(f);

        if (element_index != -1) {
            FlightList.remove(element_index);
            return true;
        }
        else {
            return false;
        }
    }


    public int Get_FlightList_Size() {
        return FlightList.size();
    }


    public void Clear_FlightList() {
        FlightList.clear();
    }


    public List<Flight> Get_FlightList() {
        return  FlightList;
    }
}
