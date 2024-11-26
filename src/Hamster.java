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
		return super.getName() + " loves exploring places in the home.";
	}

	@Override
	public String running() {
		return super.getName() + " loves running on the hamster wheel.";
	}
	
}
