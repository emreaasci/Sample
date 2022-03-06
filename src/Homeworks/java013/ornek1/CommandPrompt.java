package Homeworks.java013.ornek1;

import org.csystem.util.StringUtil;

import java.util.Scanner;


public class CommandPrompt {
    private static final String [] COMMANDS = {"length","reverse","upper","lower","quit"};
    private static final Scanner scan = new Scanner(System.in);
    private static String m_prompt;

    public CommandPrompt(String prompt){
        m_prompt = prompt;
    }

    private static void doWorkForCommads(String [] str){
        String sentence = "";

        for(int i = 1;i < str.length;i++)
            if(i == str.length - 1)
                sentence += str[i];
            else
                sentence += str[i] + " ";

        switch (str[0]){
            case ("length"):
                lengthProc(sentence);
                break;
            case ("reverse"):
                reverseProc(sentence);
                break;
            case ("upper"):
                upperProc(sentence);
                break;
            case ("lower"):
                lowerProc(sentence);
                break;
            case ("quit"):
                quitProc(sentence);
                break;

        }
    }

    private static void lengthProc(String str){
        System.out.println(str.length());
    }

    private static void reverseProc(String str){
        System.out.println(StringUtil.reverse(str));
    }

    private static void upperProc(String str){
        System.out.println(str.toUpperCase());
    }

    private static void lowerProc(String str){
        System.out.println(str.toLowerCase());
    }

    private static void quitProc(String str){
        System.exit(-1);
    }

    private static String getCommandByText(String text){
        if(text.length() < 3)
            return "";

        for(String strCmd : COMMANDS)
            if(strCmd.startsWith(text))
                return strCmd;

        return "";
    }

    private static void parseCommand(String [] cmdInfo){
        String strCmd = getCommandByText(cmdInfo[0]);

        if(!strCmd.isEmpty()){
            cmdInfo[0] = strCmd;
            doWorkForCommads(cmdInfo);
        }

        else
            System.out.println("Geçersiz Komut");
    }


    public static void run() {
        for(;;){
            System.out.print(m_prompt + ">");
            String cmd = scan.nextLine().trim();
            parseCommand(cmd.split("[ \t]+"));
        }
    }

}
