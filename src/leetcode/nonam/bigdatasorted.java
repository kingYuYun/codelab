package leetcode.nonam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bigdatasorted {
 public static void main(String[] args) throws IOException {
        File file = new File("\\text.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str;
        Map<String,Shanp> map =new HashMap<>();
        List<Shanp> list = new ArrayList<>();
        while((str=br.readLine())!=null){
            if(map.get(str)==null){
                map.put(str, new Shanp(str,0));
                list.add(map.get(str));
            }else{
                map.get(str).sum++;
            }
        }
        list.sort(new Comparator<Shanp>() {
             
            @Override
            public int compare(Shanp o1, Shanp o2) {
                if(o1.sum<o2.sum){
                    return 0;
                }return -1;
            }
        });
         
        System.out.println(list);
    }
}

class Shanp {
    String id;
    Integer sum;

    public Shanp(String id, Integer sum) {
        super();
        this.id = id;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Shanp [id=" + id + ", sum=" + sum + "]";
    }
}
