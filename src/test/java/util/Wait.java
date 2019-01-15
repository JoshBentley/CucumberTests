package util;

public class Wait
{
    Config config = new Config();

    public Integer implicitWaitTime = Integer.parseInt(config.properties("implicitWaitTime"));

    public void waitFor(Integer seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
