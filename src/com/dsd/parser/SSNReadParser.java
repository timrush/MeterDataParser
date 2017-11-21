package com.dsd.parser;

import java.util.List;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.sql.*;

import com.dsd.db.MeterDeviceStore;
import com.dsd.parser.SSNExportDocument.MeterData;
import com.dsd.parser.SSNExportDocument.MeterData.EventData.Event;
import com.dsd.parser.SSNExportDocument.MeterData.IntervalReadData;
import com.dsd.parser.SSNExportDocument.MeterData.IntervalReadData.Interval;
import com.dsd.parser.SSNExportDocument.MeterData.IntervalReadData.Interval.Reading;
import com.dsd.parser.SSNExportDocument.MeterData.RegisterData.RegisterRead;
import com.dsd.parser.SSNExportDocument.MeterData.RegisterData.RegisterRead.Tier;
import com.dsd.parser.SSNExportDocument.MeterData.RegisterData.RegisterRead.Tier.Register;


public class SSNReadParser {

	public static void main(String[] args) {

	 try {
			
		 String[] myFiles = new String[]{	"/media/trush/ex2part/datafiles/2012intervals1.xml",
				 							"/media/trush/ex2part/datafiles/2012intervals2.xml",
				 							"/media/trush/ex2part/datafiles/2012alldata.xml", 
				 							"/media/trush/ex2part/datafiles/onereg.xml",
				 							"/media/trush/ex2part/datafiles/2012xsdorig.xml"};
		 File file = new File(myFiles[2]);
		 System.out.println("Process file: "+ file.toString());

		 JAXBContext jaxbContext = JAXBContext.newInstance(SSNExportDocument.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			SSNExportDocument xmlDoc = (SSNExportDocument) jaxbUnmarshaller.unmarshal(file);

			List<MeterData> meters = xmlDoc.getMeterData();					
			

	        try {
				MeterDeviceStore mdStore = new MeterDeviceStore();
				mdStore.getConnection();
				
	            for (MeterData m : meters) {
			       
	            	mdStore.insertDevice(m.meterName, m.utilDeviceID, m.macID);
	    			System.out.println("Processing Meter: " + m.meterName);
	            	
	    			int storeData =0;
	    			
	    			if( storeData > 0 )
	    			{
		            	if( m.getRegisterData() != null){
		            		List<RegisterRead> regReads = m.getRegisterData().getRegisterRead();
		            		for (RegisterRead rr : regReads)
		            		{
		            			List<Tier> tier = rr.tier;
		            			for (Tier t : tier)
			            		{
		            				List<Register> register = t.register;
		            				for (Register r : register)
				            		{
		            					// System.out.println("process register: " + r.getNumber());
		            					mdStore.insertRegisterRead(rr.readTime, m.meterName, t.getNumber(), r);
				            		}
			            		}
		            		}
	            		}
		            	
		            	
		            	if( m.getIntervalReadData()!=null){
				    	   // System.out.println("Meter ID: " + m.meterName + " Interval reads: " + m.getIntervalReadData().numberIntervals);
				    	   IntervalReadData intervalRD = m.getIntervalReadData();
				    	   List<Interval> interval = intervalRD.getInterval();
				    	   for ( Interval intervalInstance : interval){
			    			   
				    		   List<Reading> intervalReadings = intervalInstance.reading;
				    		   for( Reading intRead : intervalReadings){
				    			   //System.out.println("Interval: " + intervalInstance.getBlockSequenceNumber() + " " + intervalInstance.getIntervalSequenceNumber() + "Reading: " + intRead.channel + " " + intRead.value);
				    			   mdStore.insertIntervalRead(m.meterName, intervalInstance.endTime, intervalInstance.getBlockSequenceNumber(), intervalInstance.getIntervalSequenceNumber(), intRead);
				    					
				    		   }
	   			    	   }
		            	}
		            	
		            	if( m.getEventData() != null){
	   			    	   List<Event> events = m.getEventData().event;
				    	   for (Event evt : events){
				    		   System.out.println("Events: " + evt.eventName + " " + evt.value);
				    		   mdStore.insertEvent(m.meterName, evt.eventTime, evt.eventName, evt.value);
				    	   }
		            	}
	    			}
	            }
	            mdStore.cleanup();	// Close DB connection

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}

}
