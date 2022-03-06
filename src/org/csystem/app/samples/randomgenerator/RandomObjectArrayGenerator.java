package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.IntValue;
import org.csystem.util.StringUtil;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

import java.util.Random;

//String, Date, Time, Integer, Character, int[]

public class RandomObjectArrayGenerator {
    private final Object [] m_objects;
    private final Random m_random;

    public RandomObjectArrayGenerator(int n){
        m_objects = new Object[n];
        m_random = new Random();
    }

    public Object getRandomObject() {
        Object obj;

        switch (m_random.nextInt(6)){
            case 0:
                obj = StringUtil.getRandomTextTR(m_random,m_random.nextInt(20 + 1));
                break;
            case 1:
                obj = Date.of(m_random);
                break;
            case 2:
                obj = Time.of();
                break;
            case 3:
                obj = m_random.nextInt(50);   //auto_boxing ve sonrasında upcasting  Integer.valueOf(m_random.nextInt(50));
                break;
            case 4:
                obj = (char)(m_random.nextInt(26) + 'A');  //Character.valueOf((char)(m_random.nextInt(26) + 'A'))
                break;
            default:
                obj = ArrayUtil.generateRandomArray(m_random,5,10,50);
                break;
        }
        return obj;
    }

    public Object[] getObjects() {
        return m_objects;
    }

    public void run() {
        for(int i = 0; i < m_objects.length;i++)
            m_objects[i] = getRandomObject();
    }
}
