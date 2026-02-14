package com.OOPs.FileHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CodingChallenge {
    private File file;

    public CodingChallenge(File file) throws FileNotFoundException {
        if (file.exists()&&file.isDirectory()) {
            this.file =file;
        }
        else {
            throw new FileNotFoundException("Not Found Error Or Folder is Asked but given file");
        }
    }
    public CodingChallenge(String path) throws FileNotFoundException {
        File f=new File(path);
        if (f.exists()&&f.isDirectory()) {
            this.file =f;
        }
        else {
            throw new FileNotFoundException("Not Found Error or Folder is Asked but given file");
        }
    }

    public boolean merge(String fileName1,String filename2) throws IOException {
        File file1=new File(this.file.getPath()+"\\"+fileName1);
        if (!file1.exists()) throw new FileNotFoundException("File Not Found "+fileName1);
        File file2=new File(this.file.getPath()+"\\"+filename2);
        if (!file2.exists()) throw new FileNotFoundException("File not Found "+filename2);
        if (file1.isDirectory()||file2.isDirectory())throw new IOException("Can not merge file And Folder");
        List<String>list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(file1));
        while (reader.ready()){
            list.add(reader.readLine());
        }
        reader=new BufferedReader(new FileReader(file2));
        while (reader.ready()){
            list.add(reader.readLine());
        }
        reader.close();
        if (!file2.delete())throw new IOException("No Permission to Delete the File");
        try(FileWriter f=new FileWriter(file1)){
            f.write("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writeData(list,file1);
    }

    private boolean writeData(List<String> list, File file1) throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter(file1,true));
        for (String s:list){
            writer.write(s);
            writer.newLine();
        }
        writer.close();
        return true;
    }

    public static void main(String[] args) {
        try {
            CodingChallenge codingChallenge=new CodingChallenge("D:\\Progr\\src\\com\\OOPs\\FileHandling\\Files");
            System.out.println(codingChallenge.merge("data.txt","hello.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
