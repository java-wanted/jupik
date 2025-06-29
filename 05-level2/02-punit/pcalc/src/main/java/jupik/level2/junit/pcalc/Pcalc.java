package jupik.level2.punit.pcalc;

import jupik.level2.junit.ucalc.Ucalc;

public class Pcalc extends Ucalc
{
	public static double add(String a, String b)
	{
		return add(Double.parseDouble(a), Double.parseDouble(b));
	}

	public static double sub(String a, String b)
	{
		return sub(Double.parseDouble(a), Double.parseDouble(b));
	}

	public static double mul(String a, String b)
	{
		return mul(Double.parseDouble(a), Double.parseDouble(b));
	}

	public static double div(String a, String b)
	{
		return div(Double.parseDouble(a), Double.parseDouble(b));
	}

	public static double pow2(String a)
	{
		return pow2(Double.parseDouble(a));
	}
}
