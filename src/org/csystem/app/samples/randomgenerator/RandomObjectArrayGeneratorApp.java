package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.IntValue;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

public class RandomObjectArrayGeneratorApp {
    public RandomObjectArrayGeneratorApp(){

    }

    public static void run() {
        RandomObjectArrayGenerator rag = new RandomObjectArrayGenerator(5);
        rag.run();

        for (Object object : rag.getObjects()) {
            String typeName = object.getClass().getName();
            System.out.printf("Dinamik Tür İsmi: %s%n",typeName);

            if(typeName.equals("java.lang.String")){  // object instanceof String
                String s = (String)object;

                System.out.printf("yazı:%s%n",s);
                System.out.printf("yazı:%s%n",s.toUpperCase());
            }

            else if(object instanceof Date){  // object instanceof Date
                Date date = (Date)object;

                System.out.println(date.toLongDateStringTR());
            }

            else if(object instanceof Time){  // object instanceof Time
                Time time = (Time) object;

                System.out.println(time.toLongTimeString());
            }

            else if(object instanceof Integer){  // object instanceof IntValue
                int val = (int)object; //auto-unboxing  (Integer)object

                System.out.printf("%d * %d = %d%n", val , val, val * val);
            }

            else if(object instanceof Character){
                char ch = (char) object;  //auto-unboxing ((Character)object).charValue()

                System.out.printf("Char: %c%n",ch);
            }

            else {   // object instanceof int[]
                int [] a = (int[])object;

                ArrayUtil.display(2,a);
            }

            System.out.println("----------------------------");
        }

    }

}
