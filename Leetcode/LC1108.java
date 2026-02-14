package com.Leetcode;

public class LC1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }
}
