package org.csystem.application.birthdayremainder;

import com.sun.source.tree.BreakTree;
import org.csystem.util.bitwise.BitwiseUtil;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BirthDayRemainder {
    private Calendar m_birtDate;
    private static final double DIVIDE_FOR_AGE = 1000. * 60 * 60 * 24 * 365;

    public BirthDayRemainder(int day,int mount,int year){
        m_birtDate = new GregorianCalendar(year,mount - 1,day);
    }

    public int getDay(){
        return m_birtDate.get(Calendar.DAY_OF_MONTH);
    }

    public int getMount(){
        return m_birtDate.get(Calendar.MONTH);
    }

    public int getYear(){
        return m_birtDate.get(Calendar.YEAR);
    }

    public double getAge(){
        Calendar today = new GregorianCalendar();

        return Math.abs((today.getTimeInMillis() - m_birtDate.getTimeInMillis()) / DIVIDE_FOR_AGE);
    }

    public BirthDateStatus getBirthDayStatus(){
        Calendar today = new GregorianCalendar();
        Calendar birthDay = new GregorianCalendar(today.get(Calendar.YEAR),m_birtDate.get(Calendar.MONTH),m_birtDate.get(Calendar.DAY_OF_MONTH));

        if(birthDay.after(today))
            return BirthDateStatus.AFTER;

        else if (birthDay.before(today))
            return BirthDateStatus.BEFORE;

        else
            return BirthDateStatus.SAME;

    }

}
