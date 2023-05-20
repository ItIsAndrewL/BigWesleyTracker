package org.BigWesleyTracker.Model;

import java.util.List;

public interface Leader extends Student {

    /** Gets the leaders position
     *
     * @return position
     */
    String getPosition();

    /** sets leader's position
     *
     * @param new_position new position
     */
    void setPosition(String new_position);

    /** Gets leader's team
     *
     * @return team string
     */
    String getTeam();

    /** Set leaders team
     *
     * @param team new team
     */
    void setTeam(String team);

    /** Permits login on correct password
     *
     * @param entered_password entered password
     * @return boolean if it matches saved password
     */
    boolean permitLogin(String entered_password);

    /** Changes password
     *
     * @param old_password old password
     * @param new_password new password
     * @throws IllegalArgumentException old password does not match saved
     */
    void changePassword(String old_password, String new_password) throws IllegalArgumentException;

    /** gets leader's perms list reference
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
     * @throws IllegalArgumentException perm not in perms list
     */
    void removePerm(Perms perm) throws IllegalArgumentException;

}
