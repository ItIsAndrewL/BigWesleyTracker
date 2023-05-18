package org.BigWesleyTracker.Model;

import java.time.LocalDateTime;

public class EventImpl implements Event, Comparable<Event> {
    private final String _name;
    private LocalDateTime _time;
    private String _location;
    private int _attendance;

    public EventImpl(String name, LocalDateTime time, String location) {
        if (name == null || time == null || location == null) {
            throw new IllegalArgumentException("Cannot have null values");
        }
        _name = name;
        _time = time;
        _location = location;
        _attendance = 0;
    }

    @Override
    public String getEventName() {
        return _name;
    }

    @Override
    public LocalDateTime getDateTime() {
        return _time;
    }

    @Override
    public void setDateTime(LocalDateTime new_date) {
        if (new_date == null) {
            throw new IllegalArgumentException("Cannot have null value");
        }
        _time = new_date;
    }

    @Override
    public String getLocation() {
        return _location;
    }

    @Override
    public void setLocation(String new_location) {
        if (new_location == null) {
            throw new IllegalArgumentException("Cannot have null value");
        }
        _location = new_location;
    }

    @Override
    public int getAttendance() {
        return _attendance;
    }

    @Override
    public void incrementAttendance() {
        _attendance++;
    }

    @Override
    public void decrementAttendance() {
        _attendance--;
    }

    @Override
    public int compareTo(Event o) {
        int cmp = _time.compareTo(o.getDateTime());
        return Integer.compare(0, cmp);
    }
}
