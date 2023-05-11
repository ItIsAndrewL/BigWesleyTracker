package org.BigWesleyTracker.Model;

import java.time.LocalDateTime;

public interface Event {

    /** Gets the event's name
     *
     * @return events name
     */
    String getEventName();

    /** Gets the events date and time
     *
     * @return time of event
     */
    LocalDateTime getDateTime();

    /** Sets date
     *
     * @param new_date new date object
     */
    void setDateTime(LocalDateTime new_date);

    /** Gets location of event
     *
     * @return string representation of location
     */
    String getLocation();

    /** changes location
     *
     * @param new_location new location
     */
    void setLocation(String new_location);
}
