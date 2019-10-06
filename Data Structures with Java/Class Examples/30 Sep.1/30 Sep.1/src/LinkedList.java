
public class LinkedList {
	private Node head;
	private int count;
	
	public LinkedList() {
		head = null;
		count = 0;
	}
	
	public void addToHead(Integer data) {
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNext(head);
		
		head = newNode;
		count++;
	}
	
	public void addToTail(Integer data) {
		if (count == 0) {
			addToHead(data);
		} else {
			Node newNode = new Node();
			newNode.setData(data);
			Node tmp = head;
			while(tmp != null) {
				if (tmp.getNext() == null) {
					// tmp is the last Node in the chain
					tmp.setNext(newNode);
					count++;
					return;
				}
				tmp = tmp.getNext();
			}
		}
	}
	
	public Integer deleteFromHead() {
		if (count == 0) {
			return null;
		}
		Integer rtn = head.getData();
		head = head.getNext();
		count--;
		
		return rtn;
	}
	
	public Integer deleteFromTail() {
		if (count == 0) {
			return null;
		} else {
			Node cur = head;
			Node prev = null;
			
			while (cur != null) {
				
				if (cur.getNext() == null) {
					// this is the last Node in the list
					Integer rtn = cur.getData();
					prev.setNext(null);
					count--;
					return  rtn;
				}
				prev = cur;
				cur = cur.getNext();
			}
			
			return null;
		}
 	}
	
	private Node internalSearch(Integer data) {
		if (count == 0) {
			return null;
		}
		
		Node tmp = head;
		while (tmp != null) {
			if (tmp.getData().equals(data)) {
				return tmp;
			}
			tmp = tmp.getNext();
		}
		
		// getting here no data was found
		return null;
	}
	
	public void deleteAfter(Integer data) {
		if (count == 0) {
			return;
		}
		
		Node tmp = head;
		while (tmp != null) {
			if (tmp.getData().equals(data)) {
				if (tmp.getNext() == null) {
					// there is no next to delete
					return;
				}
				tmp.setNext(tmp.getNext().getNext());
				count--;
				return;
			}
			tmp = tmp.getNext();
		}
		
		return;
	}
	
	public void insertAfter(Integer data, Integer dataToInsert) {
		if (count == 0) {
			return;
		}
		
		Node tmp = head;
		while (tmp != null) {
			if (tmp.getData().equals(data)) {
				Node newNode = new Node();
				newNode.setData(dataToInsert);
				
				newNode.setNext(tmp.getNext());
				tmp.setNext(newNode);
				count++;
				return;
			}
			tmp = tmp.getNext();
		}
		
		return;
	}
	
	public void deleteBefore(Integer data) {
		if (count == 0) {
			return;
		}
		
		Node cur = head;
		while (cur != null) {
			Node curNext = cur.getNext();
			if (curNext == null) {
				return;
			}
			Node curNextNext = curNext.getNext();
			if (curNextNext == null) {
				return;
			}
			if (curNextNext.getData().equals(data)) {
				cur.setNext(curNext.getNext()); 
				return;
			}
			
			// Special case the head
			if (curNext.getData().equals(data)) {
				deleteFromHead();
				return;
			}
			
			cur = cur.getNext();
		}
	}
	
	public void addBefore(Integer data, Integer dataToAdd) {
		
		if (count == 0) {
			return;
		}
		
		Node prev = null;
		Node cur = head;
		while (cur != null) {
			if (cur.getData().equals(data)) {
				if (prev == null) {
					addToHead(dataToAdd);
					return;
				}
				
				Node newNode = new Node();
				newNode.setData(dataToAdd);
				newNode.setNext(cur);
				prev.setNext(newNode);
				count++;
			}
			
			prev = cur;
			cur = cur.getNext();
		}
	}
	
	public void clear() {
		head = null;
		count = 0;
		
		//while (deleteFromHead() != null);
	}
	
	public boolean search(Integer data) {
		if (internalSearch(data) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String rtn = "";
		
		if (count == 0) {
			rtn += "<Empty>";
		} else {
			Node tmp = head;
			while (tmp != null) {
				rtn += "<" + tmp.getData() + "> ";
				tmp = tmp.getNext();
			}
		}
		
		return rtn;
	}

}
