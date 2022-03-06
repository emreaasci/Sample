package org.csystem.app.samples.studentinfoparser;

import java.util.Scanner;

public class StudentInfoParserConsoleApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine();

            if ("quit".equals(str))
                break;
            StudentInfoParser parser = new StudentInfoParser(str);
            StudentInfo studentInfo = parser.getStudentInfo();

            System.out.println(studentInfo.toString());
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}