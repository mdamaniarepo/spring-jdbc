package spring.service;

import spring.jdbc.entities.RentalLocation;
import spring.jdbc.repositories.Repo;

public class RentalService {

	private Repo<Integer, RentalLocation> repository;

	public Repo<Integer, RentalLocation> getRepository() {
		return repository;
	}

	public void setRepository(Repo<Integer, RentalLocation> repository) {
		this.repository = repository;
	}

}
