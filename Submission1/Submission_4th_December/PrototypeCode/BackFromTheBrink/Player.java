package BackFromTheBrink;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private int balance;
	private List<Priority> prioritiesOwned;
	public int currentPos;

	public int playerID;
	static int nextPlayerID = 0;

	public Player(String name) {
		this.name = name;
		this.setPrioritiesOwned(new ArrayList<Priority>());
		this.setBalance(1500);
		this.currentPos = 0;

		this.playerID = nextPlayerID;
		nextPlayerID++;
	}

	public void toPrint() {

		System.out.println("\nPlayer Name = " + name);

		System.out.println("Player Balance = " + getBalance());

		if(getPrioritiesOwned().size()>0)
		System.out.println("\t\t\t~Squares Owned~");
		else
			System.out.println("\t\t\t~No Prioritys~");
		
		for (int i = 0; getPrioritiesOwned() != null && i < getPrioritiesOwned().size(); ++i)
			System.out.println("Priority Name: " + getPrioritiesOwned().get(i).getPriorityName() + "\tPriority Value = £"
					+ getPrioritiesOwned().get(i).getPriorityValue() + "\tPriority Rent = £"
					+ getPrioritiesOwned().get(i).getPriorityContributionCost());

	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void passGo() {
		setBalance(getBalance() + 200);
		System.out.println("Passed GO, Collect 200");

	}

	public List<Priority> getPrioritiesOwned() {
		return prioritiesOwned;
	}

	public void setPrioritiesOwned(List<Priority> prioritiesOwned) {
		this.prioritiesOwned = prioritiesOwned;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getNewBalance() {
		// TODO Auto-generated method stub
		return (getName().toUpperCase() + "'s new balance is "+getBalance());
	}

	public void addToBalance(int i) {
		// TODO Auto-generated method stub
		
	}

	public void takeAwayBalance(int i) {
		
		this.balance-=i;
		
	}
}
