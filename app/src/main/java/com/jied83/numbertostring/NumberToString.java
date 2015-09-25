package com.jied83.numbertostring;

import java.lang.reflect.Array;

/**
 * Created by jied83 on 24.09.15.
 */
public class NumberToString {

    private String[] mOneTwenty;
    private String[] mPoint;
    private String[] mTens;

    NumberToString(String[] _oneTwenty, String[] _point, String[] _tens) {
        this.mOneTwenty = _oneTwenty;
        this.mPoint = _point;
        this.mTens = _tens;
    }

/*
*   Translate number to string - devide by 1000 and then translate with translate3digits
*/

    public String translate(long input) {
        String resultString ="";
        int step;
        int dotPoint = 0;
        if (input == 0) {
            resultString = mOneTwenty[0];
            return resultString.trim();
        }
        if (input/1000 ==0) {
            resultString = translate3digits((int)input)+resultString;
        } else {
            while (input > 0) {
                step = (int)(input % 1000);
                if (step!=0) {
                    if (dotPoint == 0)
                        resultString = translate3digits(step) + mPoint[dotPoint] + resultString;
                    if (dotPoint > 0)
                        resultString = translate3digits(step) + " " + mPoint[dotPoint + 1] + resultString;
                }
                input = input / 1000;
                dotPoint++;
            }
        }
        return resultString.trim();
    }

/*
*   Translate 3 digit and less number to string
*/
    public String translate3digits(int input) {
        String resultString;
        if (input == 0) return "";
        if (input%100<20) {
            if (input%100!=0) {
                resultString = " " + mOneTwenty[(input % 100)];
            } else resultString ="";
            input=input/100;
        } else {
            int position = input%10;
            if (position!=0) {
                resultString = " "+ mOneTwenty[(input%10)];
            } else resultString = "";
            input = input/10;
            resultString = " "+ mTens[(input%10)-1]+resultString;
            input = input/10;
        }
        if (input == 0) {
            return resultString;
        } else resultString = " "+ mOneTwenty[input]+" "+mPoint[1]+resultString;
        return  resultString;
    }

    public void setArrays(String[] _oneTwenty, String[] _point, String[] _tens) {
        this.mOneTwenty = _oneTwenty;
        this.mPoint = _point;
        this.mTens = _tens;
    }
}
