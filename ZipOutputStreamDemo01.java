import java.io.File ;
import java.io.FileInputStream ;
import java.io.InputStream ;
import java.util.zip.ZipEntry ;
import java.util.zip.ZipOutputStream ;
import java.io.FileOutputStream ;
public class ZipOutputStreamDemo01{
	public static void main(String args[]) throws Exception{	// 所有异常抛出
		File file = new File("d:" + File.separator + "myfile.txt") ;	// 定义要压缩的文件
		File zipFile = new File("d:" + File.separator + "myfile.zip") ;	// 定义压缩文件名称
		InputStream input = new FileInputStream(file) ;	// 定义文件的输入流
		ZipOutputStream zipOut = null ;	// 声明压缩流对象
		zipOut = new ZipOutputStream(new FileOutputStream(zipFile)) ;//初始化压缩的对象
		zipOut.putNextEntry(new ZipEntry(file.getName())) ;	// 设置ZipEntry对象
		zipOut.setComment("javaZipDemo") ;	// 设置注释
		int temp = 0 ;
		while((temp=input.read())!=-1){	// 读取内容
			zipOut.write(temp) ;	// 压缩输出
		}
		input.close() ;	// 关闭输入流
		zipOut.close() ;	// 关闭输出流
		System.out.println("ZipOutputStreamDemo01 over!\n");
	}
};
//1.定义输入文件file      myfile.txt
//2.指定压缩文件zipFile 	 myfile.zip
//3.定义文件输入流  input <-- file
//4.创建压缩流对象  zipOut  <--- zipFile压缩文件名称
//5.设置ZipEntry对象 zipOut.putNextEntry(new ZipEntry(file.getName()));
//6.读      输入流     ---->写      压缩流 