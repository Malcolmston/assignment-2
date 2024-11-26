/**
* CMS270 Group Project
* Version 1
* Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
*
* Animal abstract class
* Purpose: To create a framework for creating Animal objects. The Animal type will be used
* to store different pets in an array together.
*/

public abstract class Animal {
	//Data Members
	private String name;
	private String fullPath;
	private boolean[] flags = new boolean[11];

	String gender;
	int age;
	
	// Constructor

	Animal(String name, String gender, int age, boolean[] flags)  {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.flags = flags;
	}

	
	// Getters and Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public boolean[] getFlags() {
		return flags;
	}

	public void setFlags(boolean[] flags) {
		this.flags = flags;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	
	// toString Methods
	public String adventurous() {
		return this.name + " likes going on advetures.";
	}

	public String baths() {
		return this.name + " likes taking baths.";
	}

	public String cars() {
		return this.name + " likes going on car rides.";
	}

	public String cosplay() {
		return this.name + " likes to cosplay.";
	}

	public String eating() {
		return this.name + " likes eating.";
	}

	public String energy() {
		return this.name + " has lots of energy.";
	}

	public String friendly() {
		return this.name + " is very friendly.";
	}

	public String running() {
		return this.name + " likes to run.";
	}

	public String sleeping() {
		return this.name + " likes to sleep.";
	}

	public String petting() {
		return this.name + " likes to be pet.";
	}

	public String playing() {
		return this.name + " likes to play.";
	}

	public String walks() {
    		return this.name + " likes to go on walks.";
	}
	
}
