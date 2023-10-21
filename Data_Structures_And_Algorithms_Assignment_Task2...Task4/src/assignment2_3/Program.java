package assignment2_3;
import java.util.List;
import java.util.PriorityQueue;

public class Program {

    public void Main_Operation() {


        Flight flight1 = new Flight();
        flight1.Set_flightID("123456");
        flight1.Set_priorityCode("1");
        flight1.Set_flightType(Flight.Ftype.cargo);
        flight1.Set_destination("Bogota, Colombia");
        flight1.Set_capacity(100);
        flight1.Set_day("12");
        flight1.Set_month("12");
        flight1.Set_year("2023");


        Flight flight1_deep_copy = new Flight(flight1);
        Flight flight1_shallow_copy = flight1;




        System.out.println("\n\n\n\nVALUES IN THE ORIGINAL INSTANCE ARE INITIATED\n__________________________________________________________________________________\n");

        Print_Elements(flight1, flight1_deep_copy, flight1_shallow_copy, "all");



        flight1.Set_flightID("VALUE CHANGED IN flight1 object");
        flight1.Set_destination("VALUE CHANGED IN flight1 object");
        flight1.Set_priorityCode("VALUE CHANGED IN flight1 object");
        flight1.Set_capacity(100000);
        flight1.Set_day("VALUE CHANGED IN flight1 object");
        flight1.Set_month("VALUE CHANGED IN flight1 object");
        flight1.Set_year("VALUE CHANGED IN flight1 object");
        flight1.Set_flightType(Flight.Ftype.national);


        System.out.println("\n\n\n\n\n\n\n\nVALUES IN THE ORIGINAL INSTANCE ARE CHANGED\n__________________________________________________________________________________\n");


        Print_Elements(flight1, flight1_deep_copy, flight1_shallow_copy, "all");




        Airline airline = new Airline();

        airline.joinFlight(flight1);
        airline.joinFlight(flight1_shallow_copy);
        airline.joinFlight(flight1_deep_copy);


        PriorityQueue<Flight> airline_list = airline.Get_FlightList();


        System.out.println("\n\n\n\n\n\n\n\nVALUES IN THE FlightList\n___________________________________________________________________________________________________________________\n");
        Print_Flight_List_Elements(airline_list.toArray());


        airline.landFlight(flight1_shallow_copy);



        System.out.println("\n\n\n\n\n\n\n\nVALUES IN THE FlightList\n___________________________________________________________________________________________________________________\n");
        Print_Flight_List_Elements(airline_list.toArray());


    }


    private void Print_Flight_List_Elements(Object[] airline_list)
    {
        int type_count = 0;

        for(int index = 0; index < airline_list.length; index++)
        {
            if(type_count == 3)
            {
                type_count = 0;
            }

            switch (type_count)
            {
                case 0:
                    System.out.println("\n\n\n\n\n\n\n\nORIGINAL VALUES IN THE FlightList\n__________________________________________________________________________________\n");
                    Print_Elements((Flight)airline_list[index], null, null, "original");
                    break;
                case 1:
                    System.out.println("\n\n\n\n\n\n\n\nDEEP COPY IN THE FlightList\n__________________________________________________________________________________\n");
                    Print_Elements(null, (Flight)airline_list[index], null, "deep copy");
                    break;
                case 2:
                    System.out.println("\n\n\n\n\n\n\n\nSHALLOW COPY IN THE FlightList\n__________________________________________________________________________________\n");
                    Print_Elements(null, null, (Flight)airline_list[index], "shallow copy");
                    break;

            }

            type_count++;
        }
    }


    private void Print_Elements(Flight object1, Flight object2, Flight object3, String object_count)
    {

        switch (object_count)
        {
            case "original":
                System.out.println("flight1 flightID: " + object1.Get_flightID() + "\n\n");

                System.out.println("flight1 destination: " + object1.Get_destination() + "\n\n");

                System.out.println("flight1 priorityCode: " + object1.Get_priorityCode() + "\n\n");

                System.out.println("flight1 capacity: " + object1.Get_capacity() + "\n\n");

                System.out.println("flight1 day: " + object1.Get_day() + "\n\n");

                System.out.println("flight1 month: " + object1.Get_month() + "\n\n");

                System.out.println("flight1 year: " + object1.Get_year() + "\n\n");

                System.out.println("flight1 flightType: " + object1.Get_flightType() + "\n\n");
                break;
            case "deep copy":
                System.out.println("flight1_deep_copy flightID: " + object2.Get_flightID() + "\n\n");

                System.out.println("flight1_deep_copy destination: " + object2.Get_destination() + "\n\n");

                System.out.println("flight1_deep_copy priorityCode: " + object2.Get_priorityCode() + "\n\n");

                System.out.println("flight1_deep_copy capacity: " + object2.Get_capacity() + "\n\n");

                System.out.println("flight1_deep_copy day: " + object2.Get_day() + "\n\n");

                System.out.println("flight1_deep_copy month: " + object2.Get_month() + "\n\n");

                System.out.println("flight1_deep_copy year: " + object2.Get_year() + "\n\n");

                System.out.println("flight1_deep_copy flightType: " + object2.Get_flightType() + "\n\n");
                break;
            case "shallow copy":
                System.out.println("flight1_shallow_copy flightID: " + object3.Get_flightID() + "\n\n");

                System.out.println("flight1_shallow_copy destination: " + object3.Get_destination() + "\n\n");

                System.out.println("flight1_shallow_copy priorityCode: " + object3.Get_priorityCode() + "\n\n");

                System.out.println("flight1_shallow_copy capacity: " + object3.Get_capacity() + "\n\n");

                System.out.println("flight1_shallow_copy day: " + object3.Get_day() + "\n\n");

                System.out.println("flight1_shallow_copy month: " + object3.Get_month() + "\n\n");

                System.out.println("flight1_shallow_copy year: " + object3.Get_year() + "\n\n");

                System.out.println("flight1_shallow_copy flightType: " + object3.Get_flightType() + "\n\n");
                break;
            case "all":
                System.out.println("flight1 flightID: " + object1.Get_flightID() + "\n\n");
                System.out.println("flight1_deep_copy flightID: " + object2.Get_flightID() + "\n\n");
                System.out.println("flight1_shallow_copy flightID: " + object3.Get_flightID() + "\n\n");

                System.out.println("flight1 destination: " + object1.Get_destination() + "\n\n");
                System.out.println("flight1_deep_copy destination: " + object2.Get_destination() + "\n\n");
                System.out.println("flight1_shallow_copy destination: " + object3.Get_destination() + "\n\n");

                System.out.println("flight1 priorityCode: " + object1.Get_priorityCode() + "\n\n");
                System.out.println("flight1_deep_copy priorityCode: " + object2.Get_priorityCode() + "\n\n");
                System.out.println("flight1_shallow_copy priorityCode: " + object3.Get_priorityCode() + "\n\n");

                System.out.println("flight1 capacity: " + object1.Get_capacity() + "\n\n");
                System.out.println("flight1_deep_copy capacity: " + object2.Get_capacity() + "\n\n");
                System.out.println("flight1_shallow_copy capacity: " + object3.Get_capacity() + "\n\n");

                System.out.println("flight1 day: " + object1.Get_day() + "\n\n");
                System.out.println("flight1_deep_copy day: " + object2.Get_day() + "\n\n");
                System.out.println("flight1_shallow_copy day: " + object3.Get_day() + "\n\n");

                System.out.println("flight1 month: " + object1.Get_month() + "\n\n");
                System.out.println("flight1_deep_copy month: " + object2.Get_month() + "\n\n");
                System.out.println("flight1_shallow_copy month: " + object3.Get_month() + "\n\n");

                System.out.println("flight1 year: " + object1.Get_year() + "\n\n");
                System.out.println("flight1_deep_copy year: " + object2.Get_year() + "\n\n");
                System.out.println("flight1_shallow_copy year: " + object3.Get_year() + "\n\n");

                System.out.println("flight1 flightType: " + object1.Get_flightType() + "\n\n");
                System.out.println("flight1_deep_copy flightType: " + object2.Get_flightType() + "\n\n");
                System.out.println("flight1_shallow_copy flightType: " + object3.Get_flightType() + "\n\n");
                break;
        }



    }



}
