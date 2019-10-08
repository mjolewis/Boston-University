
public class Node implements Nodetest {
	private Integer data;
	private Node next;
	
	@Override
	public Integer getData() {
		return data;
	}
	@Override
	public void setData(Integer data) {
		this.data = data;
	}
	@Override
	public Node getNext() {
		return next;
	}
	@Override
	public void setNext(Node next) {
		this.next = next;
	}
}
