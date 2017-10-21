package cn.javass.c12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
public class FirstIO {

	/**
	 * @param args
	 */
	
	

	public static void writeFile() {

		try {
			// 1 构建管道
			FileOutputStream out = new FileOutputStream(
					"C:/Users/wushensi/Desktop/img/text.txt");
			// 2 读出流
			//byte[] bytes = { 1, 2, 3, 4, 5, 6, 7, 8, 'a' };
			String str="hello world FileOutputStream ";
			out.write(str.getBytes());

			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readFile() {

		try {
			// 1 构建管道
			FileInputStream in = new FileInputStream(
					"C:/Users/wushensi/Desktop/img/text.txt");
			// 2 读出流
			byte bytes[] = new byte[in.available()];
			for (byte b : bytes) {
				System.out.print(b);
			}
			in.read(bytes);
			System.out.println();
			for (byte b : bytes) {
				System.out.print(b);
			}
			System.out.println();
			System.out.println("file content=" + new String(bytes));
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void readObject(){
		
		try {
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("D:/六壬网安/0922/test.txt"));
			try {
				UserModel um=null;
				um=(UserModel)in.readObject();
				System.out.println(um);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeObject(){
		try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("D:/六壬网安/0922/test.txt"));
			UserModel um=new UserModel();
			um.setAge(25);
			um.setName("User1");
			um.setId("User1");
			out.writeObject(um);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//readFile();
		//writeFile();
		//writeObject();
		readObject();
	}

}
