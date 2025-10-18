package jupik.io.obser.suser;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable
{
    public static final long serialVersionUID = 1L;

    protected String name;
    protected String lastname;
    protected int age;

    public User(String name, String lastname, int age)
    {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String name()
    {
        return name;
    }

    public String lastname()
    {
        return lastname;
    }

    public int age()
    {
        return age;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        else if (o == null)
        {
            return false;
        }
        else if (o instanceof User u)
        {
            return Objects.equals(name, u.name) &&
                Objects.equals(lastname, u.lastname) &&
                age == u.age;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, lastname, age);
    }
}
