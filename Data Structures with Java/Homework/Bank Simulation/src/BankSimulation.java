import java.util.Random;
import java.util.Scanner;

public class BankSimulation {

	private LinkedQueue line[];
	private int count;
	private int transactionMax = 4;
	private int maxArrivalTime = 3;
	private int duration = 480;
	private int longest = 0;
	private int custCount = 0;


	// custom variable
	private int maxWaitTime = 0;

	public void setup() {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Welcome to the bank simulator");
		System.out.println();
		System.out.print("Enter number of bank tellers -> ");
		count = kbd.nextInt();
		kbd.nextLine();
		
		line = new LinkedQueue[count];
		for (int i = 0; i < line.length; i++) {
			line[i] = new LinkedQueue();
		}
	}
	
	public void run() {
		
		int nextArrivalTime;
		Random gen = new Random();

		nextArrivalTime = gen.nextInt(maxArrivalTime) + 1;
		
		for (int time = 0; time < duration; time++) {
			
			// Decrement the timers
			for (int i = 0; i < line.length; i++) {
				if (line[i].isEmpty()) {
					continue;
				} else {
					
					if (line[i].size() > longest) {
						longest = line[i].size();
					}
					
					Node n = line[i].getHeadElement();
					n.setData(n.getData()-1);

					if (n.getData() <= 0) {

						line[i].remove();

						// if to update max wait time (time = global clock. each node
						if(!line[i].isEmpty() && time-line[i].getHeadElement().getArrivalTime() > maxWaitTime)
						{
							// set max waitTime to this poor customer's wait time and move on
							maxWaitTime = time-n.getArrivalTime();
						}
					}
				}
			}
			
			if (nextArrivalTime == time) {
				custCount++;

				// calculate when the next person will show up
				nextArrivalTime = gen.nextInt(maxArrivalTime) + 1 + time;

				// find the shortest queue
				int shortest = 0;
				for (int i = 0; i < line.length; i++) {
					if (line[i].size() < line[shortest].size()) {
						shortest = i;
					}
				}

				line[shortest].add(gen.nextInt(transactionMax) + 1, time);

			}
		}
		
		// all done print out stats
		System.out.println("simulation ended");
		System.out.println("Total customers = " + custCount);
		System.out.println("Longest line was " + longest + " customers");
		System.out.println("Longest time spent in bank was " + maxWaitTime + " minutes");
	}
}
