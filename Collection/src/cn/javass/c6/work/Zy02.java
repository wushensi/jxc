/*
 * 2：写一个方法，功能：定义一个一维的 int 数组，长度为 3，把任意三个整数 a,b,c 赋值给
数组,然后将它们按从小到大的顺序输出（使用冒泡排序）
*/
package cn.javass.c6.work;

public class Zy02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list=new int [15];
		initList(list);
		iterator(list);
		sortList(list);
		iterator(list);
	}
	
	//初始化数组
	public static void initList(int list[]){
		for(int i=0;i<list.length;i++){
			list[i]=(int)(Math.random()*10);
		}
	}
	//冒泡排序
	public static void sortList(int list[]){
		int temp;
		for(int i=0;i<list.length;i++){
			for(int j=i;j<list.length;j++){
				if(list[i]>list[j]){
					temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
	}
	//遍历输出
	public static void iterator(int list[]){
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+"\t");
		}
		System.out.println();
	}

}
