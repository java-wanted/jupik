package jupik.oop.inhov.ocafs;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DomesticCatTest
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
	void testFood()
	{
		(new DomesticCat()).eat();
		Assertions.assertEquals(
			"It is eating a cap of whiskeys.\n", mockStream.toString()
		);
	}
}
