
public class LockerManager {

	private int maxLockerCount;
	private Locker []lockers;
	private int currentLockerCount;
	
	public LockerManager(int count) {
		maxLockerCount = count;
		Locker.setupSystem(count);
		lockers = new Locker[count];
	}
	
	public int getMaxLockersAvailable() {
		return maxLockerCount;
	}
	
	public Locker getLocker() {
		if (Locker.getLockersAvailable() > 0) {
			Locker loc = Locker.getInstance();
			lockers[currentLockerCount++] = loc;
			return loc;
		}
		
		// Getting here means we are out of lockers, allocate more
		Locker []newLockers = new Locker[lockers.length*2];
		maxLockerCount = newLockers.length;
		for (int i = 0; i < lockers.length; i++) {
			newLockers[i] = lockers[i];
		}
		Locker.setupSystem(newLockers.length-lockers.length);
		lockers = newLockers;
		
		Locker loc = Locker.getInstance();
		lockers[currentLockerCount++] = loc;
		return loc;
	}
	
	public void removeLocker(Locker l) {
		if (l.isAllocated() ) {
			for (int i = 0; i < lockers.length; i++) {
				if (lockers[i] == l) {
					// This one
					currentLockerCount--;
					lockers[i] = lockers[currentLockerCount];
					lockers[currentLockerCount] = null;
					Locker.incrementLockersAvailable();
				}
			}
		}
	}
	
	
}
