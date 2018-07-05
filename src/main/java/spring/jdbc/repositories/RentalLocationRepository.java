package spring.jdbc.repositories;


import java.util.List;

import spring.jdbc.entities.RentalLocation;

public interface RentalLocationRepository extends Repo<Integer, RentalLocation> {
	
	public List<RentalLocation> findByState(String state);

}
