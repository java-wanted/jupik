package jupik.oop.optro.rdog;

public class Main
{
	public static void main(String []argv)
	{
		new Rdog(){
			{
				speed = 10;
			}
		}.run();
	}
}
