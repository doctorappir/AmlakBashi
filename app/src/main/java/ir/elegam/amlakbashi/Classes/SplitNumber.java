package ir.elegam.amlakbashi.Classes;

/**
 * Created by Mehrdad Latifi on 11/16/2016.
 */

public class SplitNumber {

    public String splitNumber(String number){
        String temp = number;
        number = "";
        Byte counter = 0;
        for(int i=temp.length()-1;i>-1;i--)
        {
          if(counter == 3)
          {
              number+=",";
              number+=temp.charAt(i);
              counter = 1;
          }
            else
          {
              number+=temp.charAt(i);
              counter++;
          }
        }
        number = new StringBuffer(number).reverse().toString();
        return number;
    }
}
