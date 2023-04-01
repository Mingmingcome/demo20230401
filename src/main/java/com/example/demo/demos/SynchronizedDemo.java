package com.example.demo.demos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @who luhaoming
 * @when 2020/8/11 20:47
 * @what
 */
public class SynchronizedDemo {

    private static List<Map<String, String>> list = new ArrayList<>();

    private static int i = 0;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            try {
                getList();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
//                setList();
            setList2();
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }

    public static List<Map<String, String>> getList() throws IOException, ClassNotFoundException, InterruptedException {
        synchronized (SynchronizedDemo.class) {
            List<Map<String, String>> res = deepCopy(SynchronizedDemo.list);
            SynchronizedDemo.list.clear();
            System.out.println("sleep 6 s start");
            Thread.sleep(6000);
            System.out.println("sleep 6 s end");
            return res;
        }
    }

    public static void setList() {
        HashMap<String, String> map = new HashMap<>();
        map.put(String.valueOf(i++), "2");
        System.out.println(map);
        SynchronizedDemo.list.add(map);
    }

    public static void setList2() {
        synchronized (SynchronizedDemo.class) {
            HashMap<String, String> map = new HashMap<>();
            map.put(String.valueOf(i++), "2");
            System.out.println(map);
            SynchronizedDemo.list.add(map);
        }
    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }
}
