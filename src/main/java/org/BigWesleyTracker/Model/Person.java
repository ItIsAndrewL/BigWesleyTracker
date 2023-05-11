package org.BigWesleyTracker.Model;

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

    /** Adds event to the List of events
     *
     * @param event event person was at
     */
    void addEvent(Event event);

    /** Removes event from the list of events
     *
     * @param event event person was actually not at
     */
    void removeEvent(Event event);

}
