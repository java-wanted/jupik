package jupik.oop.parms.rect;

public class Main
{
	public static void main(String []argv)
	{
		Rect rect = new Rect();
		rect.setDimensions(1.1f, 2.2f);

		System.out.printf("Rectangle %s\n", rect);
		System.out.printf("Area %.4f\n", rect.area());
	}
}
