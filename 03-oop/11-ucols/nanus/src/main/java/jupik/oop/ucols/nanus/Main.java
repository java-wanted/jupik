package jupik.oop.ucols.nanus;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main
{
	public static void main(String []argv)
	{
		List<String> names = List.of(
			"Abraam",
			"Isaac",
			"Moisha",
			"Saarah",
			"Vasia"
		);
		List<Integer> nums = List.of(
			86,
			89,
			78,
			68,
			58
		);
		List<String> nanus = new LinkedList<String>();

		Iterator<String> nai = names.iterator();
		Iterator<Integer> nui = nums.iterator();
		ListIterator<String> nanui = nanus.listIterator();

		for (;nai.hasNext() && nui.hasNext();)
		{
			nanui.add(
				String.format("%s-%d", nai.next(), nui.next())
			);
		}

		for (String s: nanus)
		{
			System.out.printf("%s\n", s);
		};
	}
}
