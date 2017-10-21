package cn.javass.c9.work;

public class TestObjectArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] array={"1","2",new Object(),new Student()};
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
