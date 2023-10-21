package assignment2_3;

import java.util.*;

public class Airline {

    private PriorityQueue<Flight> FlightList = new PriorityQueue <Flight>(new Comparator<Flight>() {
        @Override
        public int compare(Flight o1, Flight o2) {
            return Integer.compare(o1.Get_capacity(), o2.Get_capacity());
        }
    });

    public boolean joinFlight(Flight f)
    {
        return FlightList.add(f);
    }


    public void landFlight(Flight f) {

        if(FlightList.peek() == f)
        {
            FlightList.poll();
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


    public PriorityQueue<Flight> Get_FlightList() {
        return FlightList;
    }
}
