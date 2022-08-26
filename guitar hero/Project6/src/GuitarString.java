public class GuitarString{
	private RingBuffer buffer;
	private int N;
	private int time;
	
	public GuitarString( double frequency) { 
		/*create an array of capacity N( rounded integer value of 44100 divided by
		 * the frequency we input) for sample and creates a queue with 0 assigned to all values
		 * @param frequency
		 */
		N=(int) (44100/frequency);
		buffer=new RingBuffer(N);
		time=0;
		
		for(int i=0; i <N; i++) {
			buffer.enqueue(0.0);
		}
	}	
	public GuitarString(double[]initial) {
		/* creates a buffer of values assigned as a parameter
		 * @param initial[] - an array of values we want in the RingBuffer we want to create
		 */
		N= initial.length;
		buffer= new RingBuffer(N);
		time=0;
		for(int i =0; i< N; i++) {//start for loop
			buffer.enqueue(initial[i]);
	} //end for loop
		
	}
		
	public void pluck() {
		
		for (int i=0; i<N;i++) {//start for loop
			buffer.dequeue();
			buffer.enqueue(Math.random()-0.5);
		}//end for loop
	}
	public void tic() {
		/* this function implements the karplus strong algorithm on the array*/
		time++;
		double new_freq= 0.5* 0.994*(buffer.dequeue()+ buffer.peek());
	    buffer.enqueue(new_freq);
	}
	public double sample() {
		/*Return the value of the item at the front of the ring buffer.*/
		return buffer.peek();
	} 
	
    public int time() {
    	/*returns the total number of times the karplus-strong algorithm is carried out*/
    	return time;
    }
    public static void main(String[] args) {
        GuitarString g_play= new GuitarString(400.0);
        System.out.println(g_play.sample());
        double []my_init_arr= {0.2, 0.3, 4.5, 6.8, 0.3};
        GuitarString guit_play= new GuitarString(my_init_arr);
        System.out.println(guit_play.sample());
        guit_play.tic();
        System.out.println(guit_play.sample());
        g_play.pluck();
        System.out.println(g_play.sample());
        System.out.println(guit_play.time());
        
        }
    }
		
	
	
	 
	
	
	
	
	
	
	
