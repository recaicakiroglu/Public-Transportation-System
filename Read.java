import java.io.*;
import java.util.*;

public class Read {

	Oracle oracleObject = new Oracle();
	MySQL mysqlObject = new MySQL();
	PostgreSQL postgresqlObject = new PostgreSQL();
	public void readBus(String str) {
		try {
			File file = new File(str);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\t");

			}

			String allstr = stringBuffer.toString();
			String Oraclestr = allstr.substring(7, 228);
			String MySQLstr = allstr.substring(236, 543);
			String PostgreSQLstr = allstr.substring(556, 870);
			String alldatabase = allstr.substring(886, 978);
			oracleObject.addBustoOracle(Oraclestr);
			mysqlObject.addBustoMySQL(MySQLstr);
			postgresqlObject.addBustoPostgreSQL(PostgreSQLstr);
			oracleObject.addBustoOracle(alldatabase);
			mysqlObject.addBustoMySQL(alldatabase);
			postgresqlObject.addBustoPostgreSQL(alldatabase);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readDriver(String str) {
		try {
		File file = new File(str);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
			stringBuffer.append("\t");

		}
		String allstr = stringBuffer.toString();
		String MySQLstr = allstr.substring(6, 307);
		String Oraclestr = allstr.substring(316, 703);
		String PostgreSQLstr = allstr.substring(716, 1075);
		String alldatabase = allstr.substring(1091, 1211);
		mysqlObject.addDrivertoMySQL(MySQLstr);
		oracleObject.addDrivertoOracle(Oraclestr);
		postgresqlObject.addDrivertoPostgreSQL(PostgreSQLstr);
		oracleObject.addDrivertoOracle(alldatabase);
		mysqlObject.addDrivertoMySQL(alldatabase);
		postgresqlObject.addDrivertoPostgreSQL(alldatabase);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	
	public void readBusStop(String str) {
		try {
			File file = new File(str);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\t");
			}
			String allstr = stringBuffer.toString();
			String Oraclestr = allstr.substring(856, 2051);
			String MySQLstr = allstr.substring(2059, 3027);
			String PostgreSQLstr = allstr.substring(11, 847);
			String alldatabase = allstr.substring(3043,3175);
			mysqlObject.addBusStoptoMySQL(MySQLstr);
			oracleObject.addBusStoptoOracle(Oraclestr);
			postgresqlObject.addBusStoptoPostgreSQL(PostgreSQLstr);
			oracleObject.addBusStoptoOracle(alldatabase);
			mysqlObject.addBusStoptoMySQL(alldatabase);
			postgresqlObject.addBusStoptoPostgreSQL(alldatabase);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void readService(String str) {
		try {
			File file = new File(str);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\t");

			}

			String allstr = stringBuffer.toString();
			String Oraclestr = allstr.substring(480, 671);
			String MySQLstr = allstr.substring(317, 471);
			String PostgreSQLstr = allstr.substring(11, 309);
			String alldatabase = allstr.substring(687, 723);
			mysqlObject.addServicetoMySQL(MySQLstr);
			oracleObject.addServicetoOracle(Oraclestr);
			postgresqlObject.addServicetoPostgreSQL(PostgreSQLstr);
			oracleObject.addServicetoOracle(alldatabase);
			mysqlObject.addServicetoMySQL(alldatabase);
			postgresqlObject.addServicetoPostgreSQL(alldatabase);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public void readRoute(String str) {
		try {
			File file = new File(str);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("/r/n");

			}
            
			String allstr = stringBuffer.toString();
			String word[] = allstr.split("/r/n");
			for (int i = 1; i <= 8; i++) {
				oracleObject.addRoutetoOracle(word[i]);
			}
			for (int i = 11; i <= 15; i++) {
				mysqlObject.addRoutetoMySQL(word[i]);
			}
			for (int i = 18; i <= 24; i++) {
				postgresqlObject.addRoutetoPostgreSQL(word[i]);
			}
			for (int i = 27; i <= 28; i++) {
				postgresqlObject.addRoutetoPostgreSQL(word[i]);
				mysqlObject.addRoutetoMySQL(word[i]);
				oracleObject.addRoutetoOracle(word[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
	

