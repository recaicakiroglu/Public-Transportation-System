import java.util.ArrayList;


public class PostgreSQL {

	Main main = new Main();
	//methods
	public void addBustoPostgreSQL(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 5) {
			if(i < piece.length - 4){
				if(!isbusArrayP(piece[i]))
				Main.busArrayP.add(new Bus(piece[i], piece[i + 1], piece[i + 2],piece[i + 3], piece[i + 4]));
			
			}
		}
	}
	public void addDrivertoPostgreSQL(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 5) {		
			if(i < piece.length - 4){
				if(!isdriverArrayP(piece[i]))
				Main.driverArrayP.add(new Driver(piece[i], piece[i + 1], piece[i + 2],piece[i + 3], piece[i + 4]));		
		}
		}
	} 
	public void addBusStoptoPostgreSQL(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 4) {
			if(i < piece.length - 3){
				if(!isbusstopArrayP(piece[i]))
				Main.busstopArrayP.add(new BusStop(piece[i], piece[i + 1], piece[i + 2],piece[i + 3]));
			
			}
		}

	}
	public void addServicetoPostgreSQL(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 5) {
			if(i < piece.length - 4){
				if(!isserviceArrayP(piece[i]))
				Main.serviceArrayP.add(new Service(piece[i], piece[i + 1], piece[i + 2],piece[i + 3], piece[i + 4]));
			
			}
		}
	}
	public void addRoutetoPostgreSQL(String str) {
			String piece[] = str.split("\t");	
			if(!isrouteArrayP(piece[0])){
				if(piece.length == 5)
				{
					String words[] = null;
					ArrayList <String> BusStop = new ArrayList<String>();
					BusStop.add(piece[2]);
					BusStop.add(piece[3]);
					BusStop.add(piece[4]);
					
					Main.routeArrayP.add(new Route(piece[0], piece[1],BusStop));	
					
				}
				else if(piece.length == 6)
				{
					String words[] = null;
					ArrayList <String> BusStop = new ArrayList<String>();
					BusStop.add(piece[2]);
					BusStop.add(piece[3]);
					BusStop.add(piece[4]);
					BusStop.add(piece[5]);
				
					Main.routeArrayP.add(new Route(piece[0], piece[1],BusStop));	
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
				
					Main.routeArrayP.add(new Route(piece[0], piece[1],BusStop));	
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
					
					Main.routeArrayP.add(new Route(piece[0], piece[1],BusStop));
				}
				else if(piece.length == 9)
				{
					
					String words[] = null;
					ArrayList <String> BusStop = new ArrayList<String>();
					BusStop.add(piece[2]);
					BusStop.add(piece[3]);
					BusStop.add(piece[4]);
					BusStop.add(piece[5]);
					BusStop.add(piece[6]);
					BusStop.add(piece[7]);
					BusStop.add(piece[8]);
					Main.routeArrayP.add(new Route(piece[0], piece[1],BusStop));
				}
			}
			
		
		}
		

	
	public boolean isbusArrayP(String str)
	{
		for ( int i = 0; i < Main.busArrayP.size(); i++)
		{
			if(str.equals(Main.busArrayP.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isdriverArrayP(String str)
	{
		for ( int i = 0; i < Main.driverArrayP.size(); i++)
		{
			if(str.equals(Main.driverArrayP.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isserviceArrayP(String str)
	{
		for ( int i = 0; i < Main.serviceArrayP.size(); i++)
		{
			if(str.equals(Main.serviceArrayP.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isbusstopArrayP(String str)
	{
		for ( int i = 0; i < Main.busstopArrayP.size(); i++)
		{
			if(str.equals(Main.busstopArrayP.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isrouteArrayP(String str)
	{
		for ( int i = 0; i < Main.routeArrayP.size(); i++)
		{
			if(str.equals(Main.routeArrayP.get(i).getId()))
				return true;
		}
		return false;
	}
	
	public static void routeControlP()
	{
		ArrayList <String> Problem = new ArrayList<String>();
		ArrayList <String> Problem2 = new ArrayList<String>();
		for (int i = 0; i < Main.routeArrayP.size(); i++) {
			for (int j = 0; j < Main.routeArrayP.get(i).getBusStop().size(); j++) {
				if(!isEqualsbusstopArrayP(Main.routeArrayP.get(i).getBusStop().get(j)))
				Problem.add(Main.routeArrayP.get(i).getId());
				
			}
		}
			
		for (int i = 0; i < Main.routeArrayP.size(); i++) {
			if(Problem.contains(Main.routeArrayP.get(i).getId())){
			
				Main.routeArrayP.remove(i);
				
			}
		}
		}
		
	
		
		
	
	public static boolean isEqualsbusstopArrayP(String str)
	{
		for ( int i = 0; i < Main.busstopArrayP.size(); i++)
		{
			if(str.equals((Main.busstopArrayP.get(i).getId())))
				return true;
		}
		return false;
	}
	
	
	public static void serviceControlP()
	{
		for (int i = 0; i < Main.serviceArrayP.size(); i++) {
			if(!isRouteServiceArrayP(Main.serviceArrayP.get(i).getRouteId()))
					{
				Main.serviceArrayP.remove(i);
					}
		}
		for (int i = 0; i < Main.serviceArrayP.size(); i++) {
			if(!isDriverServiceArrayP(Main.serviceArrayP.get(i).getDriverId()))
					{
				Main.serviceArrayP.remove(i);
					}
		}
		for (int i = 0; i < Main.serviceArrayP.size(); i++) {
			if(!isBusServiceArrayP(Main.serviceArrayP.get(i).getBusId()))
					{
				Main.serviceArrayP.remove(i);
					}
		}
		
	}
	public static boolean isRouteServiceArrayP(String str)
	{
		for ( int i = 0; i < Main.routeArrayP.size(); i++)
		{
			if(str.equals(Main.routeArrayP.get(i).getId()))
				return true;
		}
		return false;
	}
	public static boolean isDriverServiceArrayP(String str)
	{
		for ( int i = 0; i < Main.driverArrayP.size(); i++)
		{
			if(str.equals(Main.driverArrayP.get(i).getId()))
				return true;
		}
		return false;
	}
	public static boolean isBusServiceArrayP(String str)
	{
		for ( int i = 0; i < Main.busArrayP.size(); i++)
		{
			if(str.equals(Main.busArrayP.get(i).getId()))
				return true;
		}
		return false;
	}
}
	


