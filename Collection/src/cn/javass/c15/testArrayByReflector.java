package cn.javass.c15;

import java.lang.reflect.Array;

public class testArrayByReflector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testArrayByReflector test=new testArrayByReflector();
		//test.testString();
		test.testInteger();
	}
	
	public void testString(){
		try {
			Class clz=Class.forName("java.lang.String");
			Object object=Array.newInstance(clz, 10);
			Array.set(object, 5, "this is array creation by reflector");
			String str=(String)Array.get(object, 5);
			System.out.println("array creation by reflector length is "+Array.getLength(object));
			System.out.println(str);
			//System.out.println(clz);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testInteger(){
		int dims[]={5,10,15};
		Object arr=Array.newInstance(Integer.TYPE, dims);
		//int a[][][]=new int[5][10][15];
		Object arrobj=Array.get(arr, 3);//一维中的多维数组，取一维里的第三个元素多维数组
		//int a2[][]=a[3];
		arrobj=Array.get(arrobj, 5);
		//int a3[]=a2[5]
		
		Array.setInt(arrobj, 10, 37);
		int arrcast[][][]=(int[][][])arr;
		System.out.println(arrcast[3][5][10]);
		
	}

}
