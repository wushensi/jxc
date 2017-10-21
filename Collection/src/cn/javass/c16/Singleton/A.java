package cn.javass.c16.Singleton;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class A {
	// 5 用来保存自己的类实例

	// 因为getInstance方法是静态的，调用静态方法只能调用静态变量
	private static A a = null;

	// 收回外部能够new A()的权限
	private A() {

	}

	// 2 主动给外部调用提供自己的实例

	// 3 外部无法new 通过类方法调用 加static关键字
	public static A getInstance() {
		// 4 想办法通过内部控制调用构造方法次数
		// 7 在第一次调用时初始化
		if (a == null) {
			// 8: 真正初始化
			a = new A();
		}

		return a;
	}

	// 1 定义用来缓存数据的容器
	private Map<String, A> map = new HashMap<String, A>();

	public A getInstance2() {
		// 2 到缓存里面查找需要使用的数据
		A a = map.get("one");
		// 3 如果找不到 就新建一个数据（获取一个数据）并缓存到容器中
		if (a == null) {
			a = new A();
			map.put("one", a);
		}
		// 4 如果找到就返回
		return a;
	}

	// 1: 定义用来缓存数据的容量
	private static Map<Integer, A> map1 = new HashMap<Integer, A>();
	// 用来记录当前正在使用哪一个实例，初始为1
	private static int num = 1;
	// 用来记录需要控制的 实例总数为3个
	private static int count = 3;

	// 1 定义用来缓存数据的容器
	public static A getInstance3() {
		// 2 到缓存里面查找需要使用的数据
		A a = map1.get(num);
		// 3 如果找不到 就新建一个数据（获取一个数据）并缓存到容器中
		if (a == null) {
			a = new A();
			map1.put(num, a);
		}
		// 每调用一次，就把num加1
		num++;
		// 若num超过控制的总数，那么把num设置为1，开始循环重复使用
		if (num > count) {
			num = 1;
		}
		// 4 如果找到就返回
		return a;
	}

	public static void main(String[] args) {
		A a1 = A.getInstance3();
		A a2 = A.getInstance3();
		A a3 = A.getInstance3();
		A a4 = A.getInstance3();
		A a5 = A.getInstance3();
		A a6 = A.getInstance3();
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);
		System.out.println(a6);
		//Calendar calendar=Calendar.getInstance();
	}

}
