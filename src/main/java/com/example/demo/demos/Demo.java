package com.example.demo.demos;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * @who luhaoming
 * @when 2022/9/15 20:26
 * @what TODO
 */
public class Demo {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        format.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai")));
        format.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));
        System.out.println(format.format(new Date(1670037101000L)));
    }
}
