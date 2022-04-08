package src.main.java.lanqiao.a_2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
     某涉密单位下发了某种票据，并要在年终全部收回。
     每张票据有唯一的ID号。全年所有票据的ID号是连续的，但ID的开始数码是随机选定的。 因为工作人员疏忽，在录入ID号的时候发生了一处错误，造成了某个ID断号，另外一个ID重号。 你的任务是通过编程，找出断号的ID和重号的ID。假设断号不可能发生在最大和最小号。要求程序首先输入一个整数N(N<100)表示后面数据行数。
     接着读入N行数据。每行数据长度不等，是用空格分开的若干个（不大于100个）正整数（不大于100000）每个整数代表一个ID号。要求程序输出1行，含两个整数m n，用空格分隔。
     其中，m表示断号ID，n表示重号ID
     例如：
     用户输入：
 2
 5 6 8 11 9
 10 12 9
     则程序输出：7 9
     再例如：
     用户输入：
6
164 178 108 109 180 155 141 159 104 182 179 118 137 184 115 124 125 129 168 196
172 189 127 107 112 192 103 131 133 169 158
128 102 110 148 139 157 140 195 197
185 152 135 106 123 173 122 136 174 191 145 116 151 143 175 120 161 134 162 190
149 138 142 146 199 126 165 156 153 193 144 166 170 121 171 132 101 194 187 188
113 130 176 154 177 120 117 150 114 183 186 181 100 163 160 167 147 198 111 119
     则程序输出：105 120

 总结：
    输入多行数据时，考虑      sc.nextLine(); //吃掉第一个换行符
    Collections.sort        对list排序

 */
public class test_07错误票据 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); //吃掉第一个换行符
        for(int i=0;i<N;i++) { 
            String line = sc.nextLine();
            String[] id = line.split(" ");
            for(int j=0;j<id.length;j++){
                arr.add(Integer.parseInt(id[j]));
            }
        }
        // 对list进行排序
        Collections.sort(arr);
        int m=0;
        int n=0;
        // 遍历list
        for(int i=1;i<arr.size();i++){
            if((arr.get(i) - arr.get(i-1))==0){
                n = arr.get(i);
            }
            if((arr.get(i) - arr.get(i-1))==2){
                m = arr.get(i)-1;
            }
        }
        System.out.println(m+" "+n);
    }
}
