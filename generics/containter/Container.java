public class Container<T extends Employee>{
	public <P extends Comparable<P>> Container(P type){}
}

class Person{}
class Employee extends Person{}
class Manager extends Employee{}