package spring.jdbc.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.jdbc.entities.RentalLocation;

@Repository
public class RentalLocationRepositoryImpl implements RentalLocationRepository {

	private JdbcTemplate template;

	private static final String COLUMNS = "name, address1, address2, city, state, postal_code";

	private static final String INSERT_QUERY = "INSERT INTO RENTAL_LOCATION (" + COLUMNS
			+ ") values (?, ?, ?, ?, ?, ?)";

	private static final String FIND_BY_ID = "SELECT RENTAL_LOCATION_ID, " + COLUMNS
			+ " FROM RENTAL_LOCATION WHERE RENTAL_LOCATION_ID = ?";

	private static final String FIND_BY_STATE_QUERY = "SELECT RENTAL_LOCATION_ID, " + COLUMNS
			+ " FROM RENTAL_LOCATION WHERE STATE = ?";

	private static final String DELETE_QUERY = "DELETE FROM RENTAL_LOCATION WHERE RENTAL_LOCATION_ID = ?";

	private final static String UPDATE_QUERY = "update rental_location"
			+ " set name = ?, address1 = ?, address2 = ?, city = ?, state = ?, postal_code = ?"
			+ " where rental_location_id = ?";

	private RowMapper<RentalLocation> rowMapper = (ResultSet rs, int rownum) -> {
		RentalLocation rentalLocation = new RentalLocation();
		rentalLocation.setRentalLocationId(rs.getInt("rental_location_id"));
		rentalLocation.setName(rs.getString("name"));
		rentalLocation.setAddress1(rs.getString("address1"));
		rentalLocation.setAddress2(rs.getString("address2"));
		rentalLocation.setCity(rs.getString("city"));
		rentalLocation.setState(rs.getString("state"));
		rentalLocation.setPostalCode(rs.getString("postal_code"));
		return rentalLocation;
	};

	@Autowired
	public RentalLocationRepositoryImpl(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean insert(RentalLocation entity) {
		template.update(INSERT_QUERY, entity.getName(), entity.getAddress1(), entity.getAddress2(), entity.getCity(),
				entity.getState(), entity.getPostalCode());
		return true;
	}

	@Override
	public boolean update(RentalLocation entity) {
		int count = template.update(UPDATE_QUERY,
				new Object[] { entity.getName(), entity.getAddress1(), entity.getAddress2(), entity.getCity(),
						entity.getState(), entity.getPostalCode(), entity.getRentalLocationId() });
		return count == 1;
	}

	@Override
	public boolean delete(RentalLocation entity) {
		int count = template.update(DELETE_QUERY, new Object[] { entity.getRentalLocationId() });
		return count == 1;
	}

	@Override
	public RentalLocation findById(Integer id) {
		return template.queryForObject(FIND_BY_ID, new Object[] { id }, rowMapper);
	}

	@Override
	public List<RentalLocation> findByState(String state) {
		return template.query(FIND_BY_STATE_QUERY, new Object[] { state }, rowMapper);
	}

}
