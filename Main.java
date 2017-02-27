import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Main {
	static List<Bus> busArrayO = new ArrayList<Bus>();
	static List<Driver> driverArrayO = new ArrayList<Driver>();
	static List<BusStop> busstopArrayO = new ArrayList<BusStop>();
	static List<Service> serviceArrayO = new ArrayList<Service>();
	static List<Route> routeArrayO = new ArrayList<Route>();
	static List<Bus> busArrayM = new ArrayList<Bus>();
	static List<Driver> driverArrayM = new ArrayList<Driver>();
	static List<BusStop> busstopArrayM = new ArrayList<BusStop>();
	static List<Service> serviceArrayM = new ArrayList<Service>();
	static List<Route> routeArrayM = new ArrayList<Route>();
	static List<Bus> busArrayP = new ArrayList<Bus>();
	static List<Driver> driverArrayP = new ArrayList<Driver>();
	static List<BusStop> busstopArrayP = new ArrayList<BusStop>();
	static List<Service> serviceArrayP = new ArrayList<Service>();
	static List<Route> routeArrayP = new ArrayList<Route>();
	public static void main(String[] args) throws IOException {
		 String busfile = args[0];
         String driverfile = args[1];
         String busStopfile = args[2];
         String routefile = args[3];
         String servicefile = args[4];
         String commandsfile = args[5];
         String outputfile = args[6];
		Read read = new Read();
		read.readRoute(routefile);
		read.readDriver(driverfile);
		read.readBus(busfile);
		read.readBusStop(busStopfile);
		read.readService(servicefile);
		nullable();
		Oracle.routeControlO();
		Oracle.serviceControlO();
		PostgreSQL.routeControlP();
		PostgreSQL.serviceControlP();
		MySQL.routeControlM();
		MySQL.serviceControlM();		
		Collections.sort(busArrayO);
        Collections.sort(busArrayM);
        Collections.reverse(busArrayM);
        Collections.sort(busArrayP);
        Collections.sort(driverArrayO);
        Collections.sort(driverArrayM);
        Collections.reverse(driverArrayM);
        Collections.sort(driverArrayP);       
        Collections.sort(busstopArrayO);
        Collections.sort(busstopArrayM);
        Collections.reverse(busstopArrayM);
        Collections.sort(busstopArrayP);       
        Collections.sort(routeArrayO);
        Collections.sort(routeArrayM);
        Collections.reverse(routeArrayM);
        Collections.sort(routeArrayP);   
        Collections.sort(serviceArrayO);
        Collections.sort(serviceArrayM);
        Collections.reverse(serviceArrayM);
        Collections.sort(serviceArrayP);                
      
	//writing
        
    	FileReader reader = new FileReader(commandsfile);
    	 LineNumberReader bufferReader = new LineNumberReader(reader);
    	 BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile));
    	 String line;
    	 
    	 while ((line = bufferReader.readLine()) != null){
    		 String word[] = null;
    		 word = line.split(" ");
    		 word = line.split("\t");
    			if(word[0].equals("LIST_ALL") && word.length == 1){
    				Writer.listAll(bufferReader.getLineNumber(),writer,busArrayO, busArrayM,busArrayP,
    			         driverArrayO, driverArrayM, driverArrayP,  busstopArrayO,busstopArrayM,
    			           busstopArrayP, routeArrayO, routeArrayM, routeArrayP,
    			          serviceArrayO,  serviceArrayM, serviceArrayP);
    		}
    		if(word[0].equals("LIST_ALL") && word.length !=1){
    			
					if(word[1].equals("Oracle")){
						
						Writer.listAllOracle(bufferReader.getLineNumber(), writer, busArrayO, driverArrayO, busstopArrayO,
											routeArrayO, serviceArrayO);
					}
					else if(word[1].equals("MySQL")){
						Writer.listAllMySQL(bufferReader.getLineNumber(), writer, busArrayM, driverArrayM, busstopArrayM, routeArrayM,
											serviceArrayM);
					}
					else if(word[1].equals("PostgreSQL")){
						Writer.listAllPostgreSQL(bufferReader.getLineNumber(), writer, busArrayP, driverArrayP,
											busstopArrayP, routeArrayP, serviceArrayP);
					}
			}
    			if(word[0].equals("ADD_BUS") && word[1].equals("Oracle")){
    				busArrayO = Writer.addOracleBus(busArrayO, word[2], word[3], word[4], word[5], word[6], writer, bufferReader.getLineNumber());
			}
    			if(word[0].equals("ADD_BUS") && word[1].equals("MySQL")){
    				busArrayM = Writer.addMysqlBus(busArrayM, word[2], word[3], word[4], word[5], word[6], writer, bufferReader.getLineNumber());
			}
			if(word[0].equals("ADD_BUS") && word[1].equals("PostgreSQL")){
				busArrayP = Writer.addPostgresqlBus(busArrayP, word[2], word[3], word[4], word[5], word[6], writer, bufferReader.getLineNumber());
			}
			if(word[0].equals("ADD_DRIVER") && word[1].equals("Oracle")){
				driverArrayO = Writer.addOracleDriver(driverArrayO, word[2], word[3], word[4], word[5], word[6], writer, bufferReader.getLineNumber());
		}
		if(word[0].equals("ADD_DRIVER") && word[1].equals("MySQL")){
			driverArrayM = Writer.addMysqlDriver(driverArrayM, word[2], word[3], word[4], word[5], word[6], writer, bufferReader.getLineNumber());
		}
		if(word[0].equals("ADD_DRIVER") && word[1].equals("PostgreSQL")){
			driverArrayP = Writer.addPostgresqlDriver(driverArrayP, word[2], word[3], word[4], word[5], word[6], writer, bufferReader.getLineNumber());
		}
		if(word[0].equals("ADD_BUS_STOP") && word[1].equals("Oracle")){
			busstopArrayO = Writer.addOracleStop(busstopArrayO, word[2], word[3], word[4], word[5], writer, bufferReader.getLineNumber());
	}
	if(word[0].equals("ADD_BUS_STOP") && word[1].equals("MySQL")){
		busstopArrayM = Writer.addMysqlStop(busstopArrayM, word[2], word[3], word[4], word[5], writer, bufferReader.getLineNumber());
	}
	if(word[0].equals("ADD_BUS_STOP") && word[1].equals("PostgreSQL")){
		busstopArrayP = Writer.addPostgresqlStop(busstopArrayP, word[2], word[3], word[4], word[5], writer, bufferReader.getLineNumber());
	}
	if(word[0].equals("ADD_ROUTE") && word[1].equals("Oracle")){			
		String str = word[2]+ "\t";
		str = str + word[3]+ "\t";
		for(int so=4;so<word.length;so++){
			str = str + word[so]+ "\t";
				
		}
		
		Writer.addOracleRoute(routeArrayO, word[2], word[3], writer, bufferReader.getLineNumber(), str);
}
	if(word[0].equals("ADD_ROUTE") && word[1].equals("MySQL")){			
		String str = word[2]+ "\t";
		str = str + word[3]+ "\t";
		for(int so=4;so<word.length;so++){
			str = str + word[so]+ "\t";
				
		}
		
		Writer.addMysqlRoute(routeArrayM, word[2], word[3], writer, bufferReader.getLineNumber(), str);
		
}
	if(word[0].equals("ADD_ROUTE") && word[1].equals("PostgreSQL")){	
	String str = word[2]+ "\t";
	str = str + word[3]+ "\t";
	for(int so=4;so<word.length;so++){
		str = str + word[so]+ "\t";
			
	}
	
	Writer.addPostgresqlRoute(routeArrayP, word[2], word[3], writer, bufferReader.getLineNumber(), str);
	
}
			if(word[0].equals("ADD_SERVICE") && word[1].equals("Oracle")){
				serviceArrayO = Writer.addOracleService(serviceArrayO, word[2], word[3], word[4], word[5], word[6], writer, bufferReader.getLineNumber(), routeArrayO, busArrayO, driverArrayO);
		}
			if(word[0].equals("ADD_SERVICE") && word[1].equals("MySQL")){
				serviceArrayM = Writer.addMysqlService(serviceArrayM, word[2], word[3], word[4], word[5], word[6], writer, bufferReader.getLineNumber(), routeArrayM, busArrayM, driverArrayM);
		}
		if(word[0].equals("ADD_SERVICE") && word[1].equals("PostgreSQL")){
			serviceArrayP = Writer.addPostgresqlService(serviceArrayP, word[2], word[3], word[4], word[5], word[6], writer, bufferReader.getLineNumber(), routeArrayP, busArrayP, driverArrayP);
		}
			if(word[0].equals("DELETE_BUS") && word[1].equals("Oracle")){
				busArrayO = Writer.deleteOracleBus(busArrayO,serviceArrayO, word[2], writer, bufferReader.getLineNumber());
		}
		if(word[0].equals("DELETE_BUS") && word[1].equals("MySQL")){
			busArrayM = Writer.deleteMysqlBus(busArrayM,serviceArrayM,  word[2], writer, bufferReader.getLineNumber());
		}
		if(word[0].equals("DELETE_BUS") && word[1].equals("PostgreSQL")){
			busArrayP = Writer.deletePostgresqlBus(busArrayP,serviceArrayP, word[2], writer, bufferReader.getLineNumber());
		}
		if(word[0].equals("DELETE_DRIVER") && word[1].equals("Oracle")){
			driverArrayO = Writer.deleteOracleDriver(driverArrayO,serviceArrayO, word[2], writer, bufferReader.getLineNumber());
	}
	if(word[0].equals("DELETE_DRIVER") && word[1].equals("MySQL")){
		driverArrayM = Writer.deleteMysqlDriver(driverArrayM,serviceArrayM,  word[2], writer, bufferReader.getLineNumber());
	}
	if(word[0].equals("DELETE_DRIVER") && word[1].equals("PostgreSQL")){
		driverArrayP = Writer.deletePostgresqlDriver(driverArrayP,serviceArrayP, word[2], writer, bufferReader.getLineNumber());
	}
		if(word[0].equals("DELETE_BUS_STOP") && word[1].equals("Oracle")){
			busstopArrayO = Writer.deleteOracleStop(busstopArrayO, routeArrayO, serviceArrayO, word[2], writer, bufferReader.getLineNumber());
	}
		if(word[0].equals("DELETE_BUS_STOP") && word[1].equals("MySQL")){
			busstopArrayM = Writer.deleteMysqlStop(busstopArrayM, routeArrayM,serviceArrayM, word[2], writer, bufferReader.getLineNumber());
	}
	if(word[0].equals("DELETE_BUS_STOP") && word[1].equals("PostgreSQL")){
		busstopArrayP = Writer.deletePostgresqlStop(busstopArrayP, routeArrayP, serviceArrayP, word[2], writer, bufferReader.getLineNumber());
	}
		if(word[0].equals("DELETE_ROUTE") && word[1].equals("Oracle")){
			routeArrayO = Writer.deleteOracleRoute(routeArrayO, serviceArrayO, word[2], writer, bufferReader.getLineNumber());
	}	
		if(word[0].equals("DELETE_ROUTE") && word[1].equals("MySQL")){
			routeArrayM = Writer.deleteMysqlRoute(routeArrayM, serviceArrayM, word[2], writer, bufferReader.getLineNumber());
	}
		if(word[0].equals("DELETE_ROUTE") && word[1].equals("PostgreSQL")){
			routeArrayP = Writer.deletePostgresqlRoute(routeArrayP, serviceArrayP, word[2], writer, bufferReader.getLineNumber());
	}
		if(word[0].equals("DELETE_SERVICE") && word[1].equals("Oracle")){
			serviceArrayO = Writer.deleteOracleService(serviceArrayO, word[2], writer, bufferReader.getLineNumber());
	}
	if(word[0].equals("DELETE_SERVICE") && word[1].equals("MySQL")){
		serviceArrayM = Writer.deleteMysqlService(serviceArrayM, word[2], writer, bufferReader.getLineNumber());
	}
	if(word[0].equals("DELETE_SERVICE") && word[1].equals("PostgreSQL")){
		serviceArrayP = Writer.deletePostgresqlService(serviceArrayP, word[2], writer, bufferReader.getLineNumber());
	}
	if(word[0].equals("LIST_ROUTES_CONTAINING_BUS_STOP") && word[1].equals("Oracle")){
		Writer.listOracleRoutes(routeArrayO, word[2], writer, bufferReader.getLineNumber());
}
	if(word[0].equals("LIST_ROUTES_CONTAINING_BUS_STOP") && word[1].equals("MySQL")){
		Writer.listMysqlRoutes(routeArrayM, word[2], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_ROUTES_CONTAINING_BUS_STOP") && word[1].equals("PostgreSQL")){
	Writer.listPostgresqlRoutes(routeArrayP, word[2], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_DRIVERS_OF_BUS") && word[1].equals("Oracle")){
	Writer.listOracleDrivers(serviceArrayO, driverArrayO, word[2], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_DRIVERS_OF_BUS") && word[1].equals("MySQL")){
	Writer.listMysqlDrivers(serviceArrayM, driverArrayM, word[2], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_DRIVERS_OF_BUS") && word[1].equals("PostgreSQL")){
	Writer.listPostgresqlDrivers(serviceArrayP, driverArrayP, word[2], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_SERVICES_BY_MEAN_BUS_STOP_CAPACITY") && word[1].equals("Oracle")){
		Writer.listByMeanOracle(serviceArrayO, routeArrayO, busstopArrayO, word[2], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_SERVICES_BY_MEAN_BUS_STOP_CAPACITY") && word[1].equals("MySQL")){
		Writer.listByMeanMysql(serviceArrayM, routeArrayM, busstopArrayM, word[2], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_SERVICES_BY_MEAN_BUS_STOP_CAPACITY") && word[1].equals("PostgreSQL")){
	Writer.listByMeanPostgresql(serviceArrayP, routeArrayP, busstopArrayP, word[2], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_SERVICES_BY_BUS_STOPS") && word[1].equals("Oracle")){
		Writer.listByServiceStopsOracle(serviceArrayO, routeArrayO, busstopArrayO, word[2], word[3], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_SERVICES_BY_BUS_STOPS") && word[1].equals("MySQL")){
		Writer.listByServiceStopsMysql(serviceArrayM, routeArrayM, busstopArrayM, word[2], word[3], writer, bufferReader.getLineNumber());
}
if(word[0].equals("LIST_SERVICES_BY_BUS_STOPS") && word[1].equals("PostgreSQL")){
	Writer.listByServiceStopsPostgresql(serviceArrayP, routeArrayP, busstopArrayP, word[2], word[3], writer, bufferReader.getLineNumber());
}

    			}
    	writer.write("\n");
    	 bufferReader.close();
    	 writer.close();
        }
	

	
	
	public static void nullable()

	{
		//BUS CONTROL
		for (int i = 0; i < busArrayO.size(); i++) {
			//oracle		
			if(busArrayO.get(i).getModel().equals("-"))
			{
				busArrayO.remove(i);
			}
			if(busArrayO.get(i).getId().equals("-"))
			{
				busArrayO.remove(i);
			}
			if(busArrayO.get(i).getPlate().equals("-"))
			{
				busArrayO.remove(i);
			}
			if(busArrayO.get(i).getYear().equals("-"))
			{
				busArrayO.remove(i);
			}
		}
		for (int i = 0; i < busArrayM.size(); i++) {
			//mysql
			if(busArrayM.get(i).getModel().equals("-"))
			{
				busArrayM.remove(i);
			}
			if(busArrayM.get(i).getId().equals("-"))
			{
				busArrayM.remove(i);
			}
			if(busArrayM.get(i).getPlate().equals("-"))
			{
				busArrayM.remove(i);
			}
			if(busArrayM.get(i).getBrand().equals("-"))
			{
				busArrayM.remove(i);
			}
		}
			//postgre
		for (int i = 0; i < busArrayP.size(); i++) {
			if(busArrayP.get(i).getYear().equals("-"))
			{
				busArrayP.remove(i);
			}
			if(busArrayP.get(i).getId().equals("-"))
			{
				busArrayP.remove(i);
			}
			if(busArrayP.get(i).getPlate().equals("-"))
			{
				busArrayP.remove(i);
			}
			if(busArrayP.get(i).getBrand().equals("-"))
			{
				busArrayP.remove(i);
			}
			
		}
		//DRIVER CONTROL
		for (int j = 0; j < driverArrayO.size(); j++) {
		//oracle	
			if(driverArrayO.get(j).getId().equals("-"))
			{
				driverArrayO.remove(j);
			}
			if(driverArrayO.get(j).getName().equals("-"))
			{
				driverArrayO.remove(j);
			}
			if(driverArrayO.get(j).getSurname().equals("-"))
			{
				driverArrayO.remove(j);
			}
			if(driverArrayO.get(j).getPhonenumber().equals("-"))
			{
				driverArrayO.remove(j);
			}
		}
		//mysql
		for (int j = 0; j < driverArrayM.size(); j++) {
			if(driverArrayM.get(j).getId().equals("-"))
			{
				driverArrayM.remove(j);
			}
			if(driverArrayM.get(j).getName().equals("-"))
			{
				driverArrayM.remove(j);
			}
			if(driverArrayM.get(j).getSurname().equals("-"))
			{
				driverArrayM.remove(j);
			}
			if(driverArrayM.get(j).getBirthdate().equals("-"))
			{
				driverArrayM.remove(j);
			}
		}
		
		//postgre
		for (int j = 0; j < driverArrayP.size(); j++) {
			if(driverArrayP.get(j).getId().equals("-"))
			{
				driverArrayP.remove(j);
			}
			if(driverArrayP.get(j).getName().equals("-"))
			{
				driverArrayP.remove(j);
			}
			if(driverArrayP.get(j).getSurname().equals("-"))
			{
				driverArrayP.remove(j);
			}
			if(driverArrayP.get(j).getBirthdate().equals("-"))
			{
				driverArrayP.remove(j);
			}
			if(driverArrayP.get(j).getPhonenumber().equals("-"))
			{
				driverArrayP.remove(j);
			}
		}
		//BUS STOP CONTROL
		//oracle
		for (int j = 0; j < busstopArrayO.size(); j++) {
			if(busstopArrayO.get(j).getId().equals("-"))
			{
				busstopArrayO.remove(j);
			}
			if(busstopArrayO.get(j).getName().equals("-"))
			{
				busstopArrayO.remove(j);
			}
			if(busstopArrayO.get(j).getCapacity().equals("-"))
			{
				busstopArrayO.remove(j);
			}
		}
		//mysql
		for (int j = 0; j < busstopArrayM.size(); j++) {
			if(busstopArrayM.get(j).getId().equals("-"))
			{
				busstopArrayM.remove(j);
			}
			if(busstopArrayM.get(j).getName().equals("-"))
			{
				busstopArrayM.remove(j);
			}
			if(busstopArrayM.get(j).getCapacity().equals("-"))
			{
				busstopArrayM.remove(j);
			}
			if(busstopArrayM.get(j).getLocation().equals("-"))
			{
				busstopArrayM.remove(j);
			}
		}
		//postgre
		for (int j = 0; j < busstopArrayP.size(); j++) {
			if(busstopArrayP.get(j).getId().equals("-"))
			{
				busstopArrayP.remove(j);
			}
			if(busstopArrayP.get(j).getName().equals("-"))
			{
				busstopArrayP.remove(j);
			}
			if(busstopArrayP.get(j).getCapacity().equals("-"))
			{
				busstopArrayP.remove(j);
			}
		}
		//ROUTE CONTROL
		//oracle
		for (int j = 0; j < routeArrayO.size(); j++) {
			if(routeArrayO.get(j).getId().equals("-"))
			{
				routeArrayO.remove(j);
			}
			if(routeArrayO.get(j).getYear().equals("-"))
			{
				routeArrayO.remove(j);
			}
		
		}
		//mysql
		for (int j = 0; j < routeArrayM.size(); j++) {
			if(routeArrayM.get(j).getId().equals("-"))
			{
				routeArrayM.remove(j);
			}
		}
			//postgre
			for (int j = 0; j < routeArrayP.size(); j++) {
				if(routeArrayP.get(j).getId().equals("-"))
				{
					routeArrayP.remove(j);
				}
				if(routeArrayP.get(j).getYear().equals("-"))
				{
					routeArrayP.remove(j);
				}
			}
			
			//SERVICE CONTROL
			//oracle
			for (int j = 0; j < serviceArrayO.size(); j++) {
				if(serviceArrayO.get(j).getId().equals("-"))
				{
					serviceArrayO.remove(j);
				}
				if(serviceArrayO.get(j).getTime().equals("-"))
				{
					serviceArrayO.remove(j);
				}
				if(serviceArrayO.get(j).getRouteId().equals("-"))
				{
					serviceArrayO.remove(j);
				}
				if(serviceArrayO.get(j).getBusId().equals("-"))
				{
					serviceArrayO.remove(j);
				}
				if(serviceArrayO.get(j).getDriverId().equals("-"))
				{
					serviceArrayO.remove(j);
				}
			}
			
			//mysql
			for (int j = 0; j < serviceArrayM.size(); j++) {
				if(serviceArrayM.get(j).getId().equals("-"))
				{
					serviceArrayM.remove(j);
				}
				if(serviceArrayM.get(j).getTime().equals("-"))
				{
					serviceArrayM.remove(j);
				}
				if(serviceArrayM.get(j).getRouteId().equals("-"))
				{
					serviceArrayM.remove(j);
				}
				if(serviceArrayM.get(j).getBusId().equals("-"))
				{
					serviceArrayM.remove(j);
				}
				if(serviceArrayM.get(j).getDriverId().equals("-"))
				{
					serviceArrayM.remove(j);
				}
			}
			
			//postgre
			
			for (int j = 0; j < serviceArrayP.size(); j++) {
				if(serviceArrayP.get(j).getId().equals("-"))
				{
					serviceArrayP.remove(j);
				}
				if(serviceArrayP.get(j).getTime().equals("-"))
				{
					serviceArrayP.remove(j);
				}
				if(serviceArrayP.get(j).getRouteId().equals("-"))
				{
					serviceArrayP.remove(j);
				}
				if(serviceArrayP.get(j).getBusId().equals("-"))
				{
					serviceArrayP.remove(j);
				}
				if(serviceArrayP.get(j).getDriverId().equals("-"))
				{
					serviceArrayP.remove(j);
				}
			}
	}

	}
	
	
	

