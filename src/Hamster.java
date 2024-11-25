public class Hamster extends Animal {
	
	private final String species = "Hamster";
	
	public Hamster (String name, String gender, int age){
		super(name,gender,age);
	}

	public String getSpecies() {
		return this.species;
	}

	public String adventurous() {
		return super.getName() + " loves exploring places in the home.";
	}
	
	public String running() {
		return super.getName() + " loves running on the hamster wheel.";
	}
	
}
