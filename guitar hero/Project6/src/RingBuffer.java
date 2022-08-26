public class RingBuffer{
	private double my_queue[];
	private int capacity;  	
  	private int front;
  	private int rear;
	
  	
	public RingBuffer(int capacitynum) {
  		my_queue=new double[capacitynum];
		capacity=capacitynum;
		front=0;
		rear=0;
		}
	private int size() {
		/*computes size of the queue*/
		return rear-front;
		
	}
	
	public boolean isEmpty() {
		/*checks whether the queue is empty or not*/
		return rear-front == 0 ;
		
	}
	public boolean isFull() {
		/*checks whether the queue is full or not*/
		return rear-front == capacity  ;
	}
	
	
	public void enqueue(double x) {
		/*adds an element to the end of the queue unless it is full
		 * @param integer x - the element to be appended
		 */
		if (isFull()) {
			throw new IllegalStateException("your Queue is full");			
		}
		else {
			my_queue[rear % capacity] = x;// we use the modular operation to create a circular effect of the queue
			rear++;
			}	
	}
	
	public double dequeue() {
		/*removes the relative first element that was inserted into the queue
		 * return : the removed element ( it is not removed but neglected from the array)
		 * */
	if(isEmpty()) {
		throw new IllegalStateException("you have no items to dequeue");
	}
	else {
		double temp=my_queue[front%capacity];
		++front;	
		return temp;
		}
	}
	
	public double peek() {
		/*returns to us the relative first element without removing it*/
		if (isEmpty()) {
			throw new IllegalStateException("You have nothing to access");
		}
		return my_queue[front%capacity]; 
	}

	  public static void main(String[] args) {
	      int N = 10;
	      RingBuffer buffer = new RingBuffer(N);
	      System.out.println(buffer.isEmpty());
	      for (int i = 1; i <= N; i++) {
	          buffer.enqueue(i);
	      }
	      double t = buffer.dequeue();
	      System.out.println(buffer.isFull());
	      buffer.enqueue(t);
	      System.out.println(buffer.peek());
	  }
}
	
	
	

	
