
//the formatterTC class provides the current date and time to the tradeChecker class for printing usage.

import java.io.IOException;
import java.util.*;
import java.util.GregorianCalendar;

 class formatterTC {
     public int year, month, day, hour, minute, second;
    GregorianCalendar date = new GregorianCalendar();


     public formatterTC () throws IOException {                                        //formatterTC constructor
        day = date.get(Calendar.DAY_OF_MONTH);                      //"gets" day
        month = date.get(Calendar.MONTH);                           //"gets" month
        year = date.get(Calendar.YEAR);                             //"gets" year
        second = date.get(Calendar.SECOND);                         //"gets" second
        minute = date.get(Calendar.MINUTE);                         //"gets" minute
        hour = date.get(Calendar.HOUR_OF_DAY);}                     //"gets" hour

            public formatterTC (int year, int month, int day, int hour, int minute, int second){
                this.year = year;                                   //use of "this" reference variable 1
                this.month = month;                                 //use of "this" reference variable 2
                this.day = day;                                     //use of "this" reference variable 3
                this.hour = hour;                                   //use of "this" reference variable 4
                this.minute = minute;                               //use of "this" reference variable 5
                this.second = second;                               //use of "this" reference variable 6
                }

                public String toString(){                           //value returning method
                    return (month+1)+"/"+day+"/"+year+"\t"+hour+":"+minute+":"+second;
                }



 }



