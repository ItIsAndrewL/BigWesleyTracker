package org.BigWesleyTracker.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PersonImpl implements Person {
    private final String _fName;
    private final String _lName;
    private final PriorityQueue<Event> _events; //

    public PersonImpl(String first_name, String last_name) {
        if (first_name == null || last_name == null) {
            throw new IllegalArgumentException("Cannot have null value");
        }
        _fName = first_name;
        _lName = last_name;
        _events = new PriorityQueue<>();
    }

    @Override
    public String getFirstName() {
        return _fName;
    }

    @Override
    public String getLastName() {
        return _lName;
    }

    @Override
    public List<Event> getEvents() {
        return new ArrayList<>(_events);
    }

    @Override
    public Event getLastEvent() {
        return _events.peek();
    }

    @Override
    public int getNumEvents() {
        return _events.size();
    }

    @Override
    public void addEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Cannot have null reference");
        }
        _events.add(event);
        event.incrementAttendance();
    }

    @Override
    public void removeEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Cannot have null reference");
        }
        if (!_events.remove(event)) {
            throw new EventNotFoundException();
        }
        event.decrementAttendance();
    }
}
