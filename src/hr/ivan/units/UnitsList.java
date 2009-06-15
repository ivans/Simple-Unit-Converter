package hr.ivan.units;

import java.util.ArrayList;

public class UnitsList extends ArrayList<PhysicalUnit> {

	private static final long serialVersionUID = 2373724524393990549L;

	private static UnitsList instance;

	public static final UnitsList getInstance() {
		if (instance == null) {
			instance = new UnitsList();
		}
		return instance;
	}

	private UnitsList() {
		this.add(new PhysicalUnit("Lenght"));
		this.add(new PhysicalUnit("Time"));
		this.add(new PhysicalUnit("Mass"));
	}

}
