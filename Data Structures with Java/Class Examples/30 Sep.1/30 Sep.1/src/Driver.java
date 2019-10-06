
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		LinkedList list = new LinkedList();
		
		System.out.println(list);
		list.addToHead(23);
		list.addToHead(33);
		list.addToHead(43);
		System.out.println(list);
		
		System.out.println("Adding to tail");
		list.addToTail(22);
		System.out.println(list);
		
		System.out.println(list.search(23));
		System.out.println(list.search(24));
		
		System.out.println("Delete tail"); 
		System.out.println(list.deleteFromTail());
		System.out.println(list);
		list.insertAfter(33, 111);
		System.out.println(list);
		
		list.deleteAfter(33);
		System.out.println(list);
		
		list.deleteAfter(23);
		System.out.println(list);
		
		list.deleteBefore(33);
		System.out.println(list);
		
		list.addBefore(33, 111);
		System.out.println(list);
		
		list.addBefore(23, 222);
		System.out.println(list);
	}

}
