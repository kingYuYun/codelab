package leetcode.dianchu;

import java.util.ArrayList;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings=new ArrayList();
    void  prepare(){
        System.out.println("Prepare"+name);
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println("   "+toppings.get(i));
        }
    }
    void bake(){
        System.out.println("bake");
    }
    void cut(){
        System.out.println("cut");
    }
    void box(){
        System.out.println("box");
    }
    public String getName(){
        return name;
    }

}
