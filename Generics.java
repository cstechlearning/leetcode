/* generic class: type parameter should be followed by class name, and contain in <>
              T : type    
 */

// here T is type parameter, will be replaced by actual type when object creates
class SimpleGeneric<T>{
	private T objRef = null;

	//constructor to accept type T
	public SimpleGeneric(T param){
		this.objRef = param;
	}

	public T getobjRef(){
		return this.objRef;
	}

	public void printobjRef(){
		System.out.println("<T> Type: "+objRef.getClass().getName());
	}

}

public class Generics {

	public static void main(String a[]){
		// <T> Type: String
		SimpleGeneric<String>  sgs = new SimpleGeneric<String>("java2novice.com");
		sgs.printobjRef();

		SimpleGeneric<Integer> sgi = new SimpleGeneric<Integer>(0);
		sgi.printobjRef();
		
		SimpleGeneric<Boolean> sgb = new SimpleGeneric<Boolean>(false);
		sgb.printobjRef();

	}
}

/*  --- OUTPUT --------

<T> Type: java.lang.String
<T> Type: java.lang.Integer
<T> Type: java.lang.Boolean
[Finished in 1.4s]

 */



