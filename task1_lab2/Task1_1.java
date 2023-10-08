package Task1;

public class Task1_1 {
	public static int getSn1(int n) {
		if(n == 1) {
			return 1;
		}else {
			return (int) (getSn1(n-1) + Math.pow(-1, n+1)*n);
		}
	}
	// tính giai thừa
	public static int giaithua(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}else {
			return giaithua(n-1)*n;
		}
	}
	// tính tổng các giai thừa
	public static int getSn2(int n) {
		if(n == 1) {
			return 1;
		}else {
			return giaithua(n)+getSn2(n-1);
		}
	}
	public static int getSn3(int n) {
		if(n == 1) {
			return 1;
		}else {
			return (int) (getSn3(n-1) + Math.pow(n, 2));
		}
	}
	public static double mauso(int n) {
		if(n == 0) {
			return 1;
		}else {
			return 2*n*mauso(n-1);
		}
	}
	public static double getSn4(int n) {
		if(n == 0) {
			return 1;
		}else {
			return  1/mauso(n)+getSn4(n-1);
		}
	}
	public static void main(String[] args) {
		int n = 3;
		System.out.println(getSn1(n));
		System.out.println(getSn2(n));
		System.out.println(getSn3(n));
		System.out.println(getSn4(n));
	}
}
