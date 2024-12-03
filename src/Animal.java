
import javax.swing.JPanel;

 /**
 * CMS270 Group Project
 * @version 1.0.0
 * @authors Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
 * 
 * @purpose To create a framework for creating Animal objects. The Animal type will be used to store different pets in an array together.
 */

public abstract class Animal implements UserInfo {
	// Data Members
	private String name;
	private String fullPath;
	private boolean[] flags = new boolean[12];

	String gender;
	int age;

	// Constructor

	Animal(String name, String gender, int age, boolean[] flags) {
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

	//Methods
	/**
	 * Calculate compatability of two Animals by comparing their flags
	 * (also comparing age and gender, if the user wishes)
	 * @param userPet the user's pet
	 * @param animals complete list of animals in the database
	 * @param discriminateAge whether the user wishes to compare ages
	 * @param discriminateGender whether the user wishes to compare gender
	 * @return the number of points scored for compatibility
	 */
	public static ArrayList<Integer> computeCompatibility(Animal userPet, ArrayList<Animal> animals, boolean discriminateAge, boolean discriminateGender) {
		int points;
		for(int i = 0; i < animals.size(); i++) {
			Animal compare = animals.get(i);
			points = compareFlags(userPet, compare);
			if (userPet.getType() == compare.getType()) {
				points += 2;
			}	
			if (discriminateAge) {
				int addPoints = 10;
				int ageDiff = userPet.getAge() - compare.getAge();
				if (ageDiff < 0) {
					addPoints += ageDiff;
				}
				else {
					addPoints -= ageDiff;
				}
				points += addPoints;
			}
			if (discriminateGender) {
				if(userPet.getGender() == compare.getGender()) {
					points += 5;
				}	
			}	
		}	
			
	}
	
	/**
	 * Compare the flag list between two pets
	 * @param userPet the user's pet
	 * @param comparePet the pet userPet is being compared against
	 * @return the number of points scored for base flag compatibility
	 */
	public int compareFlags(Animal userPet, Animal comparePet) {
		int points = 0;
		for(int i = 0; i < userPet.getFlags().length(); i++) {
			int[] userFlags = userPet.getFlags();
			int[] compareFlags = comparePet.getFlags();

			if(userFlags[i] == compareFlags[i]) {
				points += 1;
		}	
		return points;
	}

	
	public String adventurous() {
		return this.name + " " + (this.flags[0] ? "likes" : "does not like") + " going on advetures.";
	}

	public String baths() {
		return this.name + " " + (this.flags[1] ? "likes" : "does not like") + " taking baths.";
	}

	public String cars() {
		return this.name + " " +(this.flags[2] ? "likes" : "does not like") + " going on car rides.";
	}

	public String cosplay() {
		return this.name + " " + (this.flags[3] ? "likes" : "does not like") + " to cosplay.";
	}

	public String eating() {
		return this.name + " " + (this.flags[4] ? "likes" : "does not like") + " eating.";
	}

	public String energy() {
		return this.name + " " + (this.flags[5] ? "has" : "does not like") + " lots of energy.";
	}

	public String friendly() {
		return this.name + " is" + (this.flags[6] ? " " : " not ") + "very friendly.";
	}

	public String running() {
		return this.name + " " +(this.flags[7] ? "likes" : "does not like") + " to run.";
	}

	public String sleeping() {
		return this.name + " " + (this.flags[8] ? "likes" : "does not like") + " to sleep.";
	}

	public String petting() {
		return this.name + " " + (this.flags[9] ? "likes" : "does not like") + " to be pet.";
	}

	public String playing() {
		return this.name + " " + (this.flags[10] ? "likes" : "does not like") + " to play.";
	}

	public String walks() {
		return this.name + " " + (this.flags[11] ? "likes" : "does not like") + " to go on walks.";
	}

	@Override
	public void changeName(String newName) {
		this.name = newName;
	}

	@Override
	public JPanel makeProfile() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'makeProfile'");
	}
}
