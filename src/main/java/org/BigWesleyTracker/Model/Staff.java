package org.BigWesleyTracker.Model;

import java.util.List;

public interface Staff extends Person {

    /** Gets the staffer's position
     *
     * @return position
     */
    String getPosition();

    /** sets staffer's position
     *
     * @param new_position new position
     */
    void setPosition(String new_position);

    /** Gets staffer's login password
     * Consider deprecating this
     *
     * @return decrypted password
     */
    String getPassword();

    /** Permits login on correct password
     *
     * @param entered_password Entered password
     * @return boolean if it matches saved password
     */
    boolean permitLogin(String entered_password);

    /** Changes password
     *
     * @param new_password new password
     */
    void changePassword(String new_password);

    /** gets staffer's perms
     *
     * @return list of users perms
     */
    List<Perms> getPerms();

    /** Adds perm
     *
     * @param perm perm to add to list
     */
    void addPerm(Perms perm);

    /** Removes perm
     *
     * @param perm perm to remove
     */
    void removePerm(Perms perm);
}
