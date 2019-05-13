package projlabhazi;

/**
 * @author Corvinusplusplus
 * Kijárat
 * Ha rálép egy orángután, kezdeményezi a pontozást az összegyûjtött pandák alapján
 */
public class Exit extends Object {
	/**
	 * Megszámoltatja a begyûjtött pandákat
	 */
	public boolean receive(Orangutan o) {
		
		o.countPanda();
		return false;
	}
}
