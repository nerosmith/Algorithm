package com.nero.main.java.algrorithm.SortingBasic.Selection_Sort_Using_Comparable;

public class Student implements Comparable<Student>{

   private String name;
   private int score;

   public Student(String name,int score){
            this.name = name;
            this.score = score;
        }

   // 定義Student的compareTo函數
   // 如果分數相等，則按照名字的字母序排序
   //如果分數不等，則分數高的靠前
   @Override
   public int compareTo(Student that) {

            if (this.score < that.score)
                return -1;
            else if (this.score > that.score)
                return 1;
            else
                return this.name.compareTo(that.name);

       }

   @Override
   public String toString() {
            return "Student: " + this.name + " " + Integer.toString( this.score );
      }
}
