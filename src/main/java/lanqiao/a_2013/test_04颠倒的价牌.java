package src.main.java.lanqiao.a_2013;

import java.util.ArrayList;

/**
 小李的店里专卖其它店中下架的样品电视机，可称为：样品电视专卖店。其标价都是4位数字（即千元不等）。
     小李为了标价清晰、方便，使用了预制的类似数码管的标价签，只要用颜色笔涂数字就可以了（参见p1.jpg）。
     这种价牌有个特点，对一些数字，倒过来看也是合理的数字。如：1 2 5 6 8 9 0 都可以。这样一来，如果牌子挂倒了，有可能完全变成了另一个价格，
     比如：1958 倒着挂就是：8561，差了几千元啊!! 当然，多数情况不能倒读，比如，1110 就不能倒过来，因为0不能作为开始数字。
     有一天，悲剧终于发生了。某个店员不小心把店里的某两个价格牌给挂倒了。并且这两个价格牌的电视机都卖出去了!
     庆幸的是价格出入不大，其中一个价牌赔了2百多，另一个价牌却赚了8百多，综合起来，反而多赚了558元。
     请根据这些信息计算：赔钱的那个价牌正确的价格应该是多少？
     答案是一个4位的整数，请通过浏览器直接提交该数字。

 */
public class test_04颠倒的价牌 {
    public static void main(String[] args) {
    ArrayList<Price> a1 = new ArrayList<Price>();
		ArrayList<Price> a2 = new ArrayList<Price>();
		//枚举数字
		for(int i=1001;i<10000;i++) {
			String s = String.valueOf(i);
			if(s.contains("3")||s.contains("4")||s.contains("7")) continue;
		//翻转，作差，-200一个list，+500一个list
			String s1 = reverse(s);
			Integer i1 = Integer.parseInt(s1);
			int plus = i1-i;
			if(plus<-200 && plus>-300) {
				a1.add(new Price(i,plus));
			}
			if(plus<900 && plus>800) {
				a2.add(new Price(i,plus));
			}
		// 寻找结果	
			for (Price price : a1) {
				for (Price price2 : a2) {
					if(price.plus+price2.plus==558) {
						System.out.println(price.p+"   "+price.plus);
						System.out.println(price2.p+"   "+price2.plus);
					}
				}
			}
		}
	}

	private static String reverse(String s) {
		// TODO Auto-generated method stub
		char[] s1 = s.toCharArray();
		char[] ans =new char[4];
		for(int i=s.length()-1,j=0;i>=0;i--,j++) {
			char c = s1[i];
			if(c=='9') {
				ans[j]='6';
			}else if(c=='6') {
				ans[j]='9';
			}else {
				ans[j]=c;
			}
		}
		return new String(ans);
	}
	private static class Price{
		int p;
		int plus;
		public Price(int p, int plus) {
			this.p = p;
			this.plus = plus;
		}	
	}
}
