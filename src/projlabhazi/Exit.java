package projlabhazi;

/**
 * @author Corvinusplusplus
 * Kij�rat
 * Ha r�l�p egy or�ngut�n, kezdem�nyezi a pontoz�st az �sszegy�jt�tt pand�k alapj�n
 */
public class Exit extends Object {
	/**
	 * Megsz�moltatja a begy�jt�tt pand�kat
	 */
	public boolean receive(Orangutan o) {
		
		o.countPanda();
		return false;
	}
}
