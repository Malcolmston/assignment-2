public class Monster extends Animal{
	private static final String SPECIES = "Monster";
	private String url;
	
	public Monster (String name, String gender, int age, boolean[] flags, String url) {
		super(name,gender,age,flags);
		this.url = url;
	}
	
	public String getSpecies() {
		return Monster.SPECIES;
	}
	
	@Override
	public String adventurous() {
		return super.getName() + " "+ (this.getFlags()[0] ? "loves" : "does not like") + " exploring abandoned places.";
	}
	@Override
	public String running() {
		return super.getName() + " " + (this.getFlags()[7] ? "loves" : "does not like") + " chasing after people";
	}
	@Override
	public String playing() {
		return super.getName() + " " + (this.getFlags()[10] ? "loves" : "does not like") +" to play games like Hide-in-Seek.";
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
