package anagramsproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramsProblem {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str1=input.next().toLowerCase();
        String str2=input.next().toLowerCase();
        if(str1.length()!=str2.length()){
            System.out.println('N');
        }
        else {
            int n=str1.length();
            Map<Character,Integer>map=new HashMap<>();
            for(int i=0;i<n;i++){
                if(map.containsKey(str1.charAt(i))){
                    map.put(str1.charAt(i),map.get(str1.charAt(i))+1);
                }
                else {
                    map.put(str1.charAt(i),1);
                }
            }

            for(int i=0;i<n;i++){
                if(map.containsKey(str2.charAt(i))){
                    map.put(str2.charAt(i),map.get(str2.charAt(i))-1);
                    if(map.get(str2.charAt(i))==0){
                        map.remove(str2.charAt(i));
                    }
                }

            }
            if(map.isEmpty()){
                System.out.println('Y');
            }
            else {
                System.out.println('N');
            }

        }

    }
}


