package athan.web;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class Coordinate extends SoapObject {
    private double lat;

    private double lng;

    public Coordinate() {
        super("", "");
    }
    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat(double lat) {
        return this.lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLng(double lng) {
        return this.lng;
    }

    public int getPropertyCount() {
        return 2;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return new Double(lat);
        case 1: return new Double(lng);
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: lat = Double.parseDouble(__obj.toString()); break;
        case 1: lng = Double.parseDouble(__obj.toString()); break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "lat";
            __info.type = Double.class; break;
        case 1:
            __info.name = "lng";
            __info.type = Double.class; break;
        }
    }

}
