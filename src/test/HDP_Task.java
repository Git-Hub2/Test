package test;

import java.time.LocalDate;


public class HDP_Task {

    public static void main(String[] args) {
        Integer firstAmount = 10;
        Integer adjustedAmount = 21; //01 02//10//20 //30
        Integer finalAmount = 10;
        LocalDate firstDate = LocalDate.of(2021, 23, 11);
        LocalDate secondDate = LocalDate.of(2021, 02, 11);
        LocalDate thirdDate = LocalDate.of(2021, 03, 11);

        System.out.println(check_routine(firstAmount, firstDate, adjustedAmount, secondDate, finalAmount, thirdDate));

    }
    //Used String because of we need 0 in beginning
    public static Object check_routine(Integer initialAmount, LocalDate firstDate, Integer adjustedAmount, LocalDate secondDate, Integer finalAmount, LocalDate thirdDate) {

        String initialValue = "";
        int counter=0;
    /*The routine must first ensure that the associated dates do not run backwards;
     the second date must not be earlier than the first
     and the third date must not be earlier than the second.
     If this rule is broken, return with a code of 99, and don’t check any further.*/

        if (secondDate.isBefore(firstDate) || thirdDate.isBefore(secondDate)) {
            initialValue = "99";
            return initialValue;
        }
            //First amount => If the amount has increased overall then set the initial value of the code to 01
         if (adjustedAmount > initialAmount || finalAmount > initialAmount || finalAmount > adjustedAmount) {
            initialValue += "01" + "10"; //If the amount has ever increased then add a value of 10 to the code so far.
             counter+=10;
            //Second amount => If the amount has decreased overall then set the initial value of the code to 02
        }
         if (adjustedAmount < initialAmount || finalAmount < initialAmount || finalAmount < adjustedAmount) {
             initialValue += "02" + "20"; //If the amount has ever decreased add a value of 20 to the code so far
             counter+=20;
         }
         if (initialAmount == adjustedAmount && initialAmount == finalAmount) {
             initialValue += "03"; //If the amount has ever decreased add a value of 20 to the code so far
            }
            // Third amount If the amount has stayed the same overall then set initial value of the code to 03

        Object finalValue = initialValue+counter;
      return finalValue;

  }


}
