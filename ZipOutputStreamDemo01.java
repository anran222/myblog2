import java.io.File ;
import java.io.FileInputStream ;
import java.io.InputStream ;
import java.util.zip.ZipEntry ;
import java.util.zip.ZipOutputStream ;
import java.io.FileOutputStream ;
public class ZipOutputStreamDemo01{
	public static void main(String args[]) throws Exception{	// �����쳣�׳�
		File file = new File("d:" + File.separator + "myfile.txt") ;	// ����Ҫѹ�����ļ�
		File zipFile = new File("d:" + File.separator + "myfile.zip") ;	// ����ѹ���ļ�����
		InputStream input = new FileInputStream(file) ;	// �����ļ���������
		ZipOutputStream zipOut = null ;	// ����ѹ��������
		zipOut = new ZipOutputStream(new FileOutputStream(zipFile)) ;//��ʼ��ѹ���Ķ���
		zipOut.putNextEntry(new ZipEntry(file.getName())) ;	// ����ZipEntry����
		zipOut.setComment("javaZipDemo") ;	// ����ע��
		int temp = 0 ;
		while((temp=input.read())!=-1){	// ��ȡ����
			zipOut.write(temp) ;	// ѹ�����
		}
		input.close() ;	// �ر�������
		zipOut.close() ;	// �ر������
		System.out.println("ZipOutputStreamDemo01 over!\n");
	}
};
//1.���������ļ�file      myfile.txt
//2.ָ��ѹ���ļ�zipFile 	 myfile.zip
//3.�����ļ�������  input <-- file
//4.����ѹ��������  zipOut  <--- zipFileѹ���ļ�����
//5.����ZipEntry���� zipOut.putNextEntry(new ZipEntry(file.getName()));
//6.��      ������     ---->д      ѹ���� 