import java.io.*;
import java.util.*;
public class Writer {
	
public static void listAll(int lineNum, BufferedWriter writer, List<Bus> busArrayO, List<Bus> busArrayM, List<Bus> busArrayP,
             List<Driver> driverArrayO, List<Driver> driverArrayM, List<Driver> driverArrayP, List<BusStop> busstopArrayO, List<BusStop> busstopArrayM,
             List<BusStop> busstopArrayP, List<Route> routeArrayO,List<Route> routeArrayM, List<Route> routeArrayP,
             List<Service> serviceArrayO, List<Service> serviceArrayM,List<Service> serviceArrayP) throws IOException{
             int please = lineNum;
             if(please == 1){
 writer.write("COMMAND "+please+":LIST_ALL\n");
             }
             else{
                     writer.write("\nCOMMAND "+please+":LIST_ALL\n");
             }
 writer.write("Oracle Bus Information\n");
 for(int i=0;i<busArrayO.size();i++){
     writer.write("ID:"+busArrayO.get(i).getId()+" Plate:"+busArrayO.get(i).getPlate()+" Brand:"+busArrayO.get(i).getBrand()
                     +" Model:"+busArrayO.get(i).getModel()+" Year of Manufacture:"+busArrayO.get(i).getYear()+"\n");
 }

 writer.write("\nOracle Driver Information\n");
 for(int i=0;i<driverArrayO.size();i++){
     writer.write("ID:"+driverArrayO.get(i).getId()+" Name:"+driverArrayO.get(i).getName()+" Surname:"+driverArrayO.get(i).getSurname()
                     +" Birthdate:"+driverArrayO.get(i).getBirthdate()+" Phone:"+driverArrayO.get(i).getPhonenumber()+"\n");
 }

 writer.write("\nOracle Bus Stop Information\n");
 for(int i=0;i<busstopArrayO.size();i++){
     writer.write("ID:"+busstopArrayO.get(i).getId()+" Name:"+busstopArrayO.get(i).getName()+" Location:"+busstopArrayO.get(i).getLocation()
                     +" Capacity:"+busstopArrayO.get(i).getCapacity()+"\n");
 }


 
 writer.write("\nOracle Route Information\n");
 for(int i=0;i<routeArrayO.size();i++){
	 writer.write("ID:"+routeArrayO.get(i).getId()+" Year of Establishment:"+routeArrayO.get(i).getYear()+
                 " Bus Stops:");
 	   for(int j=0;j<routeArrayO.get(i).BusStop.size();j++){
 		   for(int c=0;c<busstopArrayO.size();c++){
 		   if(routeArrayO.get(i).BusStop.get(j).equals(busstopArrayO.get(c).getId()))
 			  writer.write((busstopArrayO.get(c).getName())+ " ");
  }
 	   }
 	   writer.write("\n");
 	   }

 writer.write("\nOracle Service Information\n");
 for(int i=0;i<serviceArrayO.size();i++){
     writer.write("ID:"+serviceArrayO.get(i).getId()+" Time of Departure:"+serviceArrayO.get(i).getTime()+
                     " Route ID:"+serviceArrayO.get(i).getRouteId()+" Bus ID:"+serviceArrayO.get(i).getBusId());
     for(int gd=0;gd<busArrayO.size();gd++){
             if(busArrayO.get(gd).getId().equals(serviceArrayO.get(i).getBusId())){
                     writer.write(" Bus Plate:"+busArrayO.get(gd).getPlate());
             }
     }
     writer.write(" Driver ID:"+serviceArrayO.get(i).getDriverId());
     for(int gd=0;gd<driverArrayO.size();gd++){
             if(driverArrayO.get(gd).getId().equals(serviceArrayO.get(i).getDriverId())){
                     writer.write(" Driver Name:"+driverArrayO.get(gd).getName());
             }
     }
     for(int gd=0;gd<driverArrayO.size();gd++){
             if(driverArrayO.get(gd).getId().equals(serviceArrayO.get(i).getDriverId())){
                     writer.write(" Driver Surname:"+driverArrayO.get(gd).getSurname());
             }
     }
             writer.write("\n");

 }
 writer.write("\nMySQL Bus Information\n");
 for(int i=0;i<busArrayM.size();i++){
     writer.write("ID:"+busArrayM.get(i).getId()+" Plate:"+busArrayM.get(i).getPlate()+" Brand:"+busArrayM.get(i).getBrand()
                     +" Model:"+busArrayM.get(i).getModel()+" Year of Manufacture:"+busArrayM.get(i).getYear()+"\n");
 }

 writer.write("\nMySQL Driver Information\n");
 for(int i=0;i<driverArrayM.size();i++){
     writer.write("ID:"+driverArrayM.get(i).getId()+" Name:"+driverArrayM.get(i).getName()+" Surname:"+driverArrayM.get(i).getSurname()
                     +" Birthdate:"+driverArrayM.get(i).getBirthdate()+" Phone:"+driverArrayM.get(i).getPhonenumber()+"\n");
 }

 writer.write("\nMySQL Bus Stop Information\n");
 for(int i=0;i<busstopArrayM.size();i++){
     writer.write("ID:"+busstopArrayM.get(i).getId()+" Name:"+busstopArrayM.get(i).getName()+" Location:"+busstopArrayM.get(i).getLocation()
                     +" Capacity:"+busstopArrayM.get(i).getCapacity()+"\n");
 }

 writer.write("\nMySQL Route Information\n");
 for(int i=0;i<routeArrayM.size();i++){
	 writer.write("ID:"+routeArrayM.get(i).getId()+" Year of Establishment:"+routeArrayM.get(i).getYear()+
                 " Bus Stops:");
 	   for(int j=0;j<routeArrayM.get(i).BusStop.size();j++){
 		   for(int c=0;c<busstopArrayM.size();c++){
 		   if(routeArrayM.get(i).BusStop.get(j).equals(busstopArrayM.get(c).getId()))
 			  writer.write((busstopArrayM.get(c).getName())+ " ");
  }
 	   }
 	   writer.write("\n");
 	   }

 writer.write("\nMySQL Service Information\n");
 for(int i=0;i<serviceArrayM.size();i++){
     writer.write("ID:"+serviceArrayM.get(i).getId()+" Time of Departure:"+serviceArrayM.get(i).getTime()+
                     " Route ID:"+serviceArrayM.get(i).getRouteId()+" Bus ID:"+serviceArrayM.get(i).getBusId());
     for(int gd=0;gd<busArrayM.size();gd++){
             if(busArrayM.get(gd).getId().equals(serviceArrayM.get(i).getBusId())){
                     writer.write(" Bus Plate:"+busArrayM.get(gd).getPlate());
             }
     }
     writer.write(" Driver ID:"+serviceArrayM.get(i).getDriverId());
     for(int gd=0;gd<driverArrayM.size();gd++){
             if(driverArrayM.get(gd).getId().equals(serviceArrayM.get(i).getDriverId())){
                     writer.write(" Driver Name:"+driverArrayM.get(gd).getName());
             }
     }
     for(int gd=0;gd<driverArrayM.size();gd++){
             if(driverArrayM.get(gd).getId().equals(serviceArrayM.get(i).getDriverId())){
                     writer.write(" Driver Surname:"+driverArrayM.get(gd).getSurname());
             }
     }
             writer.write("\n");

 }

 writer.write("\nPostgreSQL Bus Information\n");
 for(int i=0;i<busArrayP.size();i++){
     writer.write("ID:"+busArrayP.get(i).getId()+" Plate:"+busArrayP.get(i).getPlate()+" Brand:"+busArrayP.get(i).getBrand()
                     +" Model:"+busArrayP.get(i).getModel()+" Year of Manufacture:"+busArrayP.get(i).getYear()+"\n");
 }

 writer.write("\nPostgreSQL Driver Information\n");
 for(int i=0;i<driverArrayP.size();i++){
     writer.write("ID:"+driverArrayP.get(i).getId()+" Name:"+driverArrayP.get(i).getName()+" Surname:"+driverArrayP.get(i).getSurname()
                     +" Birthdate:"+driverArrayP.get(i).getBirthdate()+" Phone:"+driverArrayP.get(i).getPhonenumber()+"\n");
 }

 writer.write("\nPostgreSQL Bus Stop Information\n");
 for(int i=0;i<busstopArrayP.size();i++){
     writer.write("ID:"+busstopArrayP.get(i).getId()+" Name:"+busstopArrayP.get(i).getName()+" Location:"+busstopArrayP.get(i).getLocation()
                     +" Capacity:"+busstopArrayP.get(i).getCapacity()+"\n");
 }

  writer.write("\nPostgreSQL Route Information\n");
  for(int i=0;i<routeArrayP.size();i++){
	 writer.write("ID:"+routeArrayP.get(i).getId()+" Year of Establishment:"+routeArrayP.get(i).getYear()+
                 " Bus Stops:");
 	   for(int j=0;j<routeArrayP.get(i).BusStop.size();j++){
 		   for(int c=0;c<busstopArrayP.size();c++){
 		   if(routeArrayP.get(i).BusStop.get(j).equals(busstopArrayP.get(c).getId()))
 			  writer.write((busstopArrayP.get(c).getName())+ " ");
  }
 	   }
 	   writer.write("\n");
 	   }
 writer.write("\nPostgreSQL Service Information\n");
 for(int i=0;i<serviceArrayP.size();i++){
     writer.write("ID:"+serviceArrayP.get(i).getId()+" Time of Departure:"+serviceArrayP.get(i).getTime()+
                     " Route ID:"+serviceArrayP.get(i).getRouteId()+" Bus ID:"+serviceArrayP.get(i).getBusId());
     for(int gd=0;gd<busArrayP.size();gd++){
             if(busArrayP.get(gd).getId().equals(serviceArrayP.get(i).getBusId())){
                     writer.write(" Bus Plate:"+busArrayP.get(gd).getPlate());
             }
     }
     writer.write(" Driver ID:"+serviceArrayP.get(i).getDriverId());
     for(int gd=0;gd<driverArrayP.size();gd++){
             if(driverArrayP.get(gd).getId().equals(serviceArrayP.get(i).getDriverId())){
                     writer.write(" Driver Name:"+driverArrayP.get(gd).getName());
             }
     }
     for(int gd=0;gd<driverArrayP.size();gd++){
             if(driverArrayP.get(gd).getId().equals(serviceArrayP.get(i).getDriverId())){
                     writer.write(" Driver Surname:"+driverArrayP.get(gd).getSurname());
             }
     }
             writer.write("\n");

 }


}

public static void listAllOracle(int lineNum, BufferedWriter writer, List<Bus> busArrayO, List<Driver> driverArrayO, List<BusStop> busstopArrayO, List<Route> routeArrayO,List<Service> serviceArrayO) throws IOException{
        int please = lineNum;
writer.write("\nCOMMAND "+please+":LIST_ALL\tOracle\n");

writer.write("Oracle Bus Information\n");
for(int i=0;i<busArrayO.size();i++){
    writer.write("ID:"+busArrayO.get(i).getId()+" Plate:"+busArrayO.get(i).getPlate()+" Brand:"+busArrayO.get(i).getBrand()
                    +" Model:"+busArrayO.get(i).getModel()+" Year of Manufacture:"+busArrayO.get(i).getYear()+"\n");
}

writer.write("\nOracle Driver Information\n");
for(int i=0;i<driverArrayO.size();i++){
    writer.write("ID:"+driverArrayO.get(i).getId()+" Name:"+driverArrayO.get(i).getName()+" Surname:"+driverArrayO.get(i).getSurname()
                    +" Birthdate:"+driverArrayO.get(i).getBirthdate()+" Phone:"+driverArrayO.get(i).getPhonenumber()+"\n");
}

writer.write("\nOracle Bus Stop Information\n");
for(int i=0;i<busstopArrayO.size();i++){
    writer.write("ID:"+busstopArrayO.get(i).getId()+" Name:"+busstopArrayO.get(i).getName()+" Location:"+busstopArrayO.get(i).getLocation()
                    +" Capacity:"+busstopArrayO.get(i).getCapacity()+"\n");
}

writer.write("\nOracle Route Information\n");
for(int i=0;i<routeArrayO.size();i++){
	 writer.write("ID:"+routeArrayO.get(i).getId()+" Year of Establishment:"+routeArrayO.get(i).getYear()+
                " Bus Stops:");
	   for(int j=0;j<routeArrayO.get(i).BusStop.size();j++){
		   for(int c=0;c<busstopArrayO.size();c++){
		   if(routeArrayO.get(i).BusStop.get(j).equals(busstopArrayO.get(c).getId()))
			  writer.write((busstopArrayO.get(c).getName())+ " ");
 }
	   }
	   writer.write("\n");
	   }

writer.write("\nOracle Service Information\n");
for(int i=0;i<serviceArrayO.size();i++){
    writer.write("ID:"+serviceArrayO.get(i).getId()+" Time of Departure:"+serviceArrayO.get(i).getTime()+
                    " Route ID:"+serviceArrayO.get(i).getRouteId()+" Bus ID:"+serviceArrayO.get(i).getBusId());
    for(int gd=0;gd<busArrayO.size();gd++){
            if(busArrayO.get(gd).getId().equals(serviceArrayO.get(i).getBusId())){
                    writer.write(" Bus Plate:"+busArrayO.get(gd).getPlate());
            }
    }
    writer.write(" Driver ID:"+serviceArrayO.get(i).getDriverId());
    for(int gd=0;gd<driverArrayO.size();gd++){
            if(driverArrayO.get(gd).getId().equals(serviceArrayO.get(i).getDriverId())){
                    writer.write(" Driver Name:"+driverArrayO.get(gd).getName());
            }
    }
    for(int gd=0;gd<driverArrayO.size();gd++){
            if(driverArrayO.get(gd).getId().equals(serviceArrayO.get(i).getDriverId())){
                    writer.write(" Driver Surname:"+driverArrayO.get(gd).getSurname());
            }
    }
            writer.write("\n");

}
}

public static void listAllMySQL(int lineNum, BufferedWriter writer, List<Bus> busArrayM, List<Driver> driverArrayM, List<BusStop> busstopArrayM, List<Route> routeArrayM,List<Service> serviceArrayM) throws IOException{
        int please = lineNum;
writer.write("\nCOMMAND "+please+":LIST_ALL\tMySQL\n");

writer.write("MySQL Bus Information\n");
for(int i=0;i<busArrayM.size();i++){
        writer.write("ID:"+busArrayM.get(i).getId()+" Plate:"+busArrayM.get(i).getPlate()+" Brand:"+busArrayM.get(i).getBrand()
                        +" Model:"+busArrayM.get(i).getModel()+" Year of Manufacture:"+busArrayM.get(i).getYear()+"\n");
}

writer.write("\nMySQL Driver Information\n");
for(int i=0;i<driverArrayM.size();i++){
        writer.write("ID:"+driverArrayM.get(i).getId()+" Name:"+driverArrayM.get(i).getName()+" Surname:"+driverArrayM.get(i).getSurname()
                        +" Birthdate:"+driverArrayM.get(i).getBirthdate()+" Phone:"+driverArrayM.get(i).getPhonenumber()+"\n");
}

writer.write("\nMySQL Bus Stop Information\n");
for(int i=0;i<busstopArrayM.size();i++){
        writer.write("ID:"+busstopArrayM.get(i).getId()+" Name:"+busstopArrayM.get(i).getName()+" Location:"+busstopArrayM.get(i).getLocation()
                        +" Capacity:"+busstopArrayM.get(i).getCapacity()+"\n");
}

writer.write("\nMySQL Route Information\n");
for(int i=0;i<routeArrayM.size();i++){
	 writer.write("ID:"+routeArrayM.get(i).getId()+" Year of Establishment:"+routeArrayM.get(i).getYear()+
                " Bus Stops:");
	   for(int j=0;j<routeArrayM.get(i).BusStop.size();j++){
		   for(int c=0;c<busstopArrayM.size();c++){
		   if(routeArrayM.get(i).BusStop.get(j).equals(busstopArrayM.get(c).getId()))
			  writer.write((busstopArrayM.get(c).getName())+ " ");
 }
	   }
	   writer.write("\n");
	   }

writer.write("\nMySQL Service Information\n");
for(int i=0;i<serviceArrayM.size();i++){
        writer.write("ID:"+serviceArrayM.get(i).getId()+" Time of Departure:"+serviceArrayM.get(i).getTime()+
                        " Route ID:"+serviceArrayM.get(i).getRouteId()+" Bus ID:"+serviceArrayM.get(i).getBusId());
        for(int gd=0;gd<busArrayM.size();gd++){
                if(busArrayM.get(gd).getId().equals(serviceArrayM.get(i).getBusId())){
                        writer.write(" Bus Plate:"+busArrayM.get(gd).getPlate());
                }
        }
        writer.write(" Driver ID:"+serviceArrayM.get(i).getDriverId());
        for(int gd=0;gd<driverArrayM.size();gd++){
                if(driverArrayM.get(gd).getId().equals(serviceArrayM.get(i).getDriverId())){
                        writer.write(" Driver Name:"+driverArrayM.get(gd).getName());
                }
        }
        for(int gd=0;gd<driverArrayM.size();gd++){
                if(driverArrayM.get(gd).getId().equals(serviceArrayM.get(i).getDriverId())){
                        writer.write(" Driver Surname:"+driverArrayM.get(gd).getSurname());
                }
        }
        writer.write("\n");

}
}

public static void listAllPostgreSQL(int lineNum, BufferedWriter writer, List<Bus> busArrayP, List<Driver> driverArrayP, List<BusStop> busstopArrayP, List<Route> routeArrayP,List<Service> serviceArrayP) throws IOException{
        int please = lineNum;
writer.write("\nCOMMAND "+please+":LIST_ALL\tPostgreSQL\n");
Collections.sort(serviceArrayP);
writer.write("PostgreSQL Bus Information\n");
for(int i=0;i<busArrayP.size();i++){
writer.write("ID:"+busArrayP.get(i).getId()+" Plate:"+busArrayP.get(i).getPlate()+" Brand:"+busArrayP.get(i).getBrand()
                +" Model:"+busArrayP.get(i).getModel()+" Year of Manufacture:"+busArrayP.get(i).getYear()+"\n");
}

writer.write("\nPostgreSQL Driver Information\n");
for(int i=0;i<driverArrayP.size();i++){
writer.write("ID:"+driverArrayP.get(i).getId()+" Name:"+driverArrayP.get(i).getName()+" Surname:"+driverArrayP.get(i).getSurname()
                +" Birthdate:"+driverArrayP.get(i).getBirthdate()+" Phone:"+driverArrayP.get(i).getPhonenumber()+"\n");
}

writer.write("\nPostgreSQL Bus Stop Information\n");
for(int i=0;i<busstopArrayP.size();i++){
writer.write("ID:"+busstopArrayP.get(i).getId()+" Name:"+busstopArrayP.get(i).getName()+" Location:"+busstopArrayP.get(i).getLocation()
                +" Capacity:"+busstopArrayP.get(i).getCapacity()+"\n");
}
writer.write("\nPostgreSQL Route Information\n");
for(int i=0;i<routeArrayP.size();i++){
	 writer.write("ID:"+routeArrayP.get(i).getId()+" Year of Establishment:"+routeArrayP.get(i).getYear()+
               " Bus Stops:");
	   for(int j=0;j<routeArrayP.get(i).BusStop.size();j++){
		   for(int c=0;c<busstopArrayP.size();c++){
		   if(routeArrayP.get(i).BusStop.get(j).equals(busstopArrayP.get(c).getId()))
			  writer.write((busstopArrayP.get(c).getName())+ " ");
}
	   }
	   writer.write("\n");
	   }
writer.write("\nPostgreSQL Service Information\n");
for(int i=0;i<serviceArrayP.size();i++){
writer.write("ID:"+serviceArrayP.get(i).getId()+" Time of Departure:"+serviceArrayP.get(i).getTime()+
                " Route ID:"+serviceArrayP.get(i).getRouteId()+" Bus ID:"+serviceArrayP.get(i).getBusId());
for(int gd=0;gd<busArrayP.size();gd++){
        if(busArrayP.get(gd).getId().equals(serviceArrayP.get(i).getBusId())){
                writer.write(" Bus Plate:"+busArrayP.get(gd).getPlate());
        }
}
writer.write(" Driver ID:"+serviceArrayP.get(i).getDriverId());
for(int gd=0;gd<driverArrayP.size();gd++){
        if(driverArrayP.get(gd).getId().equals(serviceArrayP.get(i).getDriverId())){
                writer.write(" Driver Name:"+driverArrayP.get(gd).getName());
        }
}
for(int gd=0;gd<driverArrayP.size();gd++){
        if(driverArrayP.get(gd).getId().equals(serviceArrayP.get(i).getDriverId())){
                writer.write(" Driver Surname:"+driverArrayP.get(gd).getSurname());
        }
}
        writer.write("\n");

}
}

public static ArrayList<Bus> addOracleBus(List<Bus> busArrayO, String id, String plate, String brand, String model, String yom, BufferedWriter writer, int linenum) throws IOException{

writer.write("\nCOMMAND "+linenum+":ADD_BUS\tOracle\t"+id+"\t"+plate+"\t"+brand+"\t"+model+"\t"+yom+"\n");
for(int i=0;i<busArrayO.size();i++){
if(busArrayO.get(i).getId() .equals(id) || plate.equals("-") || model.equals("-") || yom.equals("-")){
        writer.write("ERROR\n");
    return (ArrayList<Bus>) busArrayO;
}
}
busArrayO.add(new Bus(id, plate, brand, model, yom));
Collections.sort(busArrayO);
writer.write("SUCCESSFULL\n");
return (ArrayList<Bus>) busArrayO;
}


public static ArrayList<Bus> addMysqlBus(List<Bus> busArrayM, String id, String plate, String brand, String model, String yom, BufferedWriter writer, int linenum) throws IOException{

writer.write("\nCOMMAND "+linenum+":ADD_BUS\tMySQL\t"+id+"\t"+plate+"\t"+brand+"\t"+model+"\t"+yom+"\n");
for(int i=0;i<busArrayM.size();i++){
if(busArrayM.get(i).getId() .equals( id) || plate.equals("-") || model.equals("-") || brand.equals("-")){
        writer.write("ERROR\n");
    return (ArrayList<Bus>) busArrayM;
}
}
busArrayM.add(new Bus(id, plate, brand, model, yom));
Collections.sort(busArrayM);
Collections.reverse(busArrayM);
writer.write("SUCCESSFULL\n");
return (ArrayList<Bus>) busArrayM;
}

public static ArrayList<Bus> addPostgresqlBus(List<Bus> busArrayP, String id, String plate, String brand, String model, String yom, BufferedWriter writer, int linenum) throws IOException{

writer.write("\nCOMMAND "+linenum+":ADD_BUS\tPostgreSQL\t"+id+"\t"+plate+"\t"+brand+"\t"+model+"\t"+yom+"\n");
for(int i=0;i<busArrayP.size();i++){
if(busArrayP.get(i).getId() .equals( id) || plate.equals("-") || yom.equals("-") || brand.equals("-")){
        writer.write("ERROR\n");
    return (ArrayList<Bus>) busArrayP;
}


}
busArrayP.add(new Bus(id, plate, brand, model, yom));
Collections.sort(busArrayP);
writer.write("SUCCESSFULL\n");
return (ArrayList<Bus>) busArrayP;
}

public static ArrayList<Driver> addOracleDriver(List<Driver> driverArrayO, String id, String name, String surname, String birthdate, String number, BufferedWriter writer, int linenum) throws IOException{

writer.write("\nCOMMAND "+linenum+":ADD_DRIVER\tOracle\t"+id+"\t"+name+"\t"+surname+"\t"+birthdate+"\t"+number+"\n");
for(int i=0;i<driverArrayO.size();i++){
if(driverArrayO.get(i).getId() .equals( id )|| name.equals("-") || surname.equals("-") || number.equals("-")){
        writer.write("ERROR\n");
    return (ArrayList<Driver>) driverArrayO;
}
}
driverArrayO.add(new Driver(id, name, surname, birthdate, number));
Collections.sort(driverArrayO);
writer.write("SUCCESSFULL\n");
return (ArrayList<Driver>) driverArrayO;
}

public static ArrayList<Driver> addMysqlDriver(List<Driver> driverArrayM, String id, String name, String surname, String birthdate, String number, BufferedWriter writer, int linenum) throws IOException{

writer.write("\nCOMMAND "+linenum+":ADD_DRIVER\tMySQL\t"+id+"\t"+name+"\t"+surname+"\t"+birthdate+"\t"+number+"\n");
for(int i=0;i<driverArrayM.size();i++){
if(driverArrayM.get(i).getId().equals(id) || name.equals("-") || surname.equals("-") || birthdate.equals("-")){
        writer.write("ERROR\n");
    return (ArrayList<Driver>) driverArrayM;
}
}
driverArrayM.add(new Driver(id, name, surname, birthdate, number));
Collections.sort(driverArrayM);
Collections.reverse(driverArrayM);
writer.write("SUCCESSFULL\n");
return (ArrayList<Driver>) driverArrayM;
}

public static ArrayList<Driver> addPostgresqlDriver(List<Driver> driverArrayP, String id, String name, String surname, String birthdate, String number, BufferedWriter writer, int linenum) throws IOException{
int int1 = Integer.parseInt(id);
writer.write("\nCOMMAND "+linenum+":ADD_DRIVER\tPostgreSQL\t"+int1+"\t"+name+"\t"+surname+"\t"+birthdate+"\t"+number+"\n");
for(int i=0;i<driverArrayP.size();i++){
if(driverArrayP.get(i).getId().equals(id) || name.equals("-") || surname.equals("-") || birthdate.equals("-") || number.equals("-")){
        writer.write("ERROR\n");
    return (ArrayList<Driver>) driverArrayP;
}
}
driverArrayP.add(new Driver(id, name, surname, birthdate, number));
Collections.sort(driverArrayP);
writer.write("SUCCESSFULL\n");
return (ArrayList<Driver>) driverArrayP;
}

public static ArrayList<BusStop> addOracleStop(List<BusStop> busstopArrayO, String id, String name, String location, String capacity, BufferedWriter writer, int linenum) throws IOException{
writer.write("\nCOMMAND "+linenum+":ADD_BUS_STOP\tOracle\t"+id+"\t"+name+"\t"+location+"\t"+capacity+"\n");
for(int i=0;i<busstopArrayO.size();i++){
if(busstopArrayO.get(i).getId() .equals( id )|| name.equals("-") || capacity.equals("-")){
        writer.write("ERROR\n");
    return (ArrayList<BusStop>) busstopArrayO;
}
}
busstopArrayO.add(new BusStop(id, name, location, capacity));
Collections.sort(busstopArrayO);
writer.write("SUCCESSFULL\n");
return (ArrayList<BusStop>) busstopArrayO;
}


public static ArrayList<BusStop> addMysqlStop(List<BusStop> busstopArrayM, String id, String name, String location, String capacity, BufferedWriter writer, int linenum) throws IOException{

writer.write("\nCOMMAND "+linenum+":ADD_BUS_STOP\tMySQL\t"+id+"\t"+name+"\t"+location+"\t"+capacity+"\n");
for(int i=0;i<busstopArrayM.size();i++){
if(busstopArrayM.get(i).getId() .equals( id) || name.equals("-") || capacity.equals("-") || location.equals("-")){
        writer.write("ERROR\n");
    return (ArrayList<BusStop>) busstopArrayM;
}
}
busstopArrayM.add(new BusStop(id, name, location, capacity));
Collections.sort(busstopArrayM);
Collections.reverse(busstopArrayM);
writer.write("SUCCESSFULL\n");
return (ArrayList<BusStop>) busstopArrayM;
}

public static ArrayList<BusStop> addPostgresqlStop(List<BusStop> busstopArrayP, String id, String name, String location, String capacity, BufferedWriter writer, int linenum) throws IOException{
writer.write("\nCOMMAND "+linenum+":ADD_BUS_STOP\tPostgreSQL\t"+id+"\t"+name+"\t"+location+"\t"+capacity+"\n");
for(int i=0;i<busstopArrayP.size();i++){
if(busstopArrayP.get(i).getId() .equals( id) || name.equals("-") || capacity.equals("-")){
        writer.write("ERROR\n");
    return (ArrayList<BusStop>) busstopArrayP;
}
}
busstopArrayP.add(new BusStop(id, name, location, capacity));
Collections.sort(busstopArrayP);
writer.write("SUCCESSFULL\n");
return (ArrayList<BusStop>) busstopArrayP;
}


public static void addOracleRoute(List<Route> routeArrayO, String id, String year, BufferedWriter writer, int linenum,String str) throws IOException{
  
	
	String piece[] = str.split("\t");
	
	if(!isAddRouteO(piece[0])){
	ArrayList <String> BusStop = new ArrayList<String>();
	
	BusStop.add(piece[2]);
	BusStop.add(piece[3]);
	BusStop.add(piece[4]);
	BusStop.add(piece[5]);
	Main.routeArrayO.add(new Route(piece[0], piece[1],BusStop));
	  writer.write("\nCOMMAND "+linenum+":ADD_ROUTE\tOracle\t"+id+"\t"+year+"\t"+piece[2]+"\t" +piece[3]+"\t" +piece[4]+"\t" +piece[5]);
	  writer.write("\n");
	  writer.write("SUCCESSFULL\n");
	  
	}
	else
	{
		  writer.write("\nCOMMAND "+linenum+":ADD_ROUTE\tOracle\t"+id+"\t"+year+"\t"+piece[2]+"\t" +piece[3]+"\t" +piece[4]+"\t" +piece[5]);
		  writer.write("\n");
		  writer.write("ERROR\n");
	}		 
	  Collections.sort(routeArrayO);
}



public static void addMysqlRoute(List<Route> routeArrayM, String id, String year, BufferedWriter writer, int linenum,String str) throws IOException{
	
	String piece[] = str.split("\t");
	
	if(!isAddRouteM(piece[0])){
	ArrayList <String> BusStop = new ArrayList<String>();
	
	BusStop.add(piece[2]);
	BusStop.add(piece[3]);
	BusStop.add(piece[4]);
	BusStop.add(piece[5]);
	BusStop.add(piece[6]);
	Main.routeArrayM.add(new Route(piece[0], piece[1],BusStop));
	  writer.write("\nCOMMAND "+linenum+":ADD_ROUTE\tMySQL\t"+id+"\t"+year+"\t"+piece[2]+"\t" +piece[3]+"\t" +piece[4]+"\t" +piece[5]+"\t" +piece[6]);
	  writer.write("\n");
	  writer.write("SUCCESSFULL\n");
	}
	else
	{
		  writer.write("\nCOMMAND "+linenum+":ADD_ROUTE\tMySQL\t"+id+"\t"+year+"\t"+piece[2]+"\t" +piece[3]+"\t" +piece[4]+"\t" +piece[5]+"\t" +piece[6]);
		  writer.write("\n");
		  writer.write("ERROR\n");
	}	
	Collections.sort(routeArrayM);
    Collections.reverse(routeArrayM);
}


public static void addPostgresqlRoute(List<Route> routeArrayP, String id, String year, BufferedWriter writer, int linenum,String str) throws IOException{
	
	String piece[] = str.split("\t");
	if(!isAddRouteP(piece[0])){
	ArrayList <String> BusStop = new ArrayList<String>();
	BusStop.add(piece[2]);
	BusStop.add(piece[3]);
	BusStop.add(piece[4]);
	BusStop.add(piece[5]);
	
	Main.routeArrayP.add(new Route(piece[0], piece[1],BusStop));
	  writer.write("\nCOMMAND "+linenum+":ADD_ROUTE\tPostgreSQL\t"+id+"\t"+year+"\t"+piece[2]+"\t" +piece[3]+"\t" +piece[4]+"\t" +piece[5]);
	  writer.write("\n");
	  writer.write("SUCCESSFULL\n");
	}
	else
	{
		  writer.write("\nCOMMAND "+linenum+":ADD_ROUTE\tPostgreSQL\t"+id+"\t"+year+"\t"+piece[2]+"\t" +piece[3]+"\t" +piece[4]+"\t" +piece[5]);
		  writer.write("\n");
		  writer.write("ERROR\n");
	}	
	 Collections.sort(routeArrayP);
}

public static List<Service> addOracleService(List<Service> serviceArrayO, String id, String tod, String routeid, String busid, String driverid,BufferedWriter writer, int linenum, List<Route> oracleRoute,
                List<Bus> busArrayO, List<Driver> driverArrayO) throws IOException
                {



writer.write("\nCOMMAND "+linenum+":ADD_SERVICE\tOracle\t"+id+"\t"+tod+"\t"+routeid+"\t"+busid+"\t"+driverid+"\n");

for(int i=0;i<serviceArrayO.size();i++){
    if(serviceArrayO.get(i).getId().equals(id) || tod.equals("-")){
        writer.write("ERROR\n");
        return (ArrayList<Service>) serviceArrayO;
    }
}

List< String > testroute = new ArrayList< String>();
List< String > testbus = new ArrayList< String>();
List< String > testdriver = new ArrayList< String>();
for(int p=0;p<oracleRoute.size();p++){
        testroute.add(oracleRoute.get(p).getId());
}
if(!testroute.contains(tod)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayO;
}
for(int p=0;p<busArrayO.size();p++){
        testbus.add(busArrayO.get(p).getId());
}
if(!testbus.contains(routeid)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayO;
}
for(int p=0;p<driverArrayO.size();p++){
        testdriver.add(driverArrayO.get(p).getId());
}
if(!testdriver.contains(busid)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayO;
}

serviceArrayO.add(new Service(id, tod, routeid, busid, driverid));
        Collections.sort(serviceArrayO);
writer.write("SUCCESSFULL\n");
        return serviceArrayO;
}


public static List<Service> addMysqlService(List<Service> serviceArrayM, String id, String tod, String routeid, String busid, String driverid,BufferedWriter writer, int linenum, List<Route> routeArrayM,
                List<Bus> busArrayM, List<Driver> driverArrayM) throws IOException
                {


writer.write("\nCOMMAND "+linenum+":ADD_SERVICE\tMySQL\t"+id+"\t"+tod+"\t"+routeid+"\t"+busid+"\t"+driverid+"\n");

for(int i=0;i<serviceArrayM.size();i++){
    if(serviceArrayM.get(i).getId() .equals( id) || tod.equals("-")){
        writer.write("ERROR\n");
        return (ArrayList<Service>) serviceArrayM;
    }
}

List< String > testroute = new ArrayList< String>();
List< String > testbus = new ArrayList< String>();
List< String > testdriver = new ArrayList< String>();
for(int p=0;p<routeArrayM.size();p++){
        testroute.add(routeArrayM.get(p).getId());
}
if(!testroute.contains(routeid)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayM;
}
for(int p=0;p<busArrayM.size();p++){
        testbus.add(busArrayM.get(p).getId());
}
if(!testbus.contains(busid)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayM;
}
for(int p=0;p<driverArrayM.size();p++){
        testdriver.add(driverArrayM.get(p).getId());
}
if(!testdriver.contains(driverid)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayM;
}

serviceArrayM.add(new Service(id, tod, routeid, busid, driverid));
        Collections.sort(serviceArrayM);
        Collections.reverse(serviceArrayM);
writer.write("SUCCESSFULL\n");
        return serviceArrayM;
}

public static List<Service> addPostgresqlService(List<Service> serviceArrayP, String id, String tod, String routeid, String busid, String driverid,BufferedWriter writer, int linenum, List<Route> routeArrayP,
                List<Bus> busArrayP, List<Driver> driverArrayP) throws IOException
                {

writer.write("\nCOMMAND "+linenum+":ADD_SERVICE\tPostgreSQL\t"+id+"\t"+tod+"\t"+routeid+"\t"+busid+"\t"+driverid+"\n");

for(int i=0;i<serviceArrayP.size();i++){
    if(serviceArrayP.get(i).getId() .equals( id) || tod.equals("-")){
        writer.write("ERROR\n");
        return (ArrayList<Service>) serviceArrayP;
    }
}

List< String > testroute = new ArrayList< String>();
List< String > testbus = new ArrayList< String>();
List< String > testdriver = new ArrayList< String>();
for(int p=0;p<routeArrayP.size();p++){
        testroute.add(routeArrayP.get(p).getId());
}
if(!testroute.contains(routeid)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayP;
}
for(int p=0;p<busArrayP.size();p++){
        testbus.add(busArrayP.get(p).getId());
}
if(!testbus.contains(busid)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayP;
}
for(int p=0;p<driverArrayP.size();p++){
        testdriver.add(driverArrayP.get(p).getId());
}
if(!testdriver.contains(driverid)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayP;
}

serviceArrayP.add(new Service(id, tod, routeid, busid, driverid));
        Collections.sort(serviceArrayP);
writer.write("SUCCESSFULL\n");
        return serviceArrayP;
}

public static List<Bus> deleteOracleBus(List<Bus> busArrayO, List<Service> serviceArrayO, String id, BufferedWriter writer, int linenum) throws IOException {
      
        writer.write("\nCOMMAND "+linenum+":DELETE_BUS\tOracle\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<busArrayO.size();p++){
        testbus.add(busArrayO.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Bus>) busArrayO;
}
        for(int i=0;i<busArrayO.size();i++){
                if(busArrayO.get(i).getId() .equals( id)){       
                       
                        for(int sj=0;sj<serviceArrayO.size();sj++){
                                if(id .equals( serviceArrayO.get(sj).getBusId())){
                                                serviceArrayO.remove(sj);
                                        }
                                }
                       
                        busArrayO.remove(i);
                }
        }
       
        writer.write("SUCCESSFULL\n");
        return busArrayO;
}

public static List<Bus> deleteMysqlBus(List<Bus> busArrayM,List<Service> serviceArrayM, String id, BufferedWriter writer, int linenum) throws IOException {
       
        writer.write("\nCOMMAND "+linenum+":DELETE_BUS\tMySQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<busArrayM.size();p++){
        testbus.add(busArrayM.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Bus>) busArrayM;
}
        for(int i=0;i<busArrayM.size();i++){
                if(busArrayM.get(i).getId() .equals( id)){
                        for(int sj=0;sj<serviceArrayM.size();sj++){
                                if(id .equals( serviceArrayM.get(sj).getBusId())){
                                                serviceArrayM.remove(sj);
                                        }
                                }
                        busArrayM.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return busArrayM;
}

public static List<Bus> deletePostgresqlBus(List<Bus> busArrayP,List<Service> serviceArrayP, String id, BufferedWriter writer, int linenum) throws IOException {
       
        writer.write("\nCOMMAND "+linenum+":DELETE_BUS\tPostgreSQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<busArrayP.size();p++){
        testbus.add(busArrayP.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Bus>) busArrayP;
}
        for(int i=0;i<busArrayP.size();i++){
                if(busArrayP.get(i).getId().equals(id)){
                        for(int sj=0;sj<serviceArrayP.size();sj++){
                                if(id .equals( serviceArrayP.get(sj).getBusId())){
                                                serviceArrayP.remove(sj);
                                        }
                                }
                        busArrayP.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return busArrayP;
}

public static List<Driver> deleteOracleDriver(List<Driver> driverArrayO,List<Service> serviceArrayO, String id, BufferedWriter writer, int linenum) throws IOException {
      
        writer.write("\nCOMMAND "+linenum+":DELETE_DRIVER\tOracle\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<driverArrayO.size();p++){
        testbus.add(driverArrayO.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Driver>) driverArrayO;
}
        for(int i=0;i<driverArrayO.size();i++){
                if(driverArrayO.get(i).getId().equals(id)){
                        for(int sj=0;sj<serviceArrayO.size();sj++){
                                if(serviceArrayO.get(sj).getDriverId().equals(id)){
                                	serviceArrayO.remove(sj);
                                        }
                                }
                        driverArrayO.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return driverArrayO;
}

public static List<Driver> deleteMysqlDriver(List<Driver> driverArrayM,List<Service> serviceArrayM, String id, BufferedWriter writer, int linenum) throws IOException {
      
        writer.write("\nCOMMAND "+linenum+":DELETE_DRIVER\tMySQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<driverArrayM.size();p++){
        testbus.add(driverArrayM.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Driver>) driverArrayM;
}
        for(int i=0;i<driverArrayM.size();i++){
                if(driverArrayM.get(i).getId().equals(id)){
                        for(int sj=0;sj<serviceArrayM.size();sj++){
                                if(serviceArrayM.get(sj).getDriverId().equals(id)){
                                                serviceArrayM.remove(sj);
                                        }
                                }
                        driverArrayM.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return driverArrayM;
}

public static List<Driver> deletePostgresqlDriver(List<Driver> driverArrayP,List<Service> serviceArrayP, String id, BufferedWriter writer, int linenum) throws IOException {
        writer.write("\nCOMMAND "+linenum+":DELETE_DRIVER\tPostgreSQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<driverArrayP.size();p++){
        testbus.add(driverArrayP.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Driver>) driverArrayP;
}
        for(int i=0;i<driverArrayP.size();i++){
                if(driverArrayP.get(i).getId().equals(id)){
                        for(int sj=0;sj<serviceArrayP.size();sj++){
                                if(id.equals(serviceArrayP.get(sj).getDriverId())){
                                                serviceArrayP.remove(sj);
                                        }
                                }
                        driverArrayP.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return driverArrayP;
}

public static List<BusStop> deleteOracleStop(List<BusStop> busstopArrayO,List<Route> routeArrayO, List<Service> serviceArrayO, String id, BufferedWriter writer, int linenum) throws IOException {
        
        writer.write("\nCOMMAND "+linenum+":DELETE_BUS_STOP\tOracle\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<busstopArrayO.size();p++){
        testbus.add(busstopArrayO.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<BusStop>) busstopArrayO;
}
        for(int i=0;i<busstopArrayO.size();i++){
                if(busstopArrayO.get(i).getId().equals(id)){
                       
                        for(int sj=0;sj<routeArrayO.size();sj++){
                                for(int gd=0;gd<routeArrayO.get(sj).BusStop.size();gd++){
                                        if(routeArrayO.get(sj).BusStop.get(gd).equals(id)){
                                               
                                                for(int spd=0;spd<serviceArrayO.size();spd++){
                                                        if(routeArrayO.get(sj).getId().equals(serviceArrayO.get(spd).getRouteId())){
                                                                        serviceArrayO.remove(spd);
                                                                }
                                                        }
                                               
                                                routeArrayO.remove(sj);
                                        }
                                }
                        }
                        busstopArrayO.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return busstopArrayO;
}


public static List<BusStop> deleteMysqlStop(List<BusStop> busstopArrayM,List<Route> routeArrayM, List<Service> serviceArrayM, String id, BufferedWriter writer, int linenum) throws IOException {     
        writer.write("\nCOMMAND "+linenum+":DELETE_BUS_STOP\tMySQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<busstopArrayM.size();p++){
        testbus.add(busstopArrayM.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<BusStop>) busstopArrayM;
}
        for(int i=0;i<busstopArrayM.size();i++){
                if(busstopArrayM.get(i).getId().equals(id)){
                       
                        for(int sj=0;sj<routeArrayM.size();sj++){
                                for(int gd=0;gd<routeArrayM.get(sj).BusStop.size();gd++){
                                        if(routeArrayM.get(sj).BusStop.get(gd).equals(id)){
                                               
                                                for(int spd=0;spd<serviceArrayM.size();spd++){
                                                        if(routeArrayM.get(sj).getId().equals( serviceArrayM.get(spd).getRouteId())){
                                                                        serviceArrayM.remove(spd);
                                                                }
                                                        }
                                                routeArrayM.remove(sj);
                                        }
                                }
                        }
                        busstopArrayM.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return busstopArrayM;
}

public static List<BusStop> deletePostgresqlStop(List<BusStop> busstopArrayP,List<Route> routeArrayP, List<Service> serviceArrayP, String id, BufferedWriter writer, int linenum) throws IOException {
        writer.write("\nCOMMAND "+linenum+":DELETE_BUS_STOP\tPostgreSQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<busstopArrayP.size();p++){
        testbus.add(busstopArrayP.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<BusStop>) busstopArrayP;
}
        for(int i=0;i<busstopArrayP.size();i++){
                if(busstopArrayP.get(i).getId().equals(id)){
                        for(int sj=0;sj<routeArrayP.size();sj++){
                                for(int gd=0;gd<routeArrayP.get(sj).BusStop.size();gd++){
                                        if(id.equals(routeArrayP.get(sj).BusStop.get(gd))){
                                                for(int spd=0;spd<serviceArrayP.size();spd++){
                                                        if(routeArrayP.get(sj).getId().equals(serviceArrayP.get(spd).getRouteId())){
                                                                        serviceArrayP.remove(spd);
                                                                }
                                                        }
                                                routeArrayP.remove(sj);
                                        }
                                }
                        }
                        busstopArrayP.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return busstopArrayP;
}

public static List<Route> deleteOracleRoute(List<Route> routeArrayO,List<Service> serviceArrayO, String id, BufferedWriter writer, int linenum) throws IOException {
             writer.write("\nCOMMAND "+linenum+":DELETE_ROUTE\tOracle\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<routeArrayO.size();p++){
        testbus.add(routeArrayO.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Route>) routeArrayO;
}
        for(int i=0;i<routeArrayO.size();i++){
                if(routeArrayO.get(i).getId().equals(id)){
                        for(int sj=0;sj<serviceArrayO.size();sj++){
                                if(serviceArrayO.get(sj).getRouteId().equals(id)){
                                                serviceArrayO.remove(sj);
                                        }
                                }
                        routeArrayO.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return routeArrayO;
}


public static List<Route> deleteMysqlRoute(List<Route> routeArrayM,List<Service> serviceArrayM, String id, BufferedWriter writer, int linenum) throws IOException {
        
        writer.write("\nCOMMAND "+linenum+":DELETE_ROUTE\tMySQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<routeArrayM.size();p++){
        testbus.add(routeArrayM.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Route>) routeArrayM;
}
        for(int i=0;i<routeArrayM.size();i++){
                if(routeArrayM.get(i).getId().equals(serviceArrayM)){
                        for(int sj=0;sj<serviceArrayM.size();sj++){
                                if(serviceArrayM.get(sj).getRouteId().equals(id)){
                                                serviceArrayM.remove(sj);
                                        }
                                }
                        routeArrayM.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return routeArrayM;
}

public static List<Route> deletePostgresqlRoute(List<Route> routeArrayP,List<Service> serviceArrayP, String id, BufferedWriter writer, int linenum) throws IOException {
       
        writer.write("\nCOMMAND "+linenum+":DELETE_ROUTE\tPostgreSQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<routeArrayP.size();p++){
        testbus.add(routeArrayP.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Route>) routeArrayP;
}
        for(int i=0;i<routeArrayP.size();i++){
                if(routeArrayP.get(i).getId().equals(id)){
                        for(int sj=0;sj<serviceArrayP.size();sj++){
                                if(serviceArrayP.get(sj).getRouteId().equals(id)){
                                                serviceArrayP.remove(sj);
                                        }
                                }
                        routeArrayP.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return routeArrayP;
}


public static List<Service> deleteOracleService(List<Service> serviceArrayO,String id, BufferedWriter writer, int linenum) throws IOException {
       
        writer.write("\nCOMMAND "+linenum+":DELETE_SERVICE\tOracle\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<serviceArrayO.size();p++){
        testbus.add(serviceArrayO.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayO;
}
        for(int i=0;i<serviceArrayO.size();i++){
                if(serviceArrayO.get(i).getId().equals(id)){
                        serviceArrayO.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return serviceArrayO;
}

public static List<Service> deleteMysqlService(List<Service> serviceArrayM,String id, BufferedWriter writer, int linenum) throws IOException {
        writer.write("\nCOMMAND "+linenum+":DELETE_SERVICE\tMySQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<serviceArrayM.size();p++){
        testbus.add(serviceArrayM.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayM;
}
        for(int i=0;i<serviceArrayM.size();i++){
                if(serviceArrayM.get(i).getId().equals(id)){
                        serviceArrayM.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return serviceArrayM;
}

public static List<Service> deletePostgresqlService(List<Service> serviceArrayP,String id, BufferedWriter writer, int linenum) throws IOException {
      
        writer.write("\nCOMMAND "+linenum+":DELETE_SERVICE\tPostgreSQL\t"+id+"\n");
        List< String > testbus = new ArrayList< String>();
        for(int p=0;p<serviceArrayP.size();p++){
        testbus.add(serviceArrayP.get(p).getId());
}
if(!testbus.contains(id)){
writer.write("ERROR\n");
return (ArrayList<Service>) serviceArrayP;
}
        for(int i=0;i<serviceArrayP.size();i++){
                if(serviceArrayP.get(i).getId().equals(id)){
                        serviceArrayP.remove(i);
                }
        }
        writer.write("SUCCESSFULL\n");
        return serviceArrayP;
}


public static void listOracleRoutes(List<Route> routeArrayO, String id,BufferedWriter writer, int linenum) throws IOException {
      
        writer.write("\nCOMMAND "+linenum+":LIST_ROUTES_CONTAINING_BUS_STOP\tOracle\t"+id+"\n");
                List< String > testroute = new ArrayList< String>();
        for(int p=0;p<routeArrayO.size();p++){
                for(int sj=0;sj<routeArrayO.get(p).BusStop.size();sj++){
                        testroute.add(routeArrayO.get(p).BusStop.get(sj));
                }
        }
        if(!testroute.contains(id)){
        writer.write("NO RESULTS FOUND\n");
        }
        for(int i=0;i<routeArrayO.size();i++){
                for(int sj=0;sj<routeArrayO.get(i).BusStop.size();sj++){
                        if(routeArrayO.get(i).BusStop.get(sj).equals(id)){
                                writer.write("ID:"+routeArrayO.get(i).getId()+" Year of Establishment:"+routeArrayO.get(i).getYear()+"\n");
                        }
                }
        }
}


public static void listMysqlRoutes(List<Route> routeArrayM, String id,BufferedWriter writer, int linenum) throws IOException {
        
        writer.write("\nCOMMAND "+linenum+":LIST_ROUTES_CONTAINING_BUS_STOP\tMySQL\t"+id+"\n");
                List< String > testroute = new ArrayList< String>();
        for(int p=0;p<routeArrayM.size();p++){
                for(int sj=0;sj<routeArrayM.get(p).BusStop.size();sj++){
                        testroute.add(routeArrayM.get(p).BusStop.get(sj));
                }
        }
        if(!testroute.contains(id)){
        writer.write("NO RESULTS FOUND\n");
        }
        for(int i=0;i<routeArrayM.size();i++){
                for(int sj=0;sj<routeArrayM.get(i).BusStop.size();sj++){
                        if(routeArrayM.get(i).BusStop.get(sj).equals(id)){
                                writer.write("ID:"+routeArrayM.get(i).getId()+" Year of Establishment:"+routeArrayM.get(i).getYear()+"\n");
                        }
                }
        }
}

public static void listPostgresqlRoutes(List<Route> routeArrayP, String id,BufferedWriter writer, int linenum) throws IOException {
        writer.write("\nCOMMAND "+linenum+":LIST_ROUTES_CONTAINING_BUS_STOP\tOracle\t"+id+"\n");
                List< String > testroute = new ArrayList< String>();
        for(int p=0;p<routeArrayP.size();p++){
                for(int sj=0;sj<routeArrayP.get(p).BusStop.size();sj++){
                        testroute.add(routeArrayP.get(p).BusStop.get(sj));
                }
        }
        if(!testroute.contains(id)){
        writer.write("NO RESULTS FOUND\n");
        }
        for(int i=0;i<routeArrayP.size();i++){
                for(int sj=0;sj<routeArrayP.get(i).BusStop.size();sj++){
                        if(routeArrayP.get(i).BusStop.get(sj).equals(id)){
                                writer.write("ID:"+routeArrayP.get(i).getId()+" Year of Establishment:"+routeArrayP.get(i).getYear()+"\n");
                        }
                }
        }
}

public static void listOracleDrivers(List<Service> serviceArrayO,List<Driver> driverArrayO, String id,BufferedWriter writer, int linenum) throws IOException {
        
        writer.write("\nCOMMAND "+linenum+":LIST_DRIVERS_OF_BUS\tOracle\t"+id+"\n");
        List< String > testdrivers = new ArrayList< String>();
for(int p=0;p<serviceArrayO.size();p++){
        testdrivers.add(serviceArrayO.get(p).getBusId());
}
if(!testdrivers.contains(id)){
writer.write("NO RESULTS FOUND\n");
}

for(int sj=0;sj<serviceArrayO.size();sj++){
        if(id==serviceArrayO.get(sj).getBusId()){
                writer.write("ID:"+serviceArrayO.get(sj).getDriverId());
                for(int r=0;r<driverArrayO.size();r++){
                        if(serviceArrayO.get(sj).getDriverId().equals(driverArrayO.get(r).getId())){
                                writer.write(" Driver Name:"+driverArrayO.get(r).getName()+" Driver Surname:"+driverArrayO.get(r).getSurname()+"\n");
                        }
                }
        }
}

}

public static void listMysqlDrivers(List<Service> serviceArrayM,List<Driver> driverArrayM, String id,BufferedWriter writer, int linenum) throws IOException {
        
        writer.write("\nCOMMAND "+linenum+":LIST_DRIVERS_OF_BUS\tMySQL\t"+id+"\n");
        List< String > testdrivers = new ArrayList< String>();
for(int p=0;p<serviceArrayM.size();p++){
        testdrivers.add(serviceArrayM.get(p).getBusId());
}
if(!testdrivers.contains(id)){
writer.write("NO RESULTS FOUND\n");
}
Collections.reverse(serviceArrayM);
for(int sj=0;sj<serviceArrayM.size();sj++){
        if(serviceArrayM.get(sj).getBusId().equals(id)){
                writer.write("ID:"+serviceArrayM.get(sj).getDriverId());
                for(int r=0;r<driverArrayM.size();r++){
                        if(serviceArrayM.get(sj).getDriverId().equals(driverArrayM.get(r).getId())){
                                writer.write(" Driver Name:"+driverArrayM.get(r).getName()+" Driver Surname:"+driverArrayM.get(r).getSurname()+"\n");
                        }
                }
        }
}

}

public static void listPostgresqlDrivers(List<Service> serviceArrayP,List<Driver> driverArrayP, String id,BufferedWriter writer, int linenum) throws IOException {
      
        writer.write("\nCOMMAND "+linenum+":LIST_DRIVERS_OF_BUS\tPostgreSQL\t"+id+"\n");
        List< String > testdrivers = new ArrayList< String>();
        Collections.reverse(serviceArrayP);
for(int p=0;p<serviceArrayP.size();p++){
        testdrivers.add(serviceArrayP.get(p).getBusId());
}
if(!testdrivers.contains(id)){
writer.write("NO RESULTS FOUND\n");
}
for(int sj=0;sj<serviceArrayP.size();sj++){
        if(serviceArrayP.get(sj).getBusId().endsWith(id)){
                writer.write("ID:"+serviceArrayP.get(sj).getDriverId());
                for(int r=0;r<driverArrayP.size();r++){
                	   if(driverArrayP.get(r).getId().equals(serviceArrayP.get(sj).getDriverId())){
                                writer.write(" Driver Name:"+driverArrayP.get(r).getName()+" Driver Surname:"+driverArrayP.get(r).getSurname()+"\n");
                        }
                }
        }
}

}

public static void listByMeanOracle(List<Service> serviceArrayO,List<Route> routeArrayO, List<BusStop> busstopArrayO, String compare, BufferedWriter writer, int linenum) throws IOException {
        int int1 = Integer.parseInt(compare);
        writer.write("\nCOMMAND "+linenum+":LIST_SERVICES_BY_MEAN_BUS_STOP_CAPACITY\tOracle\t"+int1+"\n");
        int cot = 0;
        for(int i=0;i<serviceArrayO.size();i++){
                for(int s=0;s<routeArrayO.size();s++){
                        if(serviceArrayO.get(i).getRouteId().equals(routeArrayO.get(s).getId())){
                                List< Integer > testavg = new ArrayList< Integer>();
                                for(int j=0;j<routeArrayO.get(s).BusStop.size();j++){
                                        for(int sj=0;sj<busstopArrayO.size();sj++){
                                                if(routeArrayO.get(s).BusStop.get(j).equals(busstopArrayO.get(sj).getId())){
                                                        int tester = Integer.parseInt(busstopArrayO.get(sj).getCapacity());
                                                        testavg.add(tester);   
                                                }
                                        }
                                }
                                Double Avg = calculateAverage(testavg);
                                Avg = round(Avg);
                                if(int1<=Avg){
                                        writer.write("ID:"+serviceArrayO.get(i).getId()+" Time of Departure:"+serviceArrayO.get(i).getTime()+
                                                        " Route ID:"+serviceArrayO.get(i).getRouteId()+" Route Mean Capacity:"+Avg+"\n");
                                }
                                else{
                                        cot++;
                                }
                                if(cot == serviceArrayO.size()){
                        writer.write("NO RESULTS FOUND\n");
                                }
                        }
                }
        }
}


public static void listByMeanMysql(List<Service> serviceArrayM,List<Route> routeArrayM, List<BusStop> busstopArrayM, String compare,     BufferedWriter writer, int linenum) throws IOException {
        int int1 = Integer.parseInt(compare);
        writer.write("\nCOMMAND "+linenum+":LIST_SERVICES_BY_MEAN_BUS_STOP_CAPACITY\tMySQL\t"+int1+"\n");
        int cot = 0;
Collections.reverse(serviceArrayM);
        for(int i=0;i<serviceArrayM.size();i++){
                for(int s=0;s<routeArrayM.size();s++){
                        if(serviceArrayM.get(i).getRouteId().equals(routeArrayM.get(s).getId())){
                                List< Integer > testavg = new ArrayList< Integer>();
                                for(int j=0;j<routeArrayM.get(s).BusStop.size();j++){
                                        for(int sj=0;sj<busstopArrayM.size();sj++){
                                                if(routeArrayM.get(s).BusStop.get(j).equals(busstopArrayM.get(sj).getId())){
                                                        int tester = Integer.parseInt(busstopArrayM.get(sj).getCapacity());
                                                        testavg.add(tester);   
                                                }
                                        }
                                }
                                Double Avg = calculateAverage(testavg);
                                Avg = round(Avg);
                                if(int1<=Avg){
                                        writer.write("ID:"+serviceArrayM.get(i).getId()+" Time of Departure:"+serviceArrayM.get(i).getTime()+
                                                        " Route ID:"+serviceArrayM.get(i).getRouteId()+" Route Mean Capacity:"+Avg+"\n");
                                }
                                else{
                                        cot++;
                                }
                                if(cot == serviceArrayM.size()){
                        writer.write("NO RESULTS FOUND\n");
                                }
                        }
                }
        }
}

public static void listByMeanPostgresql(List<Service> serviceArrayP,List<Route> routeArrayP, List<BusStop> busstopArrayP, String compare, BufferedWriter writer, int linenum) throws IOException {
        int int1 = Integer.parseInt(compare);
        writer.write("\nCOMMAND "+linenum+":LIST_SERVICES_BY_MEAN_BUS_STOP_CAPACITY\tPostgreSQL\t"+int1+"\n");
        int cot = 0;
        for(int i=0;i<serviceArrayP.size();i++){
                for(int s=0;s<routeArrayP.size();s++){
                        if(serviceArrayP.get(i).getRouteId().equals(routeArrayP.get(s).getId())){
                                List< Integer > testavg = new ArrayList< Integer>();
                                for(int j=0;j<routeArrayP.get(s).BusStop.size();j++){
                                        for(int sj=0;sj<busstopArrayP.size();sj++){
                                                if(routeArrayP.get(s).BusStop.get(j).equals(busstopArrayP.get(sj).getId())){
                                                        int tester = Integer.parseInt(busstopArrayP.get(sj).getCapacity());
                                                        testavg.add(tester);   
                                                }
                                        }
                                }
                                Double Avg = calculateAverage(testavg);
                                Avg = round(Avg);
                                if(int1<=Avg){
                                        writer.write("ID:"+serviceArrayP.get(i).getId()+" Time of Departure:"+serviceArrayP.get(i).getTime()+
                                                        " Route ID:"+serviceArrayP.get(i).getRouteId()+" Route Mean Capacity:"+Avg+"\n");
                                }
                                else{
                                        cot++;
                                }
                                if(cot == serviceArrayP.size()){
                        writer.write("NO RESULTS FOUND\n");
                                }
                        }
                }
        }
}

public static void listByServiceStopsOracle(List<Service> serviceArrayO,        List<Route> routeArrayO, List<BusStop> busstopArrayO, String stop1,
                String stop2, BufferedWriter writer, int linenum) throws IOException {
        int cot=0;
        writer.write("\nCOMMAND "+linenum+":LIST_SERVICES_BY_BUS_STOPS\tOracle\t"+stop1+"\t"+stop2+"\n");
        for(int i=0;i<serviceArrayO.size();i++){
                for(int j=0;j<routeArrayO.size();j++){
                        if(serviceArrayO.get(i).getRouteId().equals(routeArrayO.get(j).getId())){
                                List< String > testroute = new ArrayList< String>();
                                for(int k=0;k<routeArrayO.get(j).BusStop.size();k++){
                                        testroute.add(routeArrayO.get(j).BusStop.get(k));
                                }
                                int a = testroute.indexOf(stop1);
                                int b = testroute.indexOf(stop2);
                                if(testroute.contains(stop1) && testroute.contains(stop2) && b>a){
                                        writer.write("ID:"+serviceArrayO.get(i).getId()+" Time of Departure:"+serviceArrayO.get(i).getTime()+" Route ID:"+serviceArrayO.get(i).getRouteId()+"\n");
                                }
                                else{
                                        cot++;
                                }
                                if(cot == serviceArrayO.size()){
                        writer.write("NO RESULTS FOUND\n");
                                }
                        }
                }
        }
       
}


public static void listByServiceStopsMysql(List<Service> serviceArrayM, List<Route> routeArrayM, List<BusStop> busstopArrayM, String stop1,
                String stop2, BufferedWriter writer, int linenum) throws IOException {      
        int cot = 0;
        Collections.reverse(serviceArrayM);
        writer.write("\nCOMMAND "+linenum+":LIST_SERVICES_BY_BUS_STOPS\tMySQL\t"+stop1+"\t"+stop2+"\n");
        for(int i=0;i<serviceArrayM.size();i++){
                for(int j=0;j<routeArrayM.size();j++){
                        if(serviceArrayM.get(i).getRouteId().equals(routeArrayM.get(j).getId())){
                                List< String > testroute = new ArrayList< String>();
                                for(int k=0;k<routeArrayM.get(j).BusStop.size();k++){
                                        testroute.add(routeArrayM.get(j).BusStop.get(k));
                                }
                                int a = testroute.indexOf(stop1);
                                int b = testroute.indexOf(stop2);
                                if(testroute.contains(stop1) && testroute.contains(stop2)&& b>a){
                                        writer.write("ID:"+serviceArrayM.get(i).getId()+" Time of Departure:"+serviceArrayM.get(i).getTime()+" Route ID:"+serviceArrayM.get(i).getRouteId()+"\n");
                                }
                                else{
                        cot++;
                                }
                                if(cot == serviceArrayM.size()){
                        writer.write("NO RESULTS FOUND\n");
                                }
                               
                        }
                }
        }
       
}

public static void listByServiceStopsPostgresql(List<Service> serviceArrayP,    List<Route> routeArrayP, List<BusStop> busstopArrayP, String stop1,
                String stop2, BufferedWriter writer, int linenum) throws IOException {
        int cot = 0;
        writer.write("\nCOMMAND "+linenum+":LIST_SERVICES_BY_BUS_STOPS\tPostgreSQL\t"+stop1+"\t"+stop2+"\n");
        for(int i=0;i<serviceArrayP.size();i++){
                for(int j=0;j<routeArrayP.size();j++){
                        if(serviceArrayP.get(i).getRouteId()==routeArrayP.get(j).getId()){
                                List< String > testroute = new ArrayList< String>();
                                for(int k=0;k<routeArrayP.get(j).BusStop.size();k++){
                                        testroute.add(routeArrayP.get(j).BusStop.get(k));
                                }
                                int a = testroute.indexOf(stop1);
                                int b = testroute.indexOf(stop2);
                                if(testroute.contains(stop1) && testroute.contains(stop2)&& b>a){
                                        writer.write("ID:"+serviceArrayP.get(i).getId()+" Time of Departure:"+serviceArrayP.get(i).getTime()+" Route ID:"+serviceArrayP.get(i).getRouteId()+"\n");
                                }
                                else{
                        cot++;
                                }
                                if(cot == serviceArrayP.size()){
                        writer.write("NO RESULTS FOUND\n");
                                }
                               
                        }
                }
        }
       
}
public static boolean isAddRouteO(String str)
{
	for ( int i = 0; i < Main.routeArrayO.size(); i++)
	{
		if(str.equals(Main.routeArrayO.get(i).getId()))
			return true;
	}
	return false;
}
public static boolean isAddRouteM(String str)
{
	for ( int i = 0; i < Main.routeArrayM.size(); i++)
	{
		if(str.equals(Main.routeArrayM.get(i).getId()))
			return true;
	}
	return false;
}
public static boolean isAddRouteP(String str)
{
	for ( int i = 0; i < Main.routeArrayP.size(); i++)
	{
		if(str.equals(Main.routeArrayP.get(i).getId()))
			return true;
	}
	return false;
}

public static double calculateAverage(List <Integer> callAvg) {
    if (callAvg == null || callAvg.isEmpty()) {
        return 0;
    }

    double sum = 0;
    for (Integer mark : callAvg) {
        sum += mark;
    }

    return sum / callAvg.size();
}

public static double round(double value){
double roundval = Math.round(value*10)/10.00;
return roundval;
}


}


