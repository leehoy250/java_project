package co.yedam.generic;

// T: type parameter
// <T>: 제너릭표현
public class Box<T> {
	T obj;
	
	T get() {
		return obj;
	}
	
	void set(T obj) {
		this.obj = obj;
	}
}
