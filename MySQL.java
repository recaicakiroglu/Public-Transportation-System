import java.util.ArrayList;
import java.util.List;

public class MySQL {

	Main main = new Main();
	
	//methods
	public void addBustoMySQL(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 5) {
			if(i < piece.length - 4){
				if(!isbusArrayM(piece[i]))
					Main.busArrayM.add(new Bus(piece[i], piece[i + 1], piece[i + 2],piece[i + 3], piece[i + 4]));						
		}
		}
	}
	public void addDrivertoMySQL(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 5) {	
			if(i < piece.length - 4){
				if(!isdriverArrayM(piece[i]))
				Main.driverArrayM.add(new Driver(piece[i], piece[i + 1], piece[i + 2],piece[i + 3], piece[i + 4]));		
		}
		}
	} 
	public void addBusStoptoMySQL(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 4) {
			if(i < piece.length - 3){
				if(!isbusstopArrayM(piece[i]))
				Main.busstopArrayM.add(new BusStop(piece[i], piece[i + 1], piece[i + 2],piece[i + 3]));						
		}
		}
	}	
	public void addServicetoMySQL(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 5) {
			if(i < piece.length - 4){
				if(!isserviceArrayM(piece[i]))
				Main.serviceArrayM.add(new Service(piece[i], piece[i + 1], piece[i + 2],piece[i + 3], piece[i + 4]));						
		}
		}
	}
	public void addRoutetoMySQL(String str) {
		String piece[] = str.split("\t");	
		if(!isrouteArrayM(piece[0])){
			if(piece.length == 5)
			{
				String words[] = null;
				ArrayList <String> BusStop = new ArrayList<String>();
				BusStop.add(piece[2]);
				BusStop.add(piece[3]);
				BusStop.add(piece[4]);
				
				Main.routeArrayM.add(new Route(piece[0], piece[1],BusStop));	
				
			}
			else if(piece.length == 6)
			{
				String words[] = null;
				ArrayList <String> BusStop = new ArrayList<String>();
				BusStop.add(piece[2]);
				BusStop.add(piece[3]);
				BusStop.add(piece[4]);
				BusStop.add(piece[5]);
			
				Main.routeArrayM.add(new Route(piece[0], piece[1],BusStop));	
			}
			else if(piece.length == 7)
			{
				String words[] = null;
				ArrayList <String> BusStop = new ArrayList<String>();
				BusStop.add(piece[2]);
				BusStop.add(piece[3]);
				BusStop.add(piece[4]);
				BusStop.add(piece[5]);
				BusStop.add(piece[6]);
			
				Main.routeArrayM.add(new Route(piece[0], piece[1],BusStop));	
				
			}else if(piece.length == 8)
			{
				
				String words[] = null;
				ArrayList <String> BusStop = new ArrayList<String>();
				BusStop.add(piece[2]);
				BusStop.add(piece[3]);
				BusStop.add(piece[4]);
				BusStop.add(piece[5]);
				BusStop.add(piece[6]);
				BusStop.add(piece[7]);
				
				Main.routeArrayM.add(new Route(piece[0], piece[1],BusStop));
			}
		}
	
}
	
	public boolean isbusArrayM(String str)
	{
		for ( int i = 0; i < Main.busArrayM.size(); i++)
		{
			if(str.equals(Main.busArrayM.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isdriverArrayM(String str)
	{
		for ( int i = 0; i < Main.driverArrayM.size(); i++)
		{
			if(str.equals(Main.driverArrayM.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isserviceArrayM(String str)
	{
		for ( int i = 0; i < Main.serviceArrayM.size(); i++)
		{
			if(str.equals(Main.serviceArrayM.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isbusstopArrayM(String str)

	{
		for ( int i = 0; i < Main.busstopArrayM.size(); i++)
		{
			if(str.equals(Main.busstopArrayM.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isrouteArrayM(String str)

	{
		for ( int i = 0; i < Main.routeArrayM.size(); i++)
		{
			if(str.equals(Main.routeArrayM.get(i).getId()))
				return true;
		}
		return false;
	}
	public static void routeControlM()
	{
		ArrayList <String> Problem = new ArrayList<String>();
		ArrayList <String> Problem2 = new ArrayList<String>();
		for (int i = 0; i < Main.routeArrayM.size(); i++) {
			for (int j = 0; j < Main.routeArrayM.get(i).getBusStop().size(); j++) {
				if(!isEqualsbusstopArrayM(Main.routeArrayM.get(i).getBusStop().get(j)))
				Problem.add(Main.routeArrayM.get(i).getId());			
			}
		}
		
		
		for (int i = 0; i < Main.routeArrayM.size(); i++) {
			if(Problem.contains(Main.routeArrayM.get(i).getId())){
				
				Main.routeArrayM.remove(i);
				Problem2.add(Main.routeArrayM.get(i).getId());
				if(Problem2.contains(Main.routeArrayM.get(i).getId())){
				
					Main.routeArrayM.remove(i);
				}
			}
					
		}
		}
						
	public static boolean isEqualsbusstopArrayM(String str)
{
	for ( int i = 0; i < Main.busstopArrayM.size(); i++)
	{
		if(str.equals((Main.busstopArrayM.get(i).getId())))
			return true;
	}
	return false;
}

	
		
		
	
	
	public static void serviceControlM()
	{
		for (int i = 0; i < Main.serviceArrayM.size(); i++) {
			if(!isRouteServiceArrayM(Main.serviceArrayM.get(i).getRouteId()))
					{
				Main.serviceArrayM.remove(i);
					}
		}
		for (int i = 0; i < Main.serviceArrayM.size(); i++) {
			if(!isDriverServiceArrayM(Main.serviceArrayM.get(i).getDriverId()))
					{
				Main.serviceArrayM.remove(i);
					}
		}
		for (int i = 0; i < Main.serviceArrayM.size(); i++) {
			if(!isBusServiceArrayM(Main.serviceArrayM.get(i).getBusId()))
					{
				Main.serviceArrayM.remove(i);
					}
		}
		
	}
	public static boolean isRouteServiceArrayM(String str)
	{
		for ( int i = 0; i < Main.routeArrayM.size(); i++)
		{
			if(str.equals(Main.routeArrayM.get(i).getId()))
				return true;
		}
		return false;
	}
	public static boolean isDriverServiceArrayM(String str)
	{
		for ( int i = 0; i < Main.driverArrayM.size(); i++)
		{
			if(str.equals(Main.driverArrayM.get(i).getId()))
				return true;
		}
		return false;
	}
	public static boolean isBusServiceArrayM(String str)
	{
		for ( int i = 0; i < Main.busArrayM.size(); i++)
		{
			if(str.equals(Main.busArrayM.get(i).getId()))
				return true;
		}
		return false;
	}
	
}
