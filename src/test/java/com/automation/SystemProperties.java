package com.automation;

public class SystemProperties {
    public static void main(String[] args) {
        String fs = System.getProperty("file.separator");
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.dir")+fs+"src"+fs+"test"+fs+"resources"+fs+"driver"+fs+"BookCover.jpg");
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.currentTimeMillis() % 100);
    }
}
