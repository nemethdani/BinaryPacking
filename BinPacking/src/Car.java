
public class Car implements Comparable<Car>{
	int w, h, id;
	public Car(int h, int w, int id) {
		this.w=w;
		this.h=h;
		this.id=id;
	}
	public int compareTo(Car other) {
		return w*h-other.w*other.h;
	}
	
	
}
