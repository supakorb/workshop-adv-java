package app;

public class CircularBuffer {

	private static final int DEFAULT_CAPACITY = 10;
	
	private int capacity = 0;
	private int size = 0;
	private int readPointer = 0;
	private int writePointer = -1;
	private String[] buffer;

	public void create() {
		create(DEFAULT_CAPACITY);
	}

	public void create(int capacity) {
		this.capacity = capacity;
		buffer = new String[capacity];
	}

	public void write(String element) {
		if (isFull()) {
			throw new RuntimeException("Full Buffer Exception");
		}
		int index = (writePointer + 1) % capacity;
		buffer[index] = element;
		writePointer();
	}

	public String read() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Buffer Exception");
		}
		int index = readPointer % capacity;
		String element = buffer[index];
		readPointer();
		return element;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public boolean isFull() {
		return size == capacity;
	}
	
	private void writePointer() {
		writePointer++;
		size++;
	}
	
	private void readPointer() {
		readPointer++; 
		size--;
	}
}
