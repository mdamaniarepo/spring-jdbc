package spring.jdbc.app;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.jdbc.entities.RentalLocation;
import spring.jdbc.repositories.RentalLocationRepository;

public class TestJDBCTemplate {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {

			RentalLocationRepository rentalLocationRepository = context.getBean(RentalLocationRepository.class);

			// Select
			RentalLocation rentalLocation = rentalLocationRepository.findById(5);
			System.out.printf("Rental Location for id: %s is - %s \n", rentalLocation.getRentalLocationId(),
					rentalLocation.toString());

			// update
			rentalLocation.setName("Mayank Damania");
			rentalLocation.setPostalCode("560037");
			System.out.println("Updated RentalLocation Entity: "
					+ ((rentalLocationRepository.update(rentalLocation)) ? "successfully" : "unsuccessfully")
					+ ", for Rental Location : " + rentalLocation.getRentalLocationId());

			// findbyState - when find returns more than one item

			List<RentalLocation> rentalLocations = rentalLocationRepository.findByState("Karnataka");
			System.out.println("Finding rental locations for state");
			rentalLocations.forEach(System.out::println);

			// delete
			System.out.println("Deleted rental location for Id (3) : "
					+ (rentalLocationRepository.delete(rentalLocationRepository.findById(3)) ? "successfully"
							: "unsuccessfully"));

		}
	}

}
