package org.BigWesleyTracker;

import static org.junit.Assert.*;

import org.BigWesleyTracker.Model.*;
import org.BigWesleyTracker.Model.Class;
import org.junit.Test;
import java.time.LocalDateTime;
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
        Student andrew = new StudentImpl("Andrew", "Lockard", Class.FRESHMEN, "Computer Science & Math", null);
        andrew.promote();
        assertEquals(Class.SOPHOMORE, andrew.getClassRank());
        andrew.promote();
        assertEquals(Class.JUNIOR, andrew.getClassRank());
        andrew.promote();
        assertEquals(Class.SENIOR, andrew.getClassRank());
        andrew.promote();
        assertEquals(Class.GRADUATE, andrew.getClassRank());
        try {
            andrew.promote();
            fail();
        } catch (UnsupportedOperationException e) {
            // pass
        }
    }

    @Test
    public void test_LeaderImpl() {
        Leader Andrew = new LeaderImpl("Andrew", "Lockard", Class.JUNIOR, "Computer Science",
                null, "Social Cordinator", "Admin", "UNCgoesCraZy25");

        assertTrue(Andrew.permitLogin("UNCgoesCraZy25"));
        assertFalse(Andrew.permitLogin("WrongPassword"));

        Andrew.changePassword("UNCgoesCraZy25", "newPassword");
        assertTrue(Andrew.permitLogin("newPassword"));

        try {
            Andrew.changePassword("wrongPassword", "notHappening");
            fail();
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    public void test_StaffImpl() {
        Staff Ryan = new StaffImpl("Ryan", "Spurrier", "Campus Minister", "ClemsonSucks");

        assertTrue(Ryan.permitLogin("ClemsonSucks"));
        assertFalse(Ryan.permitLogin("ClemsonROCKS"));

        Ryan.changePassword("ClemsonSucks", "newPassword");
        assertTrue(Ryan.permitLogin("newPassword"));

        try {
            Ryan.changePassword("wrongPassword", "notHappening");
            fail();
        } catch (IllegalArgumentException e) {
            // pass
        }
    }
}
