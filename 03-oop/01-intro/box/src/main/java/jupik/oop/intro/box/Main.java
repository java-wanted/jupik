package jupik.oop.intro.box;

public class Main
{
	public static void main(String []argv)
	{
		Box box1 = new Box();
		box1.height = 10;
		box1.length = 10;
		box1.width = 10;
		Box box2 = new Box();
		box2.height = 20;
		box2.length = 20;
		box2.width = 20;

		double v1 = box1.length * box1.width * box1.height;
		System.out.printf("First volume %.4f\n", v1);

		double v2 = box2.length * box2.width * box2.height;
		System.out.printf("Second volume %.4f\n", v2);
	}
}
