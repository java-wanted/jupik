package jupik.generics.parops.agrar;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasketTest
{
    static final double EPS = 1.0e-7;

    <T extends Fruit> Basket<T> createBasket(Class<T> cls, int n)
    {
        try
        {
            Basket<T> basket = new Basket<>();
            Constructor<T> ctor = cls.getConstructor();

            for (int i = 0; i < n; ++i)
            {
                basket.add(ctor.newInstance());
            }

            return basket;
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
    }

    @DisplayName("Test add")
    @Test
    void testWeight()
    {
        Basket<Apple> apple = new Basket<>();
        Basket<Fruit> fruit = new Basket<>();

        apple.add(new Apple());

        fruit.add(new Apple());
        fruit.add(new Orange());
    }

    @DisplayName("Test weight")
    @Test
    void testWieght()
    {
        Assertions.assertEquals(
            10 * new Apple().weight(),
            createBasket(Apple.class, 10).weight(),
            EPS
        );

        Assertions.assertEquals(
            10 * new Orange().weight(),
            createBasket(Orange.class, 10).weight(),
            EPS
        );
    }

    @DisplayName("Test transfer")
    @Test
    void testTransfer()
    {
        Basket<Apple> apple = createBasket(Apple.class, 10);
        Basket<Orange> orange = createBasket(Orange.class, 10);
        Basket<Fruit> fruit = new Basket<>();
        float weight = apple.weight() + orange.weight();

        fruit.transfer(apple);
        fruit.transfer(orange);

        Assertions.assertEquals(0, apple.weight());
        Assertions.assertEquals(0, orange.weight());

        Assertions.assertEquals(weight, fruit.weight(), EPS);
    }

    @DisplayName("Test compare of equal")
    @Test
    void testCompareEqual()
    {
        Basket<Apple> apple = createBasket(Apple.class, 15);
        Basket<Orange> orange = createBasket(Orange.class, 10);

        Assertions.assertEquals(0, apple.compareTo(orange));
        Assertions.assertEquals(0, orange.compareTo(apple));

        Basket<Fruit> fruit = new Basket<>();
        fruit.transfer(orange);

        Assertions.assertEquals(0, apple.compareTo(fruit));
        Assertions.assertEquals(0, fruit.compareTo(apple));
    }

    @DisplayName("Test compare of not equal")
    @Test
    void testCompareNotEqual()
    {
        Basket<Apple> apple = createBasket(Apple.class, 15);
        Basket<Orange> orange = createBasket(Orange.class, 11);

        Assertions.assertEquals(-1, apple.compareTo(orange));
        Assertions.assertEquals(1, orange.compareTo(apple));

        Basket<Fruit> fruit = new Basket<>();
        fruit.transfer(orange);

        Assertions.assertEquals(-1, apple.compareTo(fruit));
        Assertions.assertEquals(1, fruit.compareTo(apple));
    }
}
