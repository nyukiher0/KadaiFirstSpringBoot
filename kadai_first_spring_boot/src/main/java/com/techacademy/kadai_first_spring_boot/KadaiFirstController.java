package com.techacademy.kadai_first_spring_boot;

import java.util.Calendar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {
    /*
     * http://localhost:8080/dayofweek/指定日
     * 「指定日」は任意の日付（形式：yyyymmdd）
     * メソッド名：dispDayOfWeek
     * 実行結果：Tuesday（指定日が20191231の場合）
     */
    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        /*
         * Substring Reference: https://qiita.com/hk_tsuchida/items/9e8823bb0653ab438bb0
         * Calendar Reference:
         * https://qiita.com/noririnsnowflake/items/d74dc5954267ce1552e8
         */
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6)) - 1;
        int day = Integer.parseInt(date.substring(6, 8));
        Calendar cal = Calendar.getInstance();

        cal.set(year, month, day);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            default:
                return "Error: Invalid day of week.";
        }
    }

    /*
     * 足し算
     * http://localhost:8080/plus/数値1/数値2
     * メソッド名：calcPlus
     * 実行結果：9（数値1が6、数値2が3の場合）
     */
    @GetMapping("/plus/{num1}/{num2}")
    public int calcPlus(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    /*
     * 引き算
     * http://localhost:8080/minus/数値1/数値2
     * メソッド名：calcMinus
     * 実行結果：3（数値1が6、数値2が3の場合）
     */
    @GetMapping("/minus/{num1}/{num2}")
    public int calcMinus(@PathVariable int num1, @PathVariable int num2) {
        return num1 - num2;
    }

    /*
     * 掛け算
     * http://localhost:8080/times/数値1/数値2
     * メソッド名：:calcTimes
     * 実行結果：18（数値1が6、数値2が3の場合）
     * 
     */
    @GetMapping("/times/{num1}/{num2}")
    public int calcTimes(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    /*
     * 割り算
     * http://localhost:8080/divide/数値1/数値2
     * メソッド名：calcDivide
     * 実行結果：2（数値1が6、数値2が3の場合）
     */
    @GetMapping("/divide/{num1}/{num2}")
    public int calcDivide(@PathVariable int num1, @PathVariable int num2) {
        return num1 / num2;
    }

}
