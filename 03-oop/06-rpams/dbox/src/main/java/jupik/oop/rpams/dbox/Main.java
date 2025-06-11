package jupik.oop.rpams.dbox;

public class Main
{
	public static void main(String []argv)
	{
		Dbox first = new Dbox(10, 20, 30);
		Dbox second = first.doubleDimensions();

		System.out.printf("First %s\n", first);
		System.out.printf("Second %s\n", second);
	}
}
