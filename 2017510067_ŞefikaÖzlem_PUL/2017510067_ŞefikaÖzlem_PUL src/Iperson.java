
public interface Iperson {
	String Display();
	String toString();
	void DeleteMembership(int key) throws QueueEmpty;
	
}
