import util.IOUtil;

import java.io.Console;
import java.util.Scanner;

public class App {

    private static final String WELCOME_STRING = "Welcome to password box";
    private static final String SEPARATOR_STRING = "======================";
    private static final String INPUT_PASSWORD_STRING="Please input main password";
    private int retryTimes = 3;

    public static void main(String[] args) {
        IOUtil.PRINT(WELCOME_STRING);
        IOUtil.PRINT(SEPARATOR_STRING);

        Console console = System.console();
        if (console == null) {
            throw new IllegalStateException("Console is not available!");
        }

        char[] mainPwdCharArr=console.readPassword(INPUT_PASSWORD_STRING);
        String mainPwd=mainPwdCharArr.toString();

        if(mainPwd.equals("wh")){
            IOUtil.PRINT("correct");
        }else{
            IOUtil.PRINT("wrong");
        }
    }

    private boolean validateMainPwd(String mainPwd){
        //todo read cryptographic main password
        String MAIN_PWD="wh";
        if(mainPwd.equals(MAIN_PWD)){
            return true;
        }
        return false;
    }
}
