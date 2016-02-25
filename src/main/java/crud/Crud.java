package crud;

public interface Crud<T, ID> {

	public <S extends T> S save(S entity);
	public Iterable<T> read(ID primaryKey);
	public void delete(T entity);
	
}
