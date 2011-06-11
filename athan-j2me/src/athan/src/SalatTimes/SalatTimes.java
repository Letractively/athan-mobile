package athan.src.SalatTimes;

/**
 *
 * @author mehmetrg
 */
public class SalatTimes extends SunData{
    public double fajr, sunRise,dzhur, asr_shafi,asr_hanafi,magrib,isha; 
    private double T,D,Z,U,U2,V1,V2,W,X;
    //Constructors
    //Yapicilar 
     public SalatTimes ()    
     {   //Yalin olarak calistirildigi takdirde Istanbul icin hesaplama yapcaktir*/
    
         this (28.96,41.02,2,0,System.currentTimeMillis(),-18,-17);
     }
     
    public SalatTimes (double longitude, double latitude, double timeZone, double H, double time,double G1, double G2)    
            
    {   //Formulation is done according to the http://www.ummah.net/astronomy/saltime/   
        double B;
        double R=timeZone*15;
        double jCentury=calculateJulianCentury (time);
        T =calculateEquationOfTime(jCentury);
        D =calculateSunDeclination(jCentury);
        
        D=Math.toRadians(D);G1=Math.toRadians(G1);G2=Math.toRadians(G2);B=Math.toRadians(latitude);
        
        Z = 12+(R-longitude)/15-T/60;
   
        U = Math.toDegrees(acos(( Math.sin (Math.toRadians(-0.8333-0.0347 * Math.sqrt(H)) )-Math.sin(D)* Math.sin(B))/(Math.cos(D) * Math.cos(B))))/15;
        U2 = Math.toDegrees(acos(( Math.sin (Math.toRadians(-1) )-Math.sin(D)* Math.sin(B))/(Math.cos(D) * Math.cos(B))))/15;
        V1= Math.toDegrees(acos(((-Math.sin(G1)-Math.sin(D)*Math.sin(B))/(Math.cos(D)*Math.cos(B)))))/15;
        V2= Math.toDegrees(acos((-Math.sin(G2)-Math.sin(D)*Math.sin(B))/(Math.cos(D)*Math.cos(B)))/15);
        W = Math.toDegrees(acos((Math.sin(atan(1/(1+Math.tan(B-D))))-Math.sin(D)*Math.sin(B))/(Math.cos(D)*Math.cos(B))))/15;
        X = Math.toDegrees(acos((Math.sin(atan(1/(2+Math.tan(B-D))))-Math.sin(D)*Math.sin(B))/(Math.cos(D)*Math.cos(B))))/15;
        
        fajr =Z-V1;
        sunRise= Z-U;
        dzhur = Z;
        asr_shafi = Z+W;
        asr_hanafi = Z+X;
        magrib = Z+U2;
        isha = Z+V2;   
    }    
}
