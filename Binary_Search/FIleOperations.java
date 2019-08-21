package com.nero.main.java.algorithm.Binary_Search;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class FIleOperations {

    // 讀取文件名稱為filename中的內容，並將其中包含的所有詞語放進詞中
    public static boolean readFile(String filename, Vector<String> words){

            if (filename == null){
                    System.out.println("filename is null");
                    return false;
                }

            // 文件讀取
            Scanner scanner;

            try{
                    File file = new File(filename);
                    if (file.exists()){
                        FileInputStream fis = new FileInputStream(file);
                        scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
                        scanner.useLocale(Locale.ENGLISH);
                      }
                    else
                        return false;
                }
            catch (IOException ioe){
                    System.out.println("Cannot open "+filename);
                    return false;
                }


            // 簡單分詞
            // 這個分詞方式相對簡陋, 沒有考慮很多文本處理中的特殊問題
            // 在這裡只做demo展示用
            if (scanner.hasNextLine()){
                    String content = scanner.useDelimiter("\\A").next();
                    int start = firstCharacterIndex(content,0);
                     for (int i = start+1; i <= content.length();) {
                            if (i == content.length() || !Character.isLetter(content.charAt(i))){
                                    String word = content.substring(start,i).toLowerCase();
                                    words.add(word);
                                    start = firstCharacterIndex(content,0);
                                    i = start + 1;
                                }
                            else
                                i++;
                         }
                }

            return true;
        }

    // 尋找字符串s中，從start的位置開始的第一個字母字符的位置
    private static int  firstCharacterIndex(String s,int start){
            for (int i = start; i < s.length(); i++)
                if (Character.isLetter(s.charAt(i)))
                    return i;
            return s.length();
        }
}
