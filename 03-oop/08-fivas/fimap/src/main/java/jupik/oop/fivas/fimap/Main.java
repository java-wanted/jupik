package jupik.oop.fivas.fimap;

public class Main
{
	public static final double PI = java.lang.Math.PI;

	public static double piraras(double... radius)
	{
		double s = 0.0;

		for (double r: radius)
		{
			s += PI * r * r;
		}

		return s;
	}

	public static void main(String []argv)
	{
		double []radius = {1.0, 2.0, 3.0};
		StringBuffer s = new StringBuffer();

		s.append(String.format("Radius:\n"));

		for (double r: radius)
		{
			s.append(String.format("    %.2f\n", r));
		}

		s.append(String.format("Total area:\n"));
		s.append(String.format("    %.2f\n", piraras(radius)));

		System.out.print(s);
	}
}
