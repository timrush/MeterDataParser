package com.dsd.db;

import static com.dsd.db.Tables.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.dsd.db.tables.records.DeviceRecord;
import com.dsd.parser.SSNExportDocument.MeterData.IntervalReadData.Interval.Reading;
import com.dsd.parser.SSNExportDocument.MeterData.RegisterData.RegisterRead.Tier.Register;

public class MeterDeviceStore {

	public static int REG_SUMMATION = 1;
	public static int REG_MAX_DEMAND = 2;
	public static int REG_CUMMULATIVE_DEMAND = 3;

	
	Connection dbconn = null;

	public Connection getConnection() throws SQLException {
        String url1 = "jdbc:mysql://localhost:3306/MeterDataStore?autoReconnect=true&useSSL=false";
        String user = "trush";
        String password = "crashin1";

        dbconn = DriverManager.getConnection(url1, user, password);
        if (dbconn != null) {
            System.out.println("Connected to the database");
        }
        return dbconn;
	}
	
	public void cleanup() throws SQLException{
		dbconn.close();
	}
	
	public void insertDevice(String serialNumber, String utilDeviceID, String macID){
        
		DSLContext create = DSL.using(dbconn, SQLDialect.MYSQL);

		Result<Record> result = create.select()
					.from(DEVICE)
					.where(DEVICE.SERIALNUMBER.eq(serialNumber))
					.fetch();
       
        if(result.isEmpty()){
    	    System.out.println("Adding: " + utilDeviceID);
    	    create.insertInto(DEVICE,
    	    	   DEVICE.TYPE, DEVICE.SERIALNUMBER, DEVICE.MACID, DEVICE.UTILITYDEVICEID)
    	          .values(1, serialNumber, macID, utilDeviceID)
    	          .execute();
        	
        }
        else{
        	System.out.println("Device: " + utilDeviceID +" already exists");
        }
	}

	public void insertRegisterRead(String readTime, String serialNumber, Integer touTier, Register register){
		DSLContext create = DSL.using(dbconn, SQLDialect.MYSQL);
    
		try {
		    
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		    OffsetDateTime parsedDate = OffsetDateTime.parse(readTime, formatter);
		    Timestamp timestamp= new Timestamp(1000 * parsedDate.toEpochSecond());
		
				if( register.getSummationUOM() != null){
				    create.insertInto(REGISTERREADS, 
				    		REGISTERREADS.READTIME, REGISTERREADS.REGISTERNUM, REGISTERREADS.READTYPE, REGISTERREADS.READVALUE, 
				    		REGISTERREADS.SERIALNUMBER, REGISTERREADS.TOUTIER, REGISTERREADS.UOM)
			 	          .values(timestamp, register.getNumber(), REG_SUMMATION, register.getSummation(), serialNumber, touTier, register.getSummationUOM())
			 	          .execute();
					}
				else if( register.getMaximumDemandTime() != null){	// Maximum Demand Read
				    OffsetDateTime parsedDateDemand = OffsetDateTime.parse(register.getMaximumDemandTime(), formatter);
				    Timestamp timestampDemand= new Timestamp(1000 * parsedDateDemand.toEpochSecond());
				    
					create.insertInto(REGISTERREADS, 
				    		REGISTERREADS.READTIME, REGISTERREADS.REGISTERNUM, REGISTERREADS.READTYPE, REGISTERREADS.READVALUE, 
				    		REGISTERREADS.SERIALNUMBER, REGISTERREADS.TOUTIER, REGISTERREADS.UOM, REGISTERREADS.MAXDEMANDTIME)
			 	          .values(timestamp, register.getNumber(), REG_MAX_DEMAND, register.getMaximumDemand(), serialNumber, touTier, register.getDemandUOM(), timestampDemand)
			 	          .execute();	
				}
				else{										// Cummulative Demand
					create.insertInto(REGISTERREADS, 
				    		REGISTERREADS.READTIME, REGISTERREADS.REGISTERNUM, REGISTERREADS.READTYPE, REGISTERREADS.READVALUE, 
				    		REGISTERREADS.SERIALNUMBER, REGISTERREADS.TOUTIER, REGISTERREADS.UOM)
			 	          .values(timestamp, register.getNumber(), REG_CUMMULATIVE_DEMAND, register.getCumulativeDemand(), serialNumber, touTier, register.getDemandUOM())
			 	          .execute();	
			}
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}

	}
	public void insertIntervalRead(String serialNumber, String readTime, Integer blockSequence, Integer intervalSequence, Reading intervalRead){
		
		DSLContext create = DSL.using(dbconn, SQLDialect.MYSQL);
    
		try {
		    
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		    OffsetDateTime parsedDate = OffsetDateTime.parse(readTime, formatter);
		    Timestamp timestamp= new Timestamp(1000 * parsedDate.toEpochSecond());
		
			create.insertInto(INTERVALREADS, 
					INTERVALREADS.READTIME, INTERVALREADS.BLOCKSEQUENCENUMBER, INTERVALREADS.INTERVALSEQUENCENUMBER, INTERVALREADS.CHANNELNUMBER, 
					INTERVALREADS.SERIALNUMBER, INTERVALREADS.READVALUE, INTERVALREADS.UOM, INTERVALREADS.RAWVALUE)
	 	          .values(timestamp, blockSequence, intervalSequence, intervalRead.getChannel(), serialNumber, intervalRead.getValue(), 
	 	        		  intervalRead.getUOM(), intervalRead.getRawValue())
	 	          .execute();	
			
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	public void insertEvent(String serialNumber, String eventTime, String eventName, String eventText){
		
		DSLContext create = DSL.using(dbconn, SQLDialect.MYSQL);
    
		try {
		    
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		    OffsetDateTime parsedDate = OffsetDateTime.parse(eventTime, formatter);
		    Timestamp timestamp= new Timestamp(1000 * parsedDate.toEpochSecond());
		    
			create.insertInto(DEVICEEVENTS, 
					DEVICEEVENTS.DEVICEID, DEVICEEVENTS.EVENTTIME, DEVICEEVENTS.EVENTNAME, DEVICEEVENTS.EVENTTEXT)
	 	          .values(serialNumber, timestamp, eventName, eventText)
	 	          .execute();	
		
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	public DeviceRecord getDevice(String serialNumber){
		DSLContext create = DSL.using(dbconn, SQLDialect.MYSQL);

		DeviceRecord result = (DeviceRecord) create.select()
					.from(DEVICE)
					.where(DEVICE.SERIALNUMBER.eq(serialNumber))
					.fetchOne();
       
        if(result == null){
        	return null;
        }
        else{
        	return result;
        }
		
		
	}
}
