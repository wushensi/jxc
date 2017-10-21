package cn.javass.c12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyFile {

	/**
	 * @param args
	 */
	
	private static String[] strFileName=null;
	private static File flag=null;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//testFileProperties();
		testFileList();
	}
	
	public static void testFileList() throws IOException{
		/*File f=new File("E:/");
		String[] strFileName1=f.list();
		for(String fileName:strFileName1){
			System.out.println(fileName);
		}*/
		OutputStream out=new FileOutputStream("D:/¡˘»…Õ¯∞≤/0922/fileList.txt");
		testDirectory("E:/",out);
		out.close();
	}
	public static void testDirectory(String str,OutputStream out) throws IOException{
		File f=new File(str);
		if(f.isDirectory()){
			strFileName=f.list();
			for(String fileName:strFileName){
				if(fileName.equals("System Volume Information")){
					continue;
				}
				fileName=str+fileName;
				flag=new File(fileName);
				System.out.println(fileName);
				if(flag.isDirectory()){
					out.write((str+"\n").getBytes("gb2312"));
					testDirectory(fileName+"/",out);
				}else{
					
					out.write((fileName+"\n").getBytes("gb2312"));
					System.out.println(fileName);
				}
			}
		}else{
			out.write((str+"\n").getBytes("gb2312"));
			System.out.println(str);
		}
	}
	
	public static void testFileProperties(){
		File file=new File("D:/¡˘»…Õ¯∞≤/0922/a/b/c/abc.txt");
		String name=file.getName();
		String path=file.getPath();
		String parentPath=file.getParent();
		boolean isFile=file.isFile();
		boolean canRead=file.canRead();
		
		if(!file.exists()){
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("name="+name+"  "+"path="+path+"  "+"parentPath="+parentPath+"  "+"isFile="+isFile+"  "+"canRead="+canRead);
	}

}
