package cn.javass.framework.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import cn.javass.jxc.user.vo.UserModel;

/**
 * 
 * @author wushensi
 * 
 */
public class SerialUtil {
	// 先写一个反序列化方法

	/**
	 * 先写一个反序列化方法 给我们一个文件名 我们去读取一个list 但是List是什么 还不知道 UserDAO
	 * 就调用返回List<UserModel><br>bookDAO 就带哦用返回List<BookModel>
	 * 
	 * 先判断传进来的文件名是否存在，只有存在的 才去进行反序列化操作。若不存在，则返回一个空
	 * @param fileName
	 * @return
	 */
	public static List readFromFile(String fileName) {
		final File file = new File(fileName);
		List list=null;
		if (file.exists()) {
			ObjectInputStream input = null;
			try {
				input = new ObjectInputStream(new FileInputStream(fileName));
				list = (List) input.readObject();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (input != null) {
						input.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			list=new ArrayList();
		}
		return list;
	}
	
	public static boolean writeToFile(List list,String fileName) {
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(new FileOutputStream(fileName));
			output.writeObject(list);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
