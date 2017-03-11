/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class AliSort {

    static List<int[]> allSorts = new ArrayList<int[]>();

    public static void main(String[] args) {

        List<Object[]> l = new ArrayList<Object[]>();
        l.add(new String[]{"a1", "b1", "c1"});
        l.add(new String[]{"a2", "b2", "c2"});
        l.add(new String[]{"a3", "b3", "c3"});
        l.add(new String[]{"a4", "b4", "c4"});
        l.add(new String[]{"a5", "b5", "c5"});
        l.add(new String[]{"a6", "b6", "c6"});
        List<String> result = paileizuhe(l);

        for (int i = 0; i < result.size(); i++) {
            System.out.println("" + result.get(i));
        }

    }

    public static List<String> paileizuhe(List<Object[]> list) {
        List<String> x = new ArrayList<String>();
        if (list.size() == 1) {

            for (int i = 0; i < list.get(0).length; i++) {
                x.add(list.get(0)[i] + " ");

            }

        } else if (list.size() == 2) {
            return paileizuhe2(list);
        } else if (list.size() == 3) {
            return paileizuhe3(list);
        } else if (list.size() == 4) {
            return paileizuhe4(list);
        } else if (list.size() == 5) {
            return paileizuhe5(list);
        } else if (list.size() == 6) {
            return paileizuhe6(list);
        }

        return x;

    }

    private static List<String> paileizuhe2(List<Object[]> list) {
        List<String> result = new ArrayList<String>();
        Object[] one = list.get(0);
        Object[] two = list.get(1);

        for (int i = 0; i < one.length; i++) {

            for (int j = 0; j < two.length; j++) {

                result.add(one[i] + " " + two[j]);

            }

        }

        return result;

    }

    private static List<String> paileizuhe3(List<Object[]> list) {
        List<String> result = new ArrayList<String>();
        Object[] one = list.get(0);
        Object[] two = list.get(1);
        Object[] three = list.get(2);

        for (int i = 0; i < one.length; i++) {

            for (int j = 0; j < two.length; j++) {
                for (int k = 0; k < three.length; k++) {
                    result.add(one[i] + " " + two[j] + " " + three[k]);
                }
            }

        }

        return result;

    }

    private static List<String> paileizuhe4(List<Object[]> list) {
        List<String> result = new ArrayList<String>();
        Object[] one = list.get(0);
        Object[] two = list.get(1);
        Object[] three = list.get(2);
        Object[] four = list.get(3);

        for (int i = 0; i < one.length; i++) {

            for (int j = 0; j < two.length; j++) {
                for (int k = 0; k < three.length; k++) {
                    for (int l = 0; l < four.length; l++) {
                        result.add(one[i] + " " + two[j] + " " + three[k] + " " + four[l]);
                    }
                }
            }

        }

        return result;

    }

    private static List<String> paileizuhe5(List<Object[]> list) {
        List<String> result = new ArrayList<String>();
        Object[] one = list.get(0);
        Object[] two = list.get(1);
        Object[] three = list.get(2);
        Object[] four = list.get(3);
        Object[] five = list.get(4);
        for (int i = 0; i < one.length; i++) {

            for (int j = 0; j < two.length; j++) {
                for (int k = 0; k < three.length; k++) {
                    for (int l = 0; l < four.length; l++) {
                        for (int m = 0; m < five.length; m++) {
                            result.add(one[i] + " " + two[j] + " " + three[k] + " " + four[l] + " " + five[m]);
                        }
                    }
                }
            }

        }

        return result;

    }

    private static List<String> paileizuhe6(List<Object[]> list) {
        List<String> result = new ArrayList<String>();
        Object[] one = list.get(0);
        Object[] two = list.get(1);
        Object[] three = list.get(2);
        Object[] four = list.get(3);
        Object[] five = list.get(4);
        Object[] six = list.get(5);
        for (int i = 0; i < one.length; i++) {

            for (int j = 0; j < two.length; j++) {
                for (int k = 0; k < three.length; k++) {
                    for (int l = 0; l < four.length; l++) {
                        for (int m = 0; m < five.length; m++) {
                            for (int n = 0; n < six.length; n++) {
                                result.add(one[i] + " " + two[j] + " " + three[k] + " " + four[l] + " " + five[m] + " " + six[n]);
                            }
                        }
                    }
                }
            }

        }

        return result;

    }
}
