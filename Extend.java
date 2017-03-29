//
//

class Subclass{

	public void implementMe(){

	} 

}

public class Extend extends Subclass{

	@Override
	public void implementMe(){
		System.out.println("Yea! I have Overrided by extend!!! @");
	}


   public static void main(String[] args){
   	    Extend et = new Extend();
   	    et.implementMe();
   	    

   }
}


/* ----------- OUTPUT --------------

Yea! I have Overrided by extend!!! @
[Finished in 1.2s]

*/