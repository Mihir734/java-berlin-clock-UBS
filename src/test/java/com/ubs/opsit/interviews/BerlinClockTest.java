package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockTest {

    @Test
    public void getSecondsTest() throws Exception {
        assertEquals(BerlinClock.getSeconds(0), "Y");
        assertEquals(BerlinClock.getSeconds(1), "O");

        try {
            BerlinClock.getSeconds(-1);
        } catch (Exception e) {
            assert (e.getMessage().equals("invalid input"));

        }

    }

    @Test
    public void getHoursTest() throws Exception {
        assertEquals(BerlinClock.getTopHours(13), "RROO");
        assertEquals(BerlinClock.getTopHours(0), "OOOO");
        assertEquals(BerlinClock.getBottomHours(0), "OOOO");
        assertEquals(BerlinClock.getBottomHours(13), "RRRO");

        try {
            BerlinClock.getTopHours(-1);
        } catch (Exception e) {
            assert (e.getMessage().equals("invalid input"));

        }
    }

    @Test
    public void getMinutesTest() throws Exception {
        assertEquals(BerlinClock.getTopMinutes(0), "OOOOOOOOOOO");
        assertEquals(BerlinClock.getTopMinutes(17), "YYROOOOOOOO");
        assertEquals(BerlinClock.getBottomMinutes(17), "YYOO");
        assertEquals(BerlinClock.getBottomMinutes(0), "OOOO");

        try {
            BerlinClock.getTopMinutes(-1);
        } catch (Exception e) {
            assert (e.getMessage().equals("invalid input"));

        }
    }
}



