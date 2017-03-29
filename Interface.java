// static interface must be declared as a static member of top level class
// static interface can't have its name as top level class

class MyInterfaceClass{
	public static interface MyInterface{
		public void implementMe();
	} 

}

public class Interface implements MyInterfaceClass.MyInterface{

	// @Override X                                                        X: u didn't Override it, u just implement it.
	public void implementMe(){
		System.out.println("Yea! I have implemented by interface!!!");
	}


   public static void main(String[] args){
   	    Interface it = new Interface();
   	    it.implementMe();

   }
}

/* ----------- OUTPUT --------------

Yea! I have implemented by interface!!!
[Finished in 1.2s]

*/
