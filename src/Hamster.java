public class Hamster extends Animal {
	
	private static final String SPECIES = "Hamster";
	
	public Hamster (String name, String gender, int age, boolean[] flags){
		super(name,gender,age, flags);
	}

	public String getSpecies() {
		return Hamster.SPECIES;
	}

	@Override
	public String adventurous() {
		return super.getName() + " " + (this.getFlags()[0] ? "loves" : "dose not like" ) + " exploring places in the home.";
	}

	@Override
	public String running() {
		return super.getName() + " " +(this.getFlags()[7] ? "loves" : "dose not like") + " running on the hamster wheel.";
	}
	
}
