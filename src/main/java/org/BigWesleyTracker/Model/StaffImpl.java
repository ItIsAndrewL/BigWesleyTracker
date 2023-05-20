package org.BigWesleyTracker.Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class StaffImpl extends PersonImpl implements Staff {
    private String _position;
    private String _encryptedPassword;
    private final List<Perms> _perms;

    public StaffImpl(String first_name, String last_name, String position, String password) {
        super(first_name, last_name);
        if (position == null || password == null) {
            throw new IllegalArgumentException("Null values");
        }
        _position = position;
        _encryptedPassword = encryptPass(password);
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
            throw new IllegalArgumentException("Null value");
        }
        _position = new_position;
    }

    @Override
    public boolean permitLogin(String entered_password) {
        return (encryptPass(entered_password).equals(_encryptedPassword));
    }

    @Override
    public void changePassword(String old_password, String new_password) {
        if (permitLogin(old_password)) {
            _encryptedPassword = encryptPass(new_password);
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
