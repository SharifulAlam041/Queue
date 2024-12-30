package org.example;

public class Bus implements Comparable<Bus>{
    String busName;
    String busType;
    Bus(String busName,String busType){
        this.busName = busName;
        this.busType = busType;
    }

    @Override
    public int compareTo(Bus o) {
//        return this.busType.compareTo(o.busType);
        return o.busType.compareTo(this.busType);
    }
}
