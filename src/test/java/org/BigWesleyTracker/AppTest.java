package org.BigWesleyTracker;

import static org.junit.Assert.*;

import org.BigWesleyTracker.Model.*;
import org.junit.Test;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AppTest {

    @Test
    public void test_PersonImpl(){
        Event e1 = new EventImpl("E1", LocalDateTime.of(2022, 11, 22, 6, 30), "Wesley Building");
        Event e2 = new EventImpl("E2", LocalDateTime.now(), "Church");
        Event e3 = new EventImpl("E3", LocalDateTime.of(2023, 1, 1, 12, 50), "Ur moms house");
        Person andrew = new PersonImpl("Andrew", "Lockard");
        Person ryan = new PersonImpl("Ryan", "Spurrier");
        Person isaac = new PersonImpl("Isaac", "Frank");

        andrew.addEvent(e1);
        ryan.addEvent(e1);

        andrew.addEvent(e2);
        isaac.addEvent(e2);

        andrew.addEvent(e3);
        ryan.addEvent(e3);
        isaac.addEvent(e3);

        // Test Events have correct attendance
        assertEquals(2, e1.getAttendance());
        assertEquals(2, e2.getAttendance());
        assertEquals(3, e3.getAttendance());

        // Test getLastEvent
        assertSame(e2, andrew.getLastEvent());
        assertSame(e2, isaac.getLastEvent());
        assertSame(e3, ryan.getLastEvent());

        // Test getNumEvents
        assertEquals(3, andrew.getNumEvents());
        assertEquals(2, ryan.getNumEvents());
        assertEquals(2, isaac.getNumEvents());

        // Test removeEvent
        andrew.removeEvent(e2);
        assertSame(e3, andrew.getLastEvent());
        assertEquals(2, andrew.getNumEvents());
        assertEquals(1, e2.getAttendance());

        ryan.removeEvent(e3);
        assertSame(e1, ryan.getLastEvent());
        assertEquals(1, ryan.getNumEvents());

        try{
            isaac.removeEvent(e1);
            fail();
        } catch (EventNotFoundException e) {
            // Pass
        }

        // Test getEvents
        List<Event> andrew_events = andrew.getEvents();
        assertEquals(2, andrew_events.size());
        assertTrue(andrew_events.contains(e1));
        assertTrue(andrew_events.contains(e3));
        assertFalse(andrew_events.contains(e2));
    }

    @Test
    public void test_StudentImpl() {
        // TODO: Write Test
    }
}
