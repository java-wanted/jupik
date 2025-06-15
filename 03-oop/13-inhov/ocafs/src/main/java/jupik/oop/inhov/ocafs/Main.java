package jupik.oop.inhov.ocafs;

public class Main
{
	public static void main(String []argv)
	{
		Cat []cats = {
			new Cat(),
			new DomesticCat(),
			new Lion(),
		};

		for (Cat c: cats)
		{
			c.eat();
		}
	}
}
