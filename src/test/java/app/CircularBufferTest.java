package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CircularBufferTest {
	
	@Test
	public void create_buffer_with_default_capacity() {
		CircularBuffer circular = new CircularBuffer();
		circular.create();
		assertEquals(10, circular.getCapacity());
	}
	
	@Test
	public void create_buffer_with_2_capacity() {
		CircularBuffer circular = new CircularBuffer();
		circular.create(2);
		assertEquals(2, circular.getCapacity());
	}
	
	@Test
	public void write_A_B() {
		CircularBuffer circular = new CircularBuffer();
		circular.create();
		circular.write("A");
		circular.write("B");
		assertEquals(2, circular.getSize());
	}
	
	@Test
	public void create_buffer_with_2_capacity_and_write_A_B_then_buffer_is_full() {
		CircularBuffer circular = new CircularBuffer();
		circular.create(2);
		circular.write("A");
		circular.write("B");
		assertTrue(circular.isFull());
	}
	
	@Test
	public void create_buffer_with_2_capacity_and_write_A_B_then_read_once() {
		CircularBuffer circular = new CircularBuffer();
		circular.create(2);
		circular.write("A");
		circular.write("B");
		assertEquals("A", circular.read());
	}
	
	@Test
	public void write_buffer_with_A_B_and_read_A_B_then_buffer_is_empty() {
		CircularBuffer circular = new CircularBuffer();
		circular.create(2);
		circular.write("A");
		circular.write("B");
		circular.read();
		circular.read();
		assertTrue(circular.isEmpty());
	}
	
	@Test
	public void create_buffer_with_2_capacity_and_write_A_B_C() {
		CircularBuffer circular = new CircularBuffer();
		circular.create(2);
		circular.write("A");
		circular.write("B");
		Exception exception = assertThrows(RuntimeException.class, () -> {
			circular.write("C");
		}, "Full Buffer Exception");
	}
	
	@Test
	public void create_buffer_with_1_capacity_and_read_without_write() {
		CircularBuffer circular = new CircularBuffer();
		circular.create(1);
		Exception exception = assertThrows(RuntimeException.class, () -> {
			circular.read();
		}, "Empty Buffer Exception");
	}
}
