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

	public void write(String element) throws Exception {
	}

	public String read() throws Exception {
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
		circular.create();
		System.out.println(circular.getSize());
	}
}
