class ParentClass
{
   public void displayMethod(String msg){
      System.out.println(msg+ "  -- from Base / ParentClass, 假如不被Override 那就是这个原来的被extend的方法");
   }
}

class Override extends ParentClass
{
   // @Override 
   // public void displayMethod(String msg){  //即使输入参数相同，Override就是把它覆盖掉
   //    System.out.println(msg+ "  -- from DerivedClass, using function after @Override!");
   // }


   // @Override 
   public void displayMethod(String msg){  //即使输入参数相同，Override就是把它覆盖掉
      System.out.println(msg+ "  -- from DerivedClass, using function after @Override!");
   }

   Override(){
      System.out.println("即使你不写Override，它也会自动覆盖。因为java继承中（两个同样行参的同名函数）总是自动调用更窄的那个函数");
   }



   public static void main(String args[]){
      Override ovd  = new Override();
      ovd.displayMethod("Hey! where this msg from?  (Even here is 'Derived' class initialized!)");
   }

}

/* ----------- OUTPUT --------------

即使你不写Override，它也会自动覆盖。因为java继承中（两个同样行参的同名函数）总是自动调用更窄的那个函数
Hey! where this msg from?  (Even here is 'Derived' class initialized!)  -- from DerivedClass, using function after @Override!
[Finished in 1.2s]

*/
   // @Override 'O' must be uppercase!! 
   // Omg，@Override中O必须大写！！！！否则错！



