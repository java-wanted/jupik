package jupik.stream.interm.termage;

public class User
{
    protected String name;
    protected int age;

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String name()
    {
        return name;
    }

    public int age()
    {
        return age;
    }
}
