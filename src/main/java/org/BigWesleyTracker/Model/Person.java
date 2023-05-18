package org.BigWesleyTracker.Model;

import java.time.LocalDateTime;
import java.util.List;

public interface Person {
    /** Returns first Name
     *
     * @return Person's first name
     */
    String getFirstName();

    /** Returns Person's last name
     *
     * @return Person's last name
     */
    String getLastName();

    /** Returns persons name as "fName lName"
     *
     * @return full name
     */
    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    /** Returns copy of events list
     *
     * @return copy of event's list
     */
    List<Event> getEvents();

    /** Gets the last event in the List of attended events
     *
     * @return latest attended event
     */
    Event getLastEvent();

    /** Gets the date of the last attended event
     *
     * @return Date of last event
     */
    default LocalDateTime getLastEventTime() {
        return getLastEvent().getDateTime();
    }

    /** Gets the number of attended events
     *
     * @return num of attended events
     */
    int getNumEvents();

    /** Adds event to the List of attended events
     *
     * @param event event person was at, and updates attendance count
     */
    void addEvent(Event event);

    /** Removes event from the list of attended events
     *
     * @param event event person was actually not at, and updates attendance count
     */
    void removeEvent(Event event);

}
