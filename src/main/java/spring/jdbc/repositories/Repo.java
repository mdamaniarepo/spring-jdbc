package spring.jdbc.repositories;

public interface Repo<ID, T> {
	
	public boolean insert(T t);
	
	public boolean update(T t);
	
	public boolean delete(T t);
	
	public T findById(ID id);

}
