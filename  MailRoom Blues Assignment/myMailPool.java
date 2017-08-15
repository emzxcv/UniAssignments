package strategies;

import java.util.ArrayList;
import java.util.List;

import automail.MailItem;
import automail.IMailPool;

public class myMailPool implements IMailPool {

	public List<MailItem> mailItemsLo;
	public List<MailItem> mailItemsMed;
	public List<MailItem> mailItemsHi;
	public static List<String> arr;

	public myMailPool() {
		mailItemsLo = new ArrayList<MailItem>();
		mailItemsMed = new ArrayList<MailItem>();
		mailItemsHi = new ArrayList<MailItem>();
		arr = new ArrayList<String>();
	}

	//Using a switch to sort priority into 3 different arrayLists
	@Override
	public void addToPool(MailItem mailItem) {
		String priority = mailItem.getPriorityLevel();
		String id = mailItem.getId();

		switch (priority) {
		case "LOW":
			// System.out.println("add low");
			//Handling the already sent mail exception
			if (!arr.contains(id)) {
				arr.add(id);
				mailItemsLo.add(mailItem);
			}
			break;

		case "MEDIUM":
			// System.out.println("add med");
			if (!arr.contains(id)) {
				arr.add(id);
				mailItemsMed.add(mailItem);
			}
			break;

		case "HIGH":
			// System.out.println("add hi");
			if (!arr.contains(id)) {
				arr.add(id);
				mailItemsHi.add(mailItem);
			}
			break;

		default:
			System.out.println("not adding");
			break;
		}
	}

	public boolean isEmptyPool() {
		return mailItemsLo.isEmpty() && mailItemsMed.isEmpty() && mailItemsHi.isEmpty();
	}

	//Retrieve the first element from mailItemsHi if its not empty
	//Repeats until it is empty and the next ArrayList will be used then
	public MailItem get() {
		if (!mailItemsHi.isEmpty()) {
			return mailItemsHi.get(0);
		} else if (!mailItemsMed.isEmpty()) {
			return mailItemsMed.get(0);
		} else
			return mailItemsLo.get(0);
	}
	//Removes the first element from mailItemsHi if its not empty
	//Repeats until it is empty and the next ArrayList will be used then
	public void remove() {
		if (!mailItemsHi.isEmpty()) {
			mailItemsHi.remove(0);
		} else if (!mailItemsMed.isEmpty()) {
			mailItemsMed.remove(0);
		} else
			mailItemsLo.remove(0);
	}
}
