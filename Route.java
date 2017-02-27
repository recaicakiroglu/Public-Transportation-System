import java.util.*;


public class Route implements Comparable<Route>{
private String Id;
private String year;
List <String> BusStop = new ArrayList<String>();


public Route(String id, String year, List<String> busStop) {
	super();
	Id = id;
	this.year = year;
	BusStop = busStop;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getYear() {
	return year;
}

public void setYear(String year) {
	this.year = year;
}

public List<String> getBusStop() {
	return BusStop;
}

public void setBusStop(ArrayList<String> busStop) {
	BusStop = busStop;
}

@Override
public int compareTo(Route compareRoute){
	int int1 = Integer.parseInt(((Route) compareRoute).getId());
    int compareID = int1;
    int int2 = Integer.parseInt(this.Id);
   return int2 - int1;
}



}
