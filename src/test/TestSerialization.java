package test;

import org.junit.*;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import reflection.ReflectionFormatter;
import reflection.Robot;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSerialization {

    private ReflectionFormatter formatter = new ReflectionFormatter();

    private static Robot robot;
    private static String robotStr;

    @BeforeClass
    public static void beforeClass(){
        robot = new Robot(1, "1234dfdf", 3.50);
        robotStr = String.format("type:%s\n:%s\n:%s\n:%s\n",
                robot.getClass().getName(),
                robot.getId(),
                robot.getModel(),
                robot.getPrice());
    }

    @Test
    public void _01testFormat(){
        String res =formatter.format(robot);
        Assert.assertEquals(robotStr, res);
    }

   @Test
    public void _02testParser(){
        Object object = formatter.parse(robotStr);
        Assert.assertEquals(robot,object);
    }
}
