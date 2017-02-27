import java.util.ArrayList;


public class Oracle {
	//
	Main main = new Main();
	// getters
	
	// methods
	public void addBustoOracle(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 5) {
			if(i < piece.length - 4){
				if(!isbusArrayO(piece[i]))
			Main.busArrayO.add(new Bus(piece[i], piece[i + 1], piece[i + 2],
					piece[i + 3], piece[i + 4]));
			}
		}
	}	
	public void addDrivertoOracle(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 5) {	
			if(i < piece.length - 4){
				if(!isdriverArrayO(piece[i]))
				Main.driverArrayO.add(new Driver(piece[i], piece[i + 1], piece[i + 2],piece[i + 3], piece[i + 4]));	
			}
			
	}
	}
	public void addBusStoptoOracle(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 4) {
			if(i < piece.length - 3){
				if(!isbusstopArrayO(piece[i]))
				Main.busstopArrayO.add(new BusStop(piece[i], piece[i + 1], piece[i + 2],
					piece[i + 3]));
			}
		}
	}	
	public void addServicetoOracle(String str) {
		String piece[] = str.split("\t");
		for (int i = 0; i < piece.length; i = i + 5) {
			if(i < piece.length - 4){
				if(!isserviceArrayO(piece[i]))
				Main.serviceArrayO.add(new Service(piece[i], piece[i + 1], piece[i + 2],
					piece[i + 3], piece[i + 4]));
			}
		}
	}
	public void addRoutetoOracle(String str) {
		String piece[] = str.split("\t");	
		if(!isrouteArrayO(piece[0])){
			if(piece.length == 5)
			{
				String words[] = null;
				ArrayList <String> BusStop = new ArrayList<String>();
				BusStop.add(piece[2]);
				BusStop.add(piece[3]);
				BusStop.add(piece[4]);
				
				Main.routeArrayO.add(new Route(piece[0], piece[1],BusStop));	
				
			}
			else if(piece.length == 6)
			{
				String words[] = null;
				ArrayList <String> BusStop = new ArrayList<String>();
				BusStop.add(piece[2]);
				BusStop.add(piece[3]);
				BusStop.add(piece[4]);
				BusStop.add(piece[5]);
			
				Main.routeArrayO.add(new Route(piece[0], piece[1],BusStop));	
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
			
				Main.routeArrayO.add(new Route(piece[0], piece[1],BusStop));	
				
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
				
				Main.routeArrayO.add(new Route(piece[0], piece[1],BusStop));
			}
		}
		
	
	}
	
	
	
	public boolean isbusArrayO(String str)
	{
		for ( int i = 0; i < Main.busArrayO.size(); i++)
		{
			if(str.equals(Main.busArrayO.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isdriverArrayO(String str)

	{
		for ( int i = 0; i < Main.driverArrayO.size(); i++)
		{
			if(str.equals(Main.driverArrayO.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isserviceArrayO(String str)
	{
		for ( int i = 0; i < Main.serviceArrayO.size(); i++)
		{
			if(str.equals(Main.serviceArrayO.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isbusstopArrayO(String str)
	{
		for ( int i = 0; i < Main.busstopArrayO.size(); i++)
		{
			if(str.equals(Main.busstopArrayO.get(i).getId()))
				return true;
		}
		return false;
	}
	public boolean isrouteArrayO(String str)
	{
		for ( int i = 0; i < Main.routeArrayO.size(); i++)
		{
			if(str.equals(Main.routeArrayO.get(i).getId()))
				return true;
		}
		return false;
	}
	
	
	public static void routeControlO()
	{
		ArrayList <String> Problem = new ArrayList<String>();
		ArrayList <String> Problem2 = new ArrayList<String>();
		for (int i = 0; i < Main.routeArrayO.size(); i++) {
			for (int j = 0; j < Main.routeArrayO.get(i).BusStop.size(); j++) {
				if(!isEqualsbusstopArrayO(Main.routeArrayO.get(i).BusStop.get(j)))	
				Problem.add(Main.routeArrayO.get(i).getId());				
			}
		}
		
		for (int i = 0; i < Main.routeArrayO.size(); i++) {
			if(Problem.contains(Main.routeArrayO.get(i).getId())){		
				Main.routeArrayO.remove(i);
					
			}
		}
		}
		
	
		
		
	
	public static boolean isEqualsbusstopArrayO(String str)
	{
		for ( int i = 0; i < Main.busstopArrayO.size(); i++)
		{
			if(str.equals((Main.busstopArrayO.get(i).getId())))
				return true;
		}
		return false;
	}
	
	
	public static void serviceControlO()
	{
		for (int i = 0; i < Main.serviceArrayO.size(); i++) {
			if(!isRouteServiceArrayO(Main.serviceArrayO.get(i).getRouteId()))
					{
				Main.serviceArrayO.remove(i);
					}
		}
		for (int i = 0; i < Main.serviceArrayO.size(); i++) {
			if(!isDriverServiceArrayO(Main.serviceArrayO.get(i).getDriverId()))
					{
				Main.serviceArrayO.remove(i);
					}
		}
		for (int i = 0; i < Main.serviceArrayO.size(); i++) {
			if(!isBusServiceArrayO(Main.serviceArrayO.get(i).getBusId()))
					{
				Main.serviceArrayO.remove(i);
					}
		}
		
	}
	public static boolean isRouteServiceArrayO(String str)
	{
		for ( int i = 0; i < Main.routeArrayO.size(); i++)
		{
			if(str.equals(Main.routeArrayO.get(i).getId()))
				return true;
		}
		return false;
	}
	public static boolean isDriverServiceArrayO(String str)
	{
		for ( int i = 0; i < Main.driverArrayO.size(); i++)
		{
			if(str.equals(Main.driverArrayO.get(i).getId()))
				return true;
		}
		return false;
	}
	public static boolean isBusServiceArrayO(String str)
	{
		for ( int i = 0; i < Main.busArrayO.size(); i++)
		{
			if(str.equals(Main.busArrayO.get(i).getId()))
				return true;
		}
		return false;
	}
}

