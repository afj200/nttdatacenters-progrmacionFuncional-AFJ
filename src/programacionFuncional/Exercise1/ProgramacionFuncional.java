package programacionFuncional.Exercise1;

import java.lang.invoke.CallSite;
import java.util.List;

public class ProgramacionFuncional {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		
		System.out.println(list.stream().filter(numero -> numero > 10).count());

	}

}
