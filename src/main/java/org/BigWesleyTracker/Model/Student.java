package org.BigWesleyTracker.Model;

public interface Student extends Person {

    /** Gets the students class rank
     *
     * @return Class Rank
     */
    Class getStudentClass();

    /** Promotes the student up a class rank **/
    void promote();

    /** Returns the student's major
     *
     * @return Student's major
     */
    String getMajor();

    /** Sets the student to a new major
     *
     * @param new_major Student's new major
     */
    void setMajor(String new_major);

    /** Gets the students small group
     *
     * @return returns the students small group, or null if they are not in one
     */
    String getSmallGroup();

    /** Sets the students small group to @param small_group
     * Can consider creating a small group class
     *
     * @param small_group String of students small group, set null if student leaves small group
     */
    void setSmallGroup(String small_group);

}
