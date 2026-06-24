package io.hammerhall.streamforge.domain.world;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Country {

	private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;
	private List<City> cities;

	{
		cities = new ArrayList<>();
	}

	public Country(String code, String name, String continent, int population,
			double surfaceArea, double gnp, int capital) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.population = population;
		this.capital = capital;
		this.gnp = gnp;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (code == null) {
            return other.code == null;
		} else return code.equals(other.code);
    }

	@Override
	public String toString() {
		return "Country [ name=" + name + ", population=" + population + "]";
	}

}