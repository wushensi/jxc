package cn.javass.c6.work;

public class Zy03 {

	public static void main(String[] args) {
		Zy03 zy = new Zy03();
		// zy.NumSummary(25);
		ModelNum mn=new ModelNum();
		System.out.println("递归计算序列前20项的和："+zy.RecursionTest(20,mn));

	}

	public void NumSummary(int number) {
		double NumSum = 0.0d;
		for (int i = 1; i <= number; i++) {
			NumSum += sum(i);
		}
		System.out.println("此数列的前 20 项之和" + NumSum);
	}

	public double sum(int num) {
		int x = 0, y = 0, temp = 0;
		
		for (int i = 1; i <= num; i++) {
			if (i == 1) {
				x = 2;
				y = 1;
			} else {
				temp = x;
				x = (x + y);
				y = temp;
			}
		}
		System.out.println("x/y=" + x + "/" + y);
		return (x / y);
	}
	double RecursionSum=0.0d;
	public double RecursionTest(int num,ModelNum mn) {
		mn.x = 0;
		mn.y = 0;
	    int temp = 0;
			if (num == 1) {
				mn.x = 2;
				mn.y = 1;
			} else {
				this.RecursionTest(num-1, mn);
				temp = mn.x;
				mn.x = (mn.x + mn.y);
				mn.y = temp;
			}
		
		System.out.println("x/y=" + mn.x + "/" + mn.y);
		return RecursionSum+=(mn.x / mn.y);
	}

	public static void JieChen(int num) {
		int sum = 1;
		for (int j = 1; j <= num; j++) {
			sum = sum * j;
		}
		System.out.println(sum);
	}

	public static int JieChen1(int num) {
		if (num == 1) {
			return 1;
		}
		return num * JieChen1(num - 1);
	}
}

class ModelNum{
	public int x;
	public int y;
}
