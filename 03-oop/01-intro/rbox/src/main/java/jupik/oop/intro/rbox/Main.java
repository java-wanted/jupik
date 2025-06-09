package jupik.oop.intro.rbox;

public class Main
{
	public static void main(String []argv)
	{
		Rbox box = new Rbox();
		box.height = 10;
		box.length = 10;
		box.width = 10;
		Rbox rbox = box;
		rbox.height = 20;

		double v = box.length * box.width * box.height;
		System.out.printf("Volume %.4f\n", v);
	}
}
