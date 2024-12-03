public class Hamster extends Animal {
	
	private static final String SPECIES = "Hamster";
	private String url;


	public Hamster (String name, String gender, int age, boolean[] flags, String url){
		super(name,gender,age, flags);
		this.url = url;
	}

	public String getSpecies() {
		return Hamster.SPECIES;
	}

	@Override
	public String adventurous() {
		return super.getName() + " " + (this.getFlags()[0] ? "loves" : "does not like" ) + " exploring places in the home.";
	}

	@Override
	public String running() {
		return super.getName() + " " +(this.getFlags()[7] ? "loves" : "does not like") + " running on the hamster wheel.";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
