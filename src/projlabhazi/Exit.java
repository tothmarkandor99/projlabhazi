package projlabhazi;

public class Exit extends Object {
	public boolean receive(Orangutan o) {
		ComInt.sendMessage("Exit.receive");ComInt.indent++;
		o.countPanda();
		return false;
	}
}
