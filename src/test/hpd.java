package test;

import java.time.LocalDate;

public class hpd {
                                      //    >Amounts<         >Dates<   Three pairs
  // The first pair is the initial amount, and when it occurred;
  static Object[] initialAmount = new Object[]{110, LocalDate.of(2021, 1, 11)}; //1st INITIAL AMOUNT
  // The second amount is the adjusted amount and when it occurred
  static Object[] adjustedAmount = new Object[]{10, LocalDate.of(2021, 2, 12)}; //2nd ADJUSTED AMOUNT
  // The third pair is the final amount and when it occurred.
  static Object[] finalAmount = new Object[]{10, LocalDate.of(2021, 3, 13)}; //3rd FINAL AMOUNT

  public static void main(String[] args) {

    String result = check_routine(initialAmount, adjustedAmount, finalAmount);
    System.out.println("Final Value = " + result);

 }
//Used String because of we need 0 in beginning
  public static String check_routine(Object[] initialDate, Object[] arg_2, Object[] arg_3) {

    String result = "";
    /*The routine must first ensure that the associated dates do not run backwards;
     the second date must not be earlier than the first
     and the third date must not be earlier than the second.
     If this rule is broken, return with a code of 99, and don’t check any further.*/

    if (((LocalDate) initialDate[1]).isAfter((LocalDate) arg_2[1]) ||
        ((LocalDate) arg_2[1]).isAfter((LocalDate) arg_3[1])) {
      return "99";
    }
    //First amount => If the amount has increased overall then set the initial value of the code to 01
    if ((int) initialDate[0] < (int) arg_2[0] && (int) arg_2[0] < (int) arg_3[0]) {
      return "01";
    }
// Second amount => If the amount has decreased overall then set the initial value of the code to 02
    if ((int) initialDate[0] > (int) arg_2[0] && (int) arg_2[0] > (int) arg_3[0]) {
      return "02";
    }
 // Third amount If the amount has stayed the same overall then set initial value of the code to 03
    if ((int) initialDate[0] == (int) arg_2[0] && (int) arg_2[0] == (int) arg_3[0]) {
      return "03";
    }
    //ADD VALUE Can be add 20 as Numeric as addition or can be as String Value as Concat
//If the amount has ever increased then add a value of 10 to the code so far.
    if ((int) initialDate[0] > (int) arg_2[0]) {
      result += "20";
    } else if ((int) initialDate[0] < (int) arg_2[0]) {
      result += "10";
    }

 //If the amount has ever decreased add a value of 20 to the code so far
    if ((int) arg_2[0] > (int) arg_3[0]) {
      result += "20";
      //If the amount has ever decreased add a value of 20 to the code so far
    } else if ((int) arg_2[0] < (int) arg_3[0]) {
      result += "10";
    }

    return result;

  }


}
