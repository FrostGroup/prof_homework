package logging;

import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;

import java.io.IOException;

/**
 * Created by Alex on 01.06.2016.
 */
public class TestLogging {

    public static void main(String[] args) throws IOException {

        ConsoleAppender console = new ConsoleAppender(new PatternLayout("%r [%t] %-5p %c %L %l %C %x - %m%n"));
        Logger parent = Logger.getLogger("prof_homework.src.main.java");
        parent.addAppender(console);
        parent.setLevel(Level.INFO);

        Logger child = Logger.getLogger("prof_homework.src.main.java.logging");
        child.addAppender(console);
        child.setLevel(Level.INFO);

        Logger child2 = Logger.getLogger(TestLogging.class);
        child2.setLevel(Level.DEBUG);

        child2.addAppender(new FileAppender(new XMLLayout(),"log.xml"));
        child2.addAppender(console);

        child2.debug("child2 debug");

    }
}
