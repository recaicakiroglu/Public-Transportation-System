
public class Service implements Comparable<Service>{
private String Id;
private String time;
private String routeId;
private String busId;
private String driverId;
public Service(String id, String time, String routeId, String busId,
		String driverId) {
	Id = id;
	this.time = time;
	this.routeId = routeId;
	this.busId = busId;
	this.driverId = driverId;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getRouteId() {
	return routeId;
}
public void setRouteId(String routeId) {
	this.routeId = routeId;
}
public String getBusId() {
	return busId;
}
public void setBusId(String busId) {
	this.busId = busId;
}
public String getDriverId() {
	return driverId;
}
public void setDriverId(String driverId) {
	this.driverId = driverId;
}


@Override
public int compareTo(Service compareService){
	int int1 = Integer.parseInt(((Service) compareService).getId());
    int compareID = int1;
    int int2 = Integer.parseInt(this.Id);
   return int2 - int1;
}
}
