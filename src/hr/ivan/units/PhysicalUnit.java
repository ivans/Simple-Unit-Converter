package hr.ivan.units;

public class PhysicalUnit {
	String name;

	PhysicalUnit(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}