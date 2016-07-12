package com.ronyalvarez.finalapp;

/**
 * Created by Thomas Croteau on 7/9/2016.
 */
public class Config {
    private boolean phone=false;
    private boolean gps=false;
    private boolean sms=false;

    public Config() {
    }

    public boolean isPhone() {
        return phone;
    }

    public void setPhone(boolean phone) {
        this.phone = phone;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isSms() {
        return sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }
}
