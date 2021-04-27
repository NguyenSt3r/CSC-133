package A3Prj;

public interface ICollection<E> {
	public void add(E element);
	public IIterator<E> getIterator();
}
