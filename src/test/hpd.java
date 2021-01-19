package test;

import java.time.LocalDate;

public class hpd {

  static Object[] arg_1 = new Object[]{10, LocalDate.of(2021, 1, 11)};
  static Object[] arg_2 = new Object[]{10, LocalDate.of(2021, 2, 12)};
  static Object[] arg_3 = new Object[]{10, LocalDate.of(2021, 3, 13)};

  public static void main(String[] args) {

    String result = check_routine(arg_1, arg_2, arg_3);
    System.out.println("result = " + result);

  }

  public static String check_routine(Object[] arg_1, Object[] arg_2, Object[] arg_3) {

    String result = "";

    if (((LocalDate) arg_1[1]).isAfter((LocalDate) arg_2[1]) ||
        ((LocalDate) arg_2[1]).isAfter((LocalDate) arg_3[1])) {
      return "99";
    }

    if ((int) arg_1[0] < (int) arg_2[0] && (int) arg_2[0] < (int) arg_3[0]) {
      return "01";
    }

    if ((int) arg_1[0] > (int) arg_2[0] && (int) arg_2[0] > (int) arg_3[0]) {
      return "02";
    }

    if ((int) arg_1[0] == (int) arg_2[0] && (int) arg_2[0] == (int) arg_3[0]) {
      return "03";
    }

    if ((int) arg_1[0] > (int) arg_2[0]) {
      result += "20";
    } else if ((int) arg_1[0] < (int) arg_2[0]) {
      result += "10";
    }

    if ((int) arg_2[0] > (int) arg_3[0]) {
      result += "20";
    } else if ((int) arg_2[0] < (int) arg_3[0]) {
      result += "10";
    }

    return result;

  }


}
