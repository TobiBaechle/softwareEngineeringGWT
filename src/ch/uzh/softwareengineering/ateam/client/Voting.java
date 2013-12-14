package ch.uzh.softwareengineering.ateam.client;

import java.util.Date;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Voting implements IsSerializable {
	private int id;
	private boolean national;
	private String cantonName;
	private String title;
	private int year;
	private String type;
	private double yesVotes = 0;
	private double noVotes = 0;
	private double participation = 0;
	private ArrayList<Voting> cantons; 
	
	public Voting() {
		cantons = new ArrayList<Voting>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the date
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param date the date to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the yesVotes
	 */
	public double getYesVotes() {
		return yesVotes;
	}

	/**
	 * @param yesVotes the yesVotes to set
	 */
	public void setYesVotes(double yesVotes) {
		this.yesVotes = yesVotes;
	}

	/**
	 * @return the noVotes
	 */
	public double getNoVotes() {
		return noVotes;
	}

	/**
	 * @param noVotes the noVotes to set
	 */
	public void setNoVotes(double noVotes) {
		this.noVotes = noVotes;
	}

	/**
	 * @return the participation
	 */
	public double getParticipation() {
		return participation;
	}

	/**
	 * @param participation the participation to set
	 */
	public void setParticipation(double participation) {
		this.participation = participation;
	}
	/**
	 * @return the cantons
	 */
	public ArrayList<Voting> getCantons() {
		return cantons;
	}
	
	/**
	 * @param cantons the cantons to set
	 */
	public void setCantons(ArrayList<Voting> cantons) {
		this.cantons = cantons;
	}
	
	
	
	public void addCanton(Voting canton){
		cantons.add(canton);
	}
	/**
	 * @return true if it is a national result and false if it is a cantonal result
	 */
	public boolean isNational() {
		return national;
	}
	
	/**
	 * @param national set the hierarchy
	 */
	public void setNational(boolean national) {
		this.national = national;
	}
	
	public void printCantons(){
		System.out.println("Ich bin die " + getTitle() + " und printe jetzt die Kantone...");
		if(cantons == null){
			System.out.println("no cantons");
		}
		else{
			for(int i = 0; i < cantons.size(); i++){
				System.out.println(cantons.get(i).getCantonName());
			}
		}
	}
	
	public void print(){
		System.out.println("title");
	}

	public String getCantonName() {
		return cantonName;
	}

	public void setCantonName(String cantonName) {
		this.cantonName = cantonName;
	}
	
	public void sortCantons(int left, int right){
		if (left >= right){
			return;
		}
		
		int j = partition(left, right);
		
		sortCantons(left, j -1);
		sortCantons(j + 1, right); 
	}
	
	public int partition(int left, int right){
		int j = left;
		int k = right -1;
		String pivot = cantons.get(right).getCantonName();
	
		while (j < k){
			while (cantons.get(j).getCantonName().compareTo(pivot) <= 0 && j < right){
				j++;
			}
		
			while (cantons.get(k).getCantonName().compareTo(pivot) >= 0 && k > left){
				k--;
			}
		
			if (j < k){
				Voting temp = cantons.get(j);
				cantons.set(j, cantons.get(k));
				cantons.set(k, temp);
			}
		}
	
		if (cantons.get(j).getCantonName().compareTo(pivot) > 0){
			Voting temp = cantons.get(j);
			cantons.set(j, cantons.get(right));
			cantons.set(right, temp);
		}
		
		return j; 
	}
}
