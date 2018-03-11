package io.com.uitask.models;

/**
 * Created by saipratap on 3/11/18.
 */

public class Reminder {
    private String mTime;
    private Boolean misSet;

    public Reminder(String mTime, Boolean misSet) {
        this.mTime = mTime;
        this.misSet = misSet;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public Boolean getMisSet() {
        return misSet;
    }

    public void setMisSet(Boolean misSet) {
        this.misSet = misSet;
    }
}
