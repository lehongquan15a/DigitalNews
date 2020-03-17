/*
* NumberHelper.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
*/
package Utility;

/**
 * NumberHelper.<br>
 * 
 * <pre>
 Class dùng để sử lý số
 Trong class này sẽ tiến hành các xử lí dưới đây.
 
 . getInt.
  
  
 </pre>
 * 
 * @author FU QuanLHHE130736
 * @version 1.0
 */
public class NumberHelper {
    /**
     * getInt.<br>
     * Truyền vào chuỗi, kiểm tra nếu là số thì trả về số, ngược lại trả về -1
     * 
     * @param strNumber
     * @return a number
     */
    public static int getInt(String strNumber) {
        int num;
        try {
            num = Integer.parseInt(strNumber);
        } catch (NumberFormatException e) {
            num = -1;
        }
        return num;
    }

}
