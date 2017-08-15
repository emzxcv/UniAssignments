package automail;

import strategies.*;

public class Automail {
	      
    public Robot robot;
    public IMailPool mailPool;
    
    Automail(IMailDelivery delivery) {
    	
    /** CHANGE NOTHING ABOVE HERE */
    	
    	/** Initialize the MailPool */
    	IMailPool simpleMailPool = new myMailPool();
    	
    	mailPool = simpleMailPool;
        /** Initialize the MailSorter */
    	IMailSorter sorter = new myMailSorter((myMailPool) simpleMailPool);
    	
    /** CHANGE NOTHING BELOW HERE */    	
    	/** Initialize robot */
    	robot = new Robot(sorter, delivery);
    }
    
}


