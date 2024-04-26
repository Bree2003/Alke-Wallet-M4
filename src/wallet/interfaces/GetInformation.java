package wallet.interfaces;

public interface GetInformation<T> {

	// return the object
	public T findByID(int id);
	// return all the objects in the list
	public void findAll();
	// create and inject data
	public void injectData();
	// return the size of the list
	public int size();
}
