package arraysPractice;

public class arrayPra {
	public void main(String[] args) {
		int[] arr = new int[19];
//		arr.length=0;
		System.out.println(arr);
		String name = new String("Shashank");
		System.out.println(name);
		sample sample = new sample();
		System.out.println(sample);
		
		for (Days day : Days.values()) {
            System.out.println(day);
        }
	}
}
class sample{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "toString method is overridden in sample class";
	}
	public sample() {
		System.out.println("Sample class constructor getting invoked");
	}
}
enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

 
