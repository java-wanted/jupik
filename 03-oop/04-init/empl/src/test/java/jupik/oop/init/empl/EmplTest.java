package jupik.oop.init.empl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class EmplTest {
	static record TD(String name, String position, BigDecimal salary)
	{
	}

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
	public void testShow() {
		TD d = new TD("Boris", "Coder", new BigDecimal("40340.16"));
		String x = new StringBuffer()
				.append(String.format("Name:     %s\n", d.name))
				.append(String.format("Position: %s\n", d.position))
				.append(String.format("Salary:   %s\n", d.salary.toPlainString()))
				.toString();

		new Empl(d.name, d.position, d.salary).show();

		Assertions.assertEquals(x, mockStream.toString());
	}
}
