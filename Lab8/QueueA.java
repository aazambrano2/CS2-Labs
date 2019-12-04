
public class QueueA<T extends Object> {
	/*	ATTRIBUTES: *********************************************
	 *  o	Head (an integer index)
	 * 	o	Tail (an integer index)
	 * 	o	Size
	 * 	o	Array of integers
	 */
	private int head;
	private int tail;
	private int size;
	private T[] queue;

	/* CONSTRUCTOR: *********************************************/
	public QueueA(int num) {
		queue = (T[]) new Object[num]; //new T[num];
		size = 0;
		head = -1;
		tail = 0;
	}
	
	/* GETTERS: *************************************************/
	/**
     * TODO 8
     * getSize
	 * @return the size
	 */
	public int getSize(){
		return size;
	}

	/* OTHER METHODS: *******************************************
	 *	o	TODO 9: Enqueue: takes data and adds it to the queue if it is not full
	 * 	o	TODO 10: Dequeue: method that removes the head of the queue, if the queue is not empty, and returns this element
	 *	o	TODO 11: Peek: returns the head element of the queue (without removing it)
	 *	o	TODO 12: Clear: empties the queue
	 *	o	TODO 13: isEmpty: returns true if the queue is empty, false otherwise
	 * 	o	TODO 14: isFull: returns true if the queue is full, false awotherwise
	 */
	public void enqueue(T data) {
        // You code goes here
		if(isEmpty()){ // if enqueue to empty queue
			head = 0;
			tail = 0;
			queue[tail] = data;
			size++;
		}
		else if(!isFull()){  //if the queue is not full
			tail = (tail + 1) % queue.length; //tail position updated
			queue[tail] = data;
			size++;
		}
		else{
			System.out.print("Queue is full. Cannot enqueue");
		}
	}

	public T dequeue() {
        // You code goes here
		T data;
		//empty
		if(isEmpty()){ //empty queue
			System.out.println("Cannot dequeue an empty queue");
			return null;
		}

		if(head == tail){    //one element in queue
			data = queue[head];
			clear();         //queue set to empty queue
			return data;
		}

		data = queue[head]; //non empty queue
		head = (head + 1) % queue.length;    //head position updated
		size --;
		return data;
	}

	public void clear() {
        // You code goes here
		head = -1; //reset head location
		tail = -1; //reset tail location
		size = 0;  //reset size
	}
	
	public T peek() {
        // You code goes here
		if(head == -1){
			System.out.println("Queue is empty");
			return null;
		}
		return queue[head];
	}
	
	public boolean isEmpty() {
        // You code goes here
		return size == 0;
	}
	
	public boolean isFull() {
        // You code goes here
		return size == queue.length;
	}
}
