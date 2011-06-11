package athan.web;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class LocationException extends SoapObject {
    private java.lang.String message1;

    public LocationException() {
        super("", "");
    }
    public void setMessage1(java.lang.String message1) {
        this.message1 = message1;
    }

    public java.lang.String getMessage1(java.lang.String message1) {
        return this.message1;
    }

    public int getPropertyCount() {
        return 1;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return message1;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: message1 = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "message1";
            __info.type = java.lang.String.class; break;
        }
    }

}
