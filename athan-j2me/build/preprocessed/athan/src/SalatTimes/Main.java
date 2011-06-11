package athan.src.SalatTimes;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        double time=System.currentTimeMillis();
        double temkin[]={-2,-7,7,5,7,3};       
        SalatTimes salatIstanbul=new SalatTimes(28.96,41.02,2,0,time,18,17);
        System.out.println("Imsak = "+ hourtoString(salatIstanbul.fajr+temkin[0]/60));
        System.out.println("Gunes = "+hourtoString ( salatIstanbul.sunRise+temkin[1]/60));
        System.out.println("Ogle = "+ hourtoString (salatIstanbul.dzhur+temkin[2]/60));
        System.out.println("Ikindi= "+hourtoString (salatIstanbul.asr_shafi+temkin[3]/60));
        System.out.println("Aksam = "+hourtoString(salatIstanbul.magrib+temkin[4]/60));
        System.out.println("Yatsi = "+hourtoString (salatIstanbul.isha+temkin[5]/60));
        
        
 
    }
    /**
     *  Saat cinsinden girilen degeri saat formatinda stringe donusturur
     *  Orgengin 16.50 olan sayiyi 16:30 olarak goruntuler.
     *
     * @param  double saat.
     * @return Saat formatinda string doner.
     */
   static String hourtoString (double hour)
    {
        String minuteStr, hourStr;
        int minute = (int) ( (hour - (int) hour) * 60);
        if (hour < 10)
            hourStr = "0" + (int)hour;
        else
            hourStr = "" + (int)hour;
        if (minute < 10)
            minuteStr = ":0" + minute;
        else
            minuteStr = ":" + minute;
        return hourStr + minuteStr;
    }
 //Diyanetin -1 derece olan gunes batisindaki aciyi ayarlamak icin H=23.078748266325606889850426463134 metre
}
