package jupik.oop.over.pers;

import java.util.List;

public class Main
{
	@FunctionalInterface
    static interface Op<T>
	{
		public void op(T o);
	}

	public static void main(String []argv)
	{
		Pers []mons = {
			new Pers(10, 20, 30),
			new Pers(10),
			new Pers(),
		};
		List<Op<Pers>> ops = List.of(
			(Pers p) -> p.voice(3, "Oh..."),
			(Pers p) -> p.voice(2),
			(Pers p) -> p.voice()
		);

		for (int i = 0; i < mons.length; ++i) {
			System.out.printf("%d: %s\n", i, mons[i]);
			ops.get(i).op(mons[i]);
		}
	}
}
