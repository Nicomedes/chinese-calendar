/*
 * Algoritmo para dizer o signo no horoscopo chines retirado de:
 * 
 * http://wiki.answers.com/Q/Could_someone_write_a_Java_program_that_tells_you
 * _your_Chinese_Zodiac_sign_when_you_enter_your_day_month_and_year_of_birth
 */
package br.com.ncmds.chineseCalendar.servlet;


import java.util.*;

public class ChineseSign {

    public static String converte(int year) {

        String chineseSign = "";
        
        int x = (1997 - year) % 12;
        if ((x == 1) || (x == -11)) {
            chineseSign = "Rato";
        } else {
            if (x == 0) {
                chineseSign = "Touro";
            } else {
                if ((x == 11) || (x == -1)) {
                    chineseSign = "Tigre";
                } else {
                    if ((x == 10) || (x == -2)) {
                        chineseSign = "Coelho";
                    } else {
                        if ((x == 9) || (x == -3)) {
                            chineseSign = "Dragão";
                        } else {
                            if ((x == 8) || (x == -4)) {
                                chineseSign = "Cobra";
                            } else {
                                if ((x == 7) || (x == -5)) {
                                    chineseSign = "Cavalo";
                                } else {
                                    if ((x == 6) || (x == -6)) {
                                        chineseSign = "Ovelha";
                                    } else {
                                        if ((x == 5) || (x == -7)) {
                                            chineseSign = "Macaco";
                                        } else {
                                            if ((x == 4) || (x == -8)) {
                                                chineseSign = "Galinha";
                                            } else {
                                                if ((x == 3) || (x == -9)) {
                                                    chineseSign = "Cachorro";
                                                } else {
                                                    if ((x == 2) || (x == -10)) {
                                                        chineseSign = "Porco";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        return chineseSign;

    }
}
