
public class Node {
	private Integer data;
	private Node next;
	private Integer arrivaltime;

	public Node(Integer data) {
		this.data = data;
	}
	
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	public Integer getArrivalTime() {return arrivaltime;}
	public void setArrivalTime(Integer arrivaltime) {this.arrivaltime = arrivaltime;}
}
