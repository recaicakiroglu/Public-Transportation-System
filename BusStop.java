
public class BusStop implements Comparable<BusStop>{
private String Id;
private String name;
private String location;
private String capacity;
public BusStop(String id, String name, String location, String capacity) {
	Id = id;
	this.name = name;
	this.location = location;
	this.capacity = capacity;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCapacity() {
	return capacity;
}
public void setCapacity(String capacity) {
	this.capacity = capacity;
}

@Override
public int compareTo(BusStop compareBusStop){
	int int1 = Integer.parseInt(((BusStop) compareBusStop).getId());
    int compareID = int1;
    int int2 = Integer.parseInt(this.Id);
   return int2 - int1;
}

}
