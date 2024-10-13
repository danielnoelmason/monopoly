package BackFromTheBrink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ActionArea {

	public static final AtomicInteger actionAreaCount = new AtomicInteger(0);
	private String actionAreaName;
	private int aaID;
	public List<Priority> aaPriorityList = new ArrayList<Priority>();
	private boolean ownerMonopoly;
	
	
	public ActionArea(String aaName) {
		this.actionAreaName=aaName;
		this.aaID = actionAreaCount.incrementAndGet();
		this.ownerMonopoly =false;
		
	}

	public String getActionAreaName() {
		return actionAreaName;
	}

	public int getAaID() {
		return aaID;
	}

	public boolean isOwnerMonopoly() {
		return ownerMonopoly;
	}
}
