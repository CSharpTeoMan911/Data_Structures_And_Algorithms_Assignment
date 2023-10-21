package assignment2_2;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Airline {

    private ArrayDeque<Flight> FlightList = new ArrayDeque<Flight>();

    public boolean joinFlight(Flight f) {
        return FlightList.add(f);
    }


    public void landFlight(Flight f) {
        if(FlightList.peekFirst() == f)
        {
            FlightList.removeFirst();
        }
        else if(FlightList.peekLast() == f)
        {
            FlightList.removeLast();
        }
        else {
            FlightList.remove(f);
        }
    }


    public int Get_FlightList_Size() {
        return FlightList.size();
    }


    public void Clear_FlightList() {
        FlightList.clear();
    }


    public ArrayDeque<Flight> Get_FlightList() {
        return FlightList;
    }
}
