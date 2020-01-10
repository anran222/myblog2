package lianxi;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessT1 {
    //所有的异常直接抛出，程序中不再进行处理
    public static void main(String[] args) throws Exception{
        //指定要操作的对象
        File f=new File(("d:"+File.separator+"test.txt"));
        //声RandomAccessFile类的对象
        RandomAccessFile rdf=null;
        //如果文件不存在，会自动创建
        rdf=new RandomAccessFile(f,"rw");
        String name=null;
        int age=0;
        name="aaaaaaaa" ;//字符串长度为8
        age=30;          //数字的长度为4
        rdf.writeBytes(name);//将名字写入文件之中
        rdf.write(age);//将年龄写入文件之中
        name="bbbb    ";//字符串长度为8
        age=31;          //数字的长度为4
        rdf.writeBytes(name);//将姓名写入文件之中
        rdf.writeInt(age);//将年龄写入文件之中
        name="ccccc    ";//字符串长度为8
        age=32;          //数字的长度为4
        rdf.writeBytes(name);//将姓名写入文件之中
        rdf.writeInt(age);//将年龄写入文件之中
        rdf.close();//关闭
    }
}
