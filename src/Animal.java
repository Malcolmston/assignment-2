
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
	public String adventurous() {
		return this.name + " " + (this.flags[0] ? "likes" : "dose not like") + " going on advetures.";
	}

	public String baths() {
		return this.name + " " + (this.flags[1] ? "likes" : "dose not like") + " taking baths.";
	}

	public String cars() {
		return this.name + " " +(this.flags[2] ? "likes" : "dose not like") + " going on car rides.";
	}

	public String cosplay() {
		return this.name + " " + (this.flags[3] ? "likes" : "dose not like") + " to cosplay.";
	}

	public String eating() {
		return this.name + " " + (this.flags[4] ? "likes" : "dose not like") + " eating.";
	}

	public String energy() {
		return this.name + " " + (this.flags[5] ? "has" : "dose not have") + " lots of energy.";
	}

	public String friendly() {
		return this.name + " is" + (this.flags[6] ? " " : " not ") + "very friendly.";
	}

	public String running() {
		return this.name + " " +(this.flags[7] ? "likes" : "dose not like") + " to run.";
	}

	public String sleeping() {
		return this.name + " " + (this.flags[8] ? "likes" : "dose not like") + " to sleep.";
	}

	public String petting() {
		return this.name + " " + (this.flags[9] ? "likes" : "dose not like") + " to be pet.";
	}

	public String playing() {
		return this.name + " " + (this.flags[10] ? "likes" : "dose not like") + " to play.";
	}

	public String walks() {
		return this.name + " " + (this.flags[11] ? "likes" : "dose not like") + " to go on walks.";
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
