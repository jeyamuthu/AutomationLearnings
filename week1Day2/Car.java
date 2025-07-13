package week1Day2;

public class Car {

	String name = "Jeyamuthu";
	

	public void applyBrake() {
		System.out.println("Brake Applied");
	}
	
	public static void main(String[] args) {
			
				Car obj= new Car();
				obj.applyBrake();
				System.out.println(obj.name);
				
				
			
	}
}
