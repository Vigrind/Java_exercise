package method_reference;


public class Account {
	public class Person{}
	public Account(){}
	public Account(Runnable r){}
	public Person owner(){ return new Person();}
	public Integer balance(){ return 4;}
	public void changeOwner(Person newOwner){}
	public static Account create(Person owner){ return new Account();}
}

/*
interface Supplier<T> {
	T get();
}
 */

 /*
interface Consumer<T> {
	void accept(T arg0);
}
 */