/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpressions;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author SharpSchnitzel
 */

interface Processable<T>{
    void process(T arg);
}

public class LambdaExpressions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("# 1 -> reverse");
        System.out.println("# 2 -> factorial");
        System.out.println("# int ? -> exit");
        
        Processable<Integer> factorial = (arg)-> {
            BigInteger fct = BigInteger.ONE;
            for (int i = 2; i <= arg; i++) {
                fct = fct.multiply(BigInteger.valueOf(i));
            }
            System.out.println("number: " + arg);
            System.out.println("factorial: " + fct);
        };
        Processable<String> reverse = (arg) -> {
            StringBuilder row = new StringBuilder(arg);
            row.reverse();
            System.out.println("initial: " + arg);
            System.out.println("reversed: " + row);
        };
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext() == true) {
            if (scan.hasNextInt()) {
                int idx = scan.nextInt();
                switch (idx) {
                    case 1:
                        scan.nextLine();
                        String string = scan.nextLine();
                        reverse.process(string);
                        break;
                    case 2:
                        if (scan.hasNextInt()) {
                            int number = Math.abs(scan.nextInt());
                            factorial.process(number);
                        } else {
                            System.out.println("NaN");
                            scan.next();
                        }
                        break;
                    default:
                        return;
                }
            } else {
                scan.next();
            }
        }
    }
    
}
