package assignment2_1;

public class Flight {

    private String flightID;
    private String destination;
    private String priorityCode;
    private int capacity;

    private String day;
    private String month;
    private String year;

    private Ftype flightType;

    public Flight() {
    }

    public Flight(Flight deep_copy) {

        this.Set_flightID(deep_copy.Get_flightID());
        this.Set_destination(deep_copy.Get_destination());
        this.Set_priorityCode(deep_copy.Get_priorityCode());
        this.Set_capacity(deep_copy.Get_capacity());
        this.Set_day(deep_copy.Get_day());
        this.Set_month(deep_copy.Get_month());
        this.Set_year(deep_copy.Get_year());
        this.Set_flightType(deep_copy.Get_flightType());
    }


    public String Get_flightID() {
        return flightID;
    }


    public void Set_flightID(String flightID_value) {
        flightID = flightID_value;
    }


    public String Get_destination() {
        return destination;
    }


    public void Set_destination(String destination_value) {
        destination = destination_value;
    }


    public String Get_priorityCode() {
        return destination;
    }


    public void Set_priorityCode(String priorityCode_value) {
        priorityCode = priorityCode_value;
    }


    public int Get_capacity() {
        return capacity;
    }


    public void Set_capacity(int capacity_value) {
        capacity = capacity_value;
    }


    public String Get_day() {
        return day;
    }


    public void Set_day(String day_value) {
        day = day_value;
    }


    public String Get_month() {
        return month;
    }


    public void Set_month(String month_value) {
        month = month_value;
    }


    public String Get_year() {
        return year;
    }


    public void Set_year(String year_value) {
        year = year_value;
    }


    public Ftype Get_flightType() {
        return flightType;
    }


    public void Set_flightType(Ftype flightType_value) {
        flightType = flightType_value;
    }


    public enum Ftype {
        international,
        national,
        cargo
    }

}
