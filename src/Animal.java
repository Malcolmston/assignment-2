
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CMS270 Group Project
 * 
 * @version 1.0.0
 * @authors Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
 * 
 * @purpose To create a framework for creating Animal objects. The Animal type
 *          will be used to store different pets in an array together.
 */

public abstract class Animal implements PopUpMgr {
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

	// Methods

	/**
	 * Compare the flag list between two pets
	 * 
	 * @param userPet    the user's pet
	 * @param comparePet the pet userPet is being compared against
	 * @return the number of points scored for base flag compatibility
	 */
	private static int compareFlags(Animal userPet, Animal comparePet) {
		int points = 0;
		for (int i = 0; i < userPet.getFlags().length; i++) {
			boolean[] userFlags = userPet.getFlags();
			boolean[] compareFlags = comparePet.getFlags();

			if (userFlags[i] == compareFlags[i]) {
				points += 1;
			}
		}
		return points;

	}

	/**
	 * Compare the flag list between two pets
	 * 
	 * @param a                  the first pet
	 * @param b                  the second pet
	 * @param discriminateAge    whether the user wishes to compare ages
	 * @param discriminateGender whether the user wishes to compare gender
	 * @return the number of points scored for base flag, age, type, etc...
	 *         compatibility
	 */
	private static HashMap<String, Object> compareOnePet(Animal a, Animal b, boolean discriminateAge, boolean discriminateGender) {
		int points = 0;

		// add flag points
		points += compareFlags(a, b);

		// add age points if both pets are of the same type
		if (a.getClass() == b.getClass()) {
			points += 2;
		}

		// get the difference in age and add points based on that
		if (discriminateAge) {
			int addPoints = 10;
			int ageDiff = a.getAge() - b.getAge();
			if (ageDiff < 0) {
				addPoints += ageDiff;
			} else {
				addPoints -= ageDiff;
			}
			points += addPoints;
		}

		// get the gender difference and add points based on that
		if (discriminateGender) {
			if (a.getGender().equals(b.getGender())) {
				points += 5;
			}
		}

		HashMap<String, Object> out = new HashMap<>();

		out.put("points", points);
		out.put("pet", b);

		return out;

	}

	/**
	 * Compare the flag list between two pets
	 * 
	 * @param userPet    the user's pet
	 * @param comparePet the pet userPet is being compared against
	 * @return the number of points scored for base flag compatibility
	 */
	public static ArrayList< HashMap<String, Object> > computeCompatibility(Animal userPet, boolean discriminateAge, boolean discriminateGender, ArrayList<Animal> animals) {
		ArrayList< HashMap<String, Object> > points = new ArrayList<>();
		for (int i = 0; i < animals.size(); i++) {
			points.add(compareOnePet(userPet, animals.get(i), discriminateAge, discriminateGender));
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
		return this.name + " " + (this.flags[2] ? "likes" : "does not like") + " going on car rides.";
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
		return this.name + " " + (this.flags[7] ? "likes" : "does not like") + " to run.";
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

	protected abstract String getUrl();

	@Override
    public void show() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }

}
