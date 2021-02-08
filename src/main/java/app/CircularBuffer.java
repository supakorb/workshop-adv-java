package app;

public class CircularBuffer {

	private int capacity = 0;
	private int size = 0;
	private int readPointer = 0;
	private int writePointer = -1;
	private String[] array;

	public void create() {
		this.capacity = 10;
		array = new String[capacity];
	}

	public void create(int capacity) {
		this.capacity = capacity;
		array = new String[capacity];
	}

	public void write(String element) {
		if (size + 1 == capacity) {
			throw new RuntimeException("Full Buffer Exception");
		}
		int index = (writePointer + 1) % capacity;
		array[index] = element;
		writePointer();
	}
	
	public void writePointer() {
		writePointer++;
		size++;
	}

	public String read() {
		return null;
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

	public static void main(String[] args) {
		CircularBuffer circular = new CircularBuffer();
		try {
			circular.create();
			circular.write("A");
			System.out.println("size: " + circular.getSize());
			circular.write("B");
			System.out.println("size: " + circular.getSize());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
