package jupik.oop.cols.hidis;

import jupik.oop.cols.list.ArrayList;

public class Main
{
	public static ArrayList<String> getEmployees()
	{
		ArrayList<String> emps = new ArrayList<String>();

		emps.add("Abraam");
		emps.add("Isaak");
		emps.add("Moisha");
		emps.add("Vasia");

		return emps;
	}

	public static void main(String []argv)
	{
		ArrayList<String> emps = getEmployees();

		System.out.printf("Initial emploees:\n");
		for (String e: emps)
		{
			System.out.printf("    %s\n", e);
		}

		emps.remove("Vasia");
		emps.add("Saarah");

		System.out.printf("Final employees:\n");
		for (String e: emps)
		{
			System.out.printf("    %s\n", e);
		}
	}
}
