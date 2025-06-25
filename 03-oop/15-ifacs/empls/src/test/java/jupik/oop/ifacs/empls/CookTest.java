package jupik.oop.ifacs.empls;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CookTest
{
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
	void testPosition()
	{
		Assertions.assertEquals("Cook", (new Cook()).position());
	}

	@Test
	void testWork()
	{
		String x = "Her is cooking.\n";

		(new Cook()).work();

		Assertions.assertEquals(x, mockStream.toString());
	}
}
