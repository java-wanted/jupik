package jupik.oop.over.pers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PersTest {
	final ByteArrayOutputStream mockStream = new ByteArrayOutputStream();
	final PrintStream origStream = System.out;

	@BeforeEach
	void setStream()
	{
		System.setOut(new PrintStream(mockStream));
	}

	@AfterEach
	void resetStream()
	{
		System.setOut(origStream);
	}

	@Test
	public void testParms() {
		String x = new StringBuffer()
			.append(String.format("eyes 10, hands 20, legs 30\n"))
			.append(String.format("Oh...\nOh...\nOh...\n"))
			.toString();

		Pers p = new Pers(10, 20, 30);
		System.out.printf("%s\n", p);
		p.voice(3, "Oh...");

		Assertions.assertEquals(x, mockStream.toString());
	}

	@Test
	public void testParm() {
		String x = new StringBuffer()
			.append(String.format("eyes 10, hands 10, legs 10\n"))
			.append(String.format("Grrr...\nGrrr...\nGrrr...\n"))
			.toString();

		Pers p = new Pers(10);
		System.out.printf("%s\n", p);
		p.voice(3);

		Assertions.assertEquals(x, mockStream.toString());
	}

	@Test
	public void testNoParm() {
		String x = new StringBuffer()
			.append(String.format("eyes 2, hands 2, legs 2\n"))
			.append(String.format("Grrr...\n"))
			.toString();

		Pers p = new Pers();
		System.out.printf("%s\n", p);
		p.voice();

		Assertions.assertEquals(x, mockStream.toString());
	}
}
