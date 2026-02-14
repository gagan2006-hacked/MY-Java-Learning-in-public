package com.Leetcode;

public class LC38 {
    public static String countAndSay(int n) {
        StringBuilder builder=new StringBuilder("1");
        for (int i = 2; i <=n; i++) {
            Capsule capsule=new Capsule();
            StringBuilder st=new StringBuilder(builder);
            builder.setLength(0);
            for (int j = 0; j <st.length(); j++) {
                int num=st.charAt(j)-'0';
                if (capsule.getValue()==0){
                    capsule.setValue(num);
                    capsule.setCount(1);
                } else if (capsule.getValue() == num) {
                    capsule.setCount(capsule.getCount()+1);
                }else {
                    int prevNum=capsule.getValue();
                    int prevCount=capsule.getCount();
                    builder.append(prevCount+""+prevNum);
                    capsule.setValue(num);
                    capsule.setCount(1);
                }
            }
            if (capsule.getValue()!=0){
                int prevNum=capsule.getValue();
                int prevCount=capsule.getCount();
                builder.append(prevCount+""+prevNum);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(30));
    }
}
