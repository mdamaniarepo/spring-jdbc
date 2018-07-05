package spring.jdbc.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Applictaion {

	public static void main(String[] args) {

		String sql = "insert into rental_location(name, address1, address2, city, state, postal_code) "
				+ "values(?,?,?,?,?,?)";

		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"application-context.xml");
				Connection connection = applicationContext.getBean("datasource", DataSource.class).getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, "Amyra");
			statement.setString(2, "Bren Avalon");
			statement.setString(3, "Karthik Nagar");
			statement.setString(4, "Bangalore");
			statement.setString(5, "Karnataka");
			statement.setString(6, "560066");
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
