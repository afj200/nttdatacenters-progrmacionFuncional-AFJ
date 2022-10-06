package programacionFuncional.Exercise1;

import java.util.ArrayList;
import java.util.List;

public class ProgramacionImperativa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		int count = 0;
		for(Integer number : list) {
			if(number > 10) {
				count++;
			}
		}
		System.out.println(count);
	}

}
