//LamdaExpressionEx.java

interface Addable {
	void sum(int a, int b);
}

public class LamdaExpressionEx{
	public static void main(String args[]){
		Addable add = (a,b) -> {
			System.out.println("Sum of a , b = "+(a+b));
		};
		add.sum(10,20);
		
		Addable a2 = (a,b) -> (a-b);
		System.out.println(a2.sum(30,10));
	}
}