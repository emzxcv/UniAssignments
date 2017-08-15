package strategies;

import automail.Clock;
import automail.IMailSorter;
import automail.MailItem;
import automail.StorageTube;
import exceptions.TubeFullException;

import java.util.Comparator;


public class myMailSorter implements IMailSorter {

	myMailPool mailPool;
	MailItem mailItem;

	
	public myMailSorter(myMailPool mailPool) {
		this.mailPool = mailPool;
	}
	
	//A method to sort arrivalTime of a mailItem in ascending order
	public  void sortThis(){
		//sort in ascending order
		mailPool.mailItemsLo.sort(Comparator.comparing(MailItem::getArrivalTime));
		mailPool.mailItemsMed.sort(Comparator.comparing(MailItem::getArrivalTime));
		mailPool.mailItemsHi.sort(Comparator.comparing(MailItem::getArrivalTime));
		
		//sorting in descending order
/*		Comparator<MailItem> arrivalTimeComparator = Comparator.comparing(MailItem::getSize);
		Collections.sort(mailPool.mailItemsLo, arrivalTimeComparator.reversed());
		Collections.sort(mailPool.mailItemsMed, arrivalTimeComparator.reversed());
		Collections.sort(mailPool.mailItemsHi, arrivalTimeComparator.reversed());
*/
	}
	
	@Override
	public boolean fillStorageTube(StorageTube tube) {
		try {
			//sort the 3 arrayLists according to arrivalTime before it is added to the tube for delivery
			sortThis();
			if (!mailPool.isEmptyPool()) {
				
				/** Gets the first item from the ArrayList */
				mailItem = mailPool.get();
				/** Add the item to the tube */
				tube.addItem((MailItem) mailItem);
				/** Remove the item from the ArrayList */
				mailPool.remove();
			}
		}
		
		/**
		 * Refer to TubeFullException.java -- Usage below illustrates need to
		 * handle this exception. However you should structure your code to
		 * avoid the need to catch this exception for normal operation
		 */
		catch (TubeFullException e) {
			return true;
		}
		/**
		 * Handles the case where the last delivery time has elapsed and there
		 * are no more items to deliver.
		 */
		if (Clock.Time() > Clock.LAST_DELIVERY_TIME && mailPool.isEmptyPool() && !tube.isEmpty()) {
			return true;
		}
		return false;

	}
}
