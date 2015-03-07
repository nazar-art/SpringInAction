package com.springinaction.springidol;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static java.lang.System.setProperty;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:com/springinaction/springidol/spring-idol.xml"})
public class IdolTest {

    @Autowired
    ApplicationContext context;

    @BeforeClass
    public static void setup() {
        setProperty("STANS_SONG", "Total Eclipse of the Heart");
    }

    @Test
    public void carlShouldBeWiredWithKennysSong() {
        Instrumentalist kenny = (Instrumentalist) context.getBean("kenny");
        Instrumentalist carl = (Instrumentalist) context.getBean("carl");
        assertEquals(kenny.getSong(), carl.getSong());
    }

    @Test
    public void stanShouldBeWiredWithSongFromSystemProperties() {
        Instrumentalist stan = (Instrumentalist) context.getBean("stan");
        assertEquals("Total Eclipse of the Heart", stan.getSong());
    }

    @Test
    public void rickyShouldBeWiredWithSongFromSongBook() {
        Instrumentalist ricky = (Instrumentalist) context.getBean("ricky");
        assertEquals("That Old Black Magic", ricky.getSong());
    }

}
