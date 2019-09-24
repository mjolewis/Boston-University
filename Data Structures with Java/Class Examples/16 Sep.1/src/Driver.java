
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		System.out.println("Welcome to the Locker Manager");
		
		LockerManager man = new LockerManager(16);
		
		Locker y = man.getLocker();
		Locker z = man.getLocker();
		Locker l = man.getLocker();
		l.setLockerCombination("Hi There");
		
		System.out.println(Locker.getLockersAvailable());
		
		man.removeLocker(z);
		
		l.closeLocker();
		l.lockLocker();
		l.openLocker();
		
		l.unlockLocker("Hi There");
		l.openLocker();
		
		for (int i = 0; i < 25; i++) {
			Locker a = man.getLocker();
		}
		
		
		
		System.out.println("Number of lockers is: " + Locker.getLockersAvailable());
	}

}
