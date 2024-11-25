public class Monster extends Animal{
	private final String species = "Monster";
	
	public Monster (String name, String gender, int age) {
		super(name,gender,age);
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public String adventurous() {
		return super.getName() + " loves exploring abandoned places.";
	}
	
	public String running() {
		return super.getName() + " loves chasing after people";
	}
	
	public String playing() {
		return super.getName() + " loves to play games like Hide-in-Seek.";
	}
	
	
}
