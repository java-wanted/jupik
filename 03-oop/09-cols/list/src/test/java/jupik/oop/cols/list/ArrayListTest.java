package jupik.oop.cols.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ArrayListTest
{
	static class NList implements List<Integer>
	{
		int size;

		class Iter implements Iterator<Integer>
		{
			int index = 0;

			@Override
			public boolean hasNext()
			{
				return index != size;
			}

			@Override
			public Integer next()
			{
				if (index >= size)
				{
					throw new NoSuchElementException();
				}

				return ++index;
			}
		}

		NList(int size)
		{
			if (size < 0)
			{
				throw new IllegalArgumentException();
			}

			this.size = size;
		}

		@Override
		public void add(int index, Integer e)
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(Integer e)
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public Integer get(int index)
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean equals(Object o)
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int hashCode()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int indexOf(Integer e)
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterator<Integer> iterator()
		{
			return new Iter();
		}

		@Override
		public void remove(int index)
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean remove(Integer index)
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int size()
		{
			return size;
		}
	}

	ArrayList<Integer> createNatural(int n)
	{
		ArrayList<Integer> l = new ArrayList<Integer>(0);

		for (int i = 0; i < n; ++i)
		{
			l.add(i + 1);
		}

		return l;
	}

	@Test
	void testAddTail()
	{
		ArrayList<Integer> l = createNatural(4);

		Assertions.assertEquals(4, l.size());

		for (int i = 0; i < l.size(); ++i)
		{
			Assertions.assertEquals(i + 1, l.get(i));
		}
	}

	@Test
	void testAdd()
	{
		ArrayList<Integer> l = new ArrayList<Integer>(0);

		l.add(0, 3);
		l.add(1, 4);
		l.add(0, 1);
		l.add(1, 2);

		Assertions.assertEquals(4, l.size());

		for (int i = 0; i < l.size(); ++i)
		{
			Assertions.assertEquals(i + 1, l.get(i));
		}
	}

	@Test
	void testIndexOf()
	{
		ArrayList<Integer> l = createNatural(4);

		Assertions.assertEquals(-1, l.indexOf(0));

		for (int i = 0; i < l.size(); ++i)
		{
			Assertions.assertEquals(i, l.indexOf(i + 1));
		}

		Assertions.assertEquals(-1, l.indexOf(0), l.size() + 1);
	}

	@Test
	void testRemoveTail()
	{
		ArrayList<Integer> l = createNatural(4);

		for (int i = l.size() - 1; i >= 0; --i)
		{
			Assertions.assertFalse(l.remove(Integer.valueOf(i + 2)));
			Assertions.assertTrue(l.remove(Integer.valueOf(i + 1)));

			for (int j = 0; j < l.size(); ++j)
			{
				Assertions.assertEquals(j + 1, l.get(j));
			}
		}
	}

	@Test
	void testRemove()
	{
		ArrayList<Integer> l = createNatural(4);
		int n = l.size();

		for (int i = 1; i < n - 1; ++i)
		{
			Assertions.assertTrue(l.remove(Integer.valueOf(i + 1)));
			Assertions.assertEquals(1, l.get(0));
			Assertions.assertEquals(n, l.get(l.size() - 1));
		}
	}


	@Test
	void testClear()
	{
		ArrayList<Integer> l = createNatural(4);

		l.clear();

		Assertions.assertEquals(0, l.size());
	}

	@Test
	void testIter()
	{
		ArrayList<Integer> l = createNatural(4);
		int prev = 0;

		for (int v: l)
		{
			Assertions.assertEquals(prev + 1, v);
			prev = v;
		}
	}

	@Test
	void testIterException()
	{
		ArrayList<Integer> l = createNatural(4);
		final Iterator<Integer> i1 = l.iterator();

		l.add(l.size() + 1);

		Assertions.assertThrows(
			ConcurrentModificationException.class,
			() -> i1.next()
		);

		final Iterator<Integer> i2 = l.iterator();
		l.remove(0);

		Assertions.assertThrows(
			ConcurrentModificationException.class,
			() -> i2.next()
		);

		final Iterator<Integer> i3 = l.iterator();
		Assertions.assertEquals(2, i3.next());

		l.clear();

		Assertions.assertThrows(
			ConcurrentModificationException.class,
			() -> i3.next()
		);
	}

	@Test
	void testEqual()
	{
		ArrayList<Integer> l = createNatural(4);
		ArrayList<Integer> m = createNatural(4);

		Assertions.assertTrue(l.equals(m));
		Assertions.assertEquals(l.hashCode(), m.hashCode());
	}

	@Test
	void testNotEqual()
	{
		ArrayList<Integer> l = createNatural(4);
		ArrayList<Integer> m = createNatural(4);

		m.remove(1);
		m.add(1, 0);

		Assertions.assertFalse(l.equals(m));
	}

	@Test
	void testListEqual()
	{
		ArrayList<Integer> l = createNatural(4);
		NList m = new NList(4);

		Assertions.assertTrue(l.equals(m));
	}

	@Test
	void testNotListEqual()
	{
		ArrayList<Integer> l = createNatural(4);
		Integer []m = {1, 2, 3, 4};

		Assertions.assertFalse(l.equals(m));
	}

	@Test
	void testClone()
	{
		ArrayList<Integer> l = createNatural(4);
		List<?> c = (List<?>)l.clone();

		Assertions.assertTrue(l.equals(c));
	}
}
