package org.BigWesleyTracker.Model;

public class StudentImpl extends PersonImpl implements Student {
    private Class _class;
    private String _major;
    private String _smallGroup;

    public StudentImpl(String first_name, String last_name, Class school_class, String major, String small_group) {
        super(first_name, last_name);
        if (major == null) {
            throw new IllegalArgumentException("Cannot have null major");
        }
        _class = school_class;
        _major = major;
        _smallGroup = small_group;
    }

    @Override
    public Class getStudentClass() {
        return _class;
    }

    @Override
    public void promote() {
        switch (_class) {
            case GRADUATE -> throw new UnsupportedOperationException("Cannot promote graduate");
            case SENIOR -> _class = Class.GRADUATE;
            case JUNIOR -> _class = Class.SENIOR;
            case SOPHOMORE -> _class = Class.JUNIOR;
            case FRESHMEN -> _class = Class.SOPHOMORE;
        }
    }

    @Override
    public String getMajor() {
        return _major;
    }

    @Override
    public void setMajor(String new_major) {
        if (new_major == null) {
            throw new IllegalArgumentException("Cannot have null major");
        }
        _major = new_major;
    }

    @Override
    public String getSmallGroup() {
        return _smallGroup;
    }

    @Override
    public void setSmallGroup(String small_group) {
        _smallGroup = small_group;
    }
}
