package lianxi;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class huitui {
    public static void main(String[] args) throws Exception{
        String str="www.www.cn";
        PushbackInputStream push=null;
        ByteArrayInputStream bai=null;
        bai=new ByteArrayInputStream(str.getBytes());
        push=new PushbackInputStream(bai);
        System.out.print("读取之后的数据为:");
        int temp=0;
        while ((temp=push.read())!=-1){
            if (temp=='.'){
                push.unread(temp);
                temp=push.read();
                System.out.print("(退回"+(char)temp+"）");
            }
            else{
                System.out.print((char)temp);
            }
        }
    }
}
