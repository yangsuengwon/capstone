package com.example.capstoneproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Product_save_list {
    String[] product_name = new String[500];
    String[] product_date = new String[500];
    String[] product_img_url = new String[500];
    String[] product_afterservice = new String[500];

    public void save_file_export()
    {
        try {
            File file = new File("\\Writer.txt");       //가변 파일 저장 경로
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if(file.isFile() && file.canWrite()){


                for(int i = 0;product_name[i] != null; i++)//배열에 저장된 4개의 데이터를 파일로 정리
                {
                    bufferedWriter.write(product_name[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write(product_date[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write(product_img_url[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write(product_afterservice[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write("<--"+i+"-->");
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public void save_date_import()
    {
        try{
            //파일 객체 생성
            File file = new File("\\Writer.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            int i = 0;
            while((line = bufReader.readLine()) != null){

                i++;
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }

}
