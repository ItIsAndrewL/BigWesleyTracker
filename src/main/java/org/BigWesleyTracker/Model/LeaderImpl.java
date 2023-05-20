package org.BigWesleyTracker.Model;

import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LeaderImpl extends StudentImpl implements Leader {

    private String _position;
    private String _team;
    private String _encryptedPass;
    private final List<Perms> _perms;

    public LeaderImpl(String first_name, String last_name, Class school_class, String major, String small_group,
                      String position, String team, String password) {
        super(first_name, last_name, school_class, major, small_group);
        if (position == null || team == null || password == null) {
            throw new IllegalArgumentException("Cannot have null values");
        }
        _position = position;
        _team = team;
        _encryptedPass = encryptPass(password);
        _perms = new ArrayList<>();
    }

    private static String encryptPass(String raw_pass) {
        // https://www.javatpoint.com/how-to-encrypt-password-in-java
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(raw_pass.getBytes());
            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();
            for (byte aByte : bytes) {
                s.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            return s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Error in password encryption");
        }
    }

    @Override
    public String getPosition() {
        return _position;
    }

    @Override
    public void setPosition(String new_position) {
        if (new_position == null) {
            throw new IllegalArgumentException("Cannot have null position");
        }
        _position = new_position;
    }

    @Override
    public String getTeam() {
        return _team;
    }

    @Override
    public void setTeam(String team) {
        if (team == null) {
            throw new IllegalArgumentException("Cannot have null team");
        }
        _team = team;
    }

    @Override
    public boolean permitLogin(String entered_password) {
        return (encryptPass(entered_password).equals(_encryptedPass));
    }

    @Override
    public void changePassword(String old_password, String new_password) {
        if (permitLogin(old_password)) {
            _encryptedPass = encryptPass(new_password);
        } else {
            throw new IllegalArgumentException("Incorrect old password");
        }
    }

    @Override
    public List<Perms> getPerms() {
        return _perms;
    }

    @Override
    public void addPerm(Perms perm) {
        if (!_perms.contains(perm)) {
            _perms.add(perm);
        }
    }

    @Override
    public void removePerm(Perms perm) {
        if (!_perms.contains(perm)) {
            throw new IllegalArgumentException("Perms list does not contain entered perm");
        }
        _perms.remove(perm);
    }
}
