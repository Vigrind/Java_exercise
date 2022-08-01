import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.management.relation.RoleInfoNotFoundException;

public class Main{
	public static void main(String[] args) {
		Object e = new HashSet<>();
		List<Integer> l = new ArrayList<>();
		List<Integer> l2 = new LinkedList<>();

		System.out.println(e.getClass());
		System.out.println(l.getClass());
		System.out.println(l2.getClass());
	}

	public static Object crea(){
		class Rinoceronte{}
		Rinoceronte a = new Rinoceronte();
		return a;
	}
}