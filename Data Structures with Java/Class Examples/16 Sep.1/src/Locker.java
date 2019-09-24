
public class Locker {
	
	private static int lockersAvailable;
	private static boolean isSetup = false;
	
	private String combination;
	private boolean isAllocated;
	private boolean isLocked;
	private boolean isClosed;
	
	private Locker() {
		combination = null;
	}
	
	public static void setupSystem(int lockerCount) {
		lockersAvailable = lockerCount;
		isSetup = true;
	}
 	
	
	public static Locker getInstance() {
		
		if (!isSetup) {
			System.out.println("System is not setup.  Please call setupSystem(int lockerCount)");
			return null;
		}
		
		if (lockersAvailable > 0) {
			lockersAvailable--;
			Locker tmp = new Locker();
			tmp.isAllocated = true;
			return tmp;
		}
		
		return null;
	}
	
	public boolean isAllocated() {
		return isAllocated;
	}

	public void setAllocated(boolean isAllocated) {
		this.isAllocated = isAllocated;
	}

	public boolean setLockerCombination(String combination) {
		if (this.combination != null) {
			System.out.println("Error combination already set");
			return false;
		} else {
			System.out.println("Combination set");
			this.combination = combination;
			return true;
		}
	}
	
	public boolean lockLocker() {
		if (combination == null) {
			System.out.println("Unable to lock locker, no combination present");
			return false;
		}
		System.out.println("Locker is locked");
		isLocked = true;
		return true;
	}
	
	public boolean unlockLocker(String combination) {
		if (this.combination == null) {
			isLocked = false;
			System.out.println("Locker unlocked (no password)");
			return true;
		}
		
		if (combination.equals(this.combination)) {
			isLocked = false;
			System.out.println("Locker unlocked");
			return true;
		}
		
		System.out.println("Can't open locker, invalid combination");
		return false;
	}
	
	public void closeLocker() {
		isClosed = true;
		System.out.println("Locker is closed");
	}
	
	public boolean openLocker() {
		if (combination == null) {
			isClosed = false;
			System.out.println("Locker is open (no password)");
			return true;
		}
		
		if (isLocked == false) {
			System.out.println("Locker is open");
			return true;
		}
		
		System.out.println("Cannot open, Locker is locked");
		return false;
	}
	
	public void printLockersAvailable() {
		System.out.println(lockersAvailable + " Lockers available");
	}

	public static int getLockersAvailable() {
		return lockersAvailable;
	}

	public static void decrementLockersAvailable() {
		if (lockersAvailable > 0) 
			lockersAvailable--;
	}

	public static void incrementLockersAvailable() { 
		lockersAvailable++;
	}

}
