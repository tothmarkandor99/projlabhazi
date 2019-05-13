package projlabhazi;

/**
 * @author Mark
 * Annak kell megvalósítani ezt az interfészt, aki fel akar iratkozni a Timer Tick eseményére
 */
public interface Steppable {
	/**
	 * Ezen keresztül értesíti a Timer a feliratkozott objektumot
	 */
	public void step();
}
