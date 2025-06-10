package jupik.oop.parms.pbox;

public class Main
{
	public static void main(String []argv)
	{
		Pbox box1 = new Pbox();
		box1.setDimensions(10, 10, 10);

		Pbox box2 = new Pbox();
		box2.setDimensions(20, 20, 20);

		System.out.printf("First volume %.4f\n", box1.volume());
		System.out.printf("Second volume %.4f\n", box2.volume());
	}
}
