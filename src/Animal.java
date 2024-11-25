
public abstract class Animal {
	private String name;
	String fullPath;
	boolean[] flags = new boolean[11];

	String gender;
	int age;

	Animal(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

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
	
	public String adventurous() {
		return this.name + "likes going on advetures.";
	}
	public String baths() {
		return this.name + "likes taking baths.";
	}
	public String cars() {
		return this.name + "likes going on car rides.";
	}
	public String cosplay() {
		return this.name + "likes to cosplay.";
	}
	public String eating() {
		return this.name + "likes eating.";
	}
	public String energy() {
		return this.name + "has lots of energy.";
	}
	public String friendly() {
    		return this.name + "is very friendly.";
    	}
 	public String running() {
    		return this.name + "loves to run.";
    	}
    	public String sleeping() {
    		return this.name + "loves to sleep.";
    	}
    	public String petting() {
    		return this.name + "loves to be pet.";
    	}
    	public String playing() {
    		return this.name + "loves to play.";
    	}
    	public String walks() {
    		return this.name + "loves to go on walks.";
	
	
}
