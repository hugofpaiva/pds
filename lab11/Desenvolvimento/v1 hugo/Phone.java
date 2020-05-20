package lab11.v1;

import java.util.ArrayList;
import java.util.List;

public class Phone {
	private String name;
	private String processor;
	private double price;
	private int memory;
	private String camera;
	
	public Phone (String name, String proc, double price, int mem, String camera) {
		this.name = name;
		this.processor = proc;
		this.price = price;
		this.memory = mem;
		this.camera = camera;
	}

	public List<String> getProps () {
		List props = new ArrayList();
		props.add(name);
		props.add(processor);
		props.add(price);
		props.add(memory);
		props.add(camera);
		return props;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", processor=" + processor + ", price=" + price + ", memory=" + memory
				+ ", camera=" + camera + "]";
	}
	
	
}
