package com.koinex.dbFrameWork;

import java.util.Random;

import org.voltdb.VoltTable;
import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.ClientFactory;

public class DbFrameWork 
{
    public static void main( String[] args )
    {
    		ClientConfig clientConfig = null;
    		Client client = null;
    		try {
    			clientConfig = new ClientConfig();       
    			clientConfig.setTopologyChangeAware(true);
    		    client = ClientFactory.createClient(clientConfig);       
  
    		    client.createConnection("ec2-35-154-18-4.ap-south-1.compute.amazonaws.com");
    		    int i =2;
    		    final long startTime = System.currentTimeMillis();
    		    for(; i< 10000000; i ++ ) {
    		    		client.callProcedure("CUSTOMER.insert",i,givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect(),givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() );
    		    }
    		    final long endTime = System.currentTimeMillis();
    		    System.out.println("Total execution time: " + (endTime - startTime) );
    		    System.out.println("Total Customer inserted :" + i );
    		    
    		}catch(Exception e) {
    			  e.printStackTrace();
    		      System.exit(-1);
    		}
    }
    
    private static String givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {
	    	int leftLimit = 97; 
	    	int rightLimit = 122;
	    	int targetStringLength = 10;
	    Random random = new Random();
	    	StringBuilder buffer = new StringBuilder(targetStringLength);
	    	for (int i = 0; i < targetStringLength; i++) {
	    		int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
	    		buffer.append((char) randomLimitedInt);
	    	}
	    	
	    	return buffer.toString();
    	}
}
