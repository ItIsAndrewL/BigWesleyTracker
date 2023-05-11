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

    /** Gets leader's login password
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

    /** gets leader's perms
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
