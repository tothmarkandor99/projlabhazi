package projlabhazi;

public class Exit extends Object {
	public boolean receive(Orangutan o) {
		
		o.countPanda();
		return false;
	}
}
