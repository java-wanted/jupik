package jupik.multithreading.mexclu.mufunc;

public interface Mufunc
{
    public interface Job
    {
        public void await() throws InterruptedException;
    }

    public Job print(int pages) throws InterruptedException;
    public Job scan(int pages) throws InterruptedException;
    public void poweroff() throws InterruptedException;
}
