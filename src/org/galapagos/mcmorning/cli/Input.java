package org.galapagos.mcmorning.cli;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);


    //Facade Pattern
    public static String read(String title){
        System.out.print(title);
        return sc.nextLine();
    }
}
