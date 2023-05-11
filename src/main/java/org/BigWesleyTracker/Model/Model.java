package org.BigWesleyTracker.Model;

import java.util.List;

public interface Model {
    /** Gets copy of list of persons
     *
     * @return copy of list
     */
    List<Person> getPersonList();

    /** Searches and returns person
     *
     * @param fName Firstname of desired person
     * @param lName Lastname of desired person
     * @return Pointer to person object
     * @throws PersonNotFoundException if person is not found
     */
    Person getPerson(String fName, String lName);

    /** Gets copy of events list
     *
     * @return copy of list
     */
    List<Event> getEventList();

    /** Searches and returns event
     *
     * @param event_name name of event
     * @return pointer to event
     */
    Event getEvent(String event_name);

    /** gets student representation of person
     *
     * @param p pointer to person object
     * @return student object
     * @throws IllegalArgumentException if person is not a student
     */
    Student getStudent(Person p);

    /** Gets leader representation of person
     *
     * @param p pointer to person object
     * @return leader object
     * @throws IllegalArgumentException if person is not a leader
     */
    Leader getLeader(Person p);

    /** Gets staff representation of person
     *
     * @param p pointer to person object
     * @return staff object
     * @throws IllegalArgumentException if person is not staff
     */
    Staff getStaff(Person p);

    //TODO: Add more methods for execution and getting data
}
