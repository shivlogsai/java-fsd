package com.LockedMe;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FinalProject{
	public static void main(String[] args) {
		System.out.println("*****\n");
        System.out.println("\t      Welcome to The Desk of \n");
        System.out.println("\t           LockedMe.com   \n");
        System.out.println("\t      Developed by Logeshwaran S\n");
        System.out.println("*****\n");
        optionsSelection();
	}
	private static void optionsSelection() {
		String[] arr = {"1. Retrieving the file names in an ascending order",
                        "2. Business-level operations",
                        "3. Close the application"
                       };
		int[] a = {1, 2, 3};
        int len = a.length;
        for(int i=0; i<len;i++){
            System.out.println(arr[i]);
        }
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int options=sc.nextInt();
        switch(options) {
        case 1:
        	try {
				sortfilename();
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        	System.out.print("\n");
        	optionsSelection();
        	break;
        	
        case 2:
        	businessLevelOperation();
			break;
			
        case 3:
        	System.out.println("Application is closed... \nThank you!");
			break;
			
	    default:{
	    	System.out.println("Entered option is incorrect");
	    }
	    System.out.print("\n");
        optionsSelection(); 
        break;
	    	
        }
	}
	public static void businessLevelOperation() {
		String[] arr1 = {"1. Add a file to the existing directory list",
	                     "2. Delete a user specified file from the existing directory list",
	                     "3. Search a user specified file from the main directory",
	                     "4. Navigate back to the main context"
	                    };
		int[] b = {1, 2, 3, 4};
	    int len1 = arr1.length;
	    for(int i=0; i<len1;i++){
	        System.out.println(arr1[i]);
	    }
	    System.out.println("\nSelect your option :\t");
	    Scanner s = new Scanner(System.in);
	    int option = s.nextInt();
	    switch(option) {
		   case 1:
			   try {
				createWriteFile();
			   }
			   catch (IOException e) {
				e.printStackTrace();
			   }
			   businessLevelOperation()	;
			   break;
			   
		   case 2:
			   try {
				deleteFile();
			   } 
			   catch (Exception e) {
				e.printStackTrace();
			   }
			   businessLevelOperation()	;
			   break;
			   
		   case 3:
			   try {
				searchFile();
			   } 
			   catch (Exception e) {
				e.printStackTrace();
			   }
			   System.out.println("\n");
			   businessLevelOperation()	;
			   break;
			   
		   case 4:{
			   System.out.println("Exit from the BLO menu\n");
			   optionsSelection();
			   break;
		   }
		   default:{
			   System.out.println("Entered option is incorrect");
		   } 
		   System.out.print("\n");
		   businessLevelOperation()	;
		   break;
	    }
	}
	public static void createWriteFile() throws IOException{
		try {
		System.out.println("Enter the number of files you want to add: ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
		System.out.println("Enter the filename :");
		Scanner sc1=new Scanner(System.in);
		String filename=sc1.next();
	    File file=new File("C:\\Users\\LOGESHWARAN\\Desktop\\LockedMe\\"+filename+".txt");
	  
	    
	    System.out.println("Write anything in this current file : ");
		Scanner sc2=new Scanner(System.in);
		String content=sc2.nextLine();
	    FileWriter writer=new FileWriter(file);
		writer.write(content);
		writer.flush();
		writer.close();
		}
		System.out.println("Files created !");
		}
		catch(IOException e) {
			 e.printStackTrace();
		}
	}
	public static void sortfilename()
    {
        File file=new File("C:\\Users\\LOGESHWARAN\\Desktop\\LockedMe\\");
        if(file.isDirectory())
        {
        File[] fileList = file.listFiles();
        Arrays.sort(fileList);
        System.out.println("\nTotal number of files present in the directory retrieved in an ascending order: " + fileList.length );

        FileFilter fileFilter = new FileFilter()
        {
        @Override
        public boolean accept(File file) {
             return !file.isDirectory();
        }
        };
        fileList = file.listFiles(fileFilter);
        Arrays.sort(fileList, new Comparator<Object>()
        {
        public int compare(Object f1, Object f2) {
             return ((File) f1).getName().compareTo(((File) f2).getName());
        }
        });
        for(File fi:fileList)
        {
             System.out.println(fi.getName());
        }
        } 
    }
	public static void deleteFile() throws Exception{
		System.out.println("Enter the filename that you want to delete");
		Scanner sc=new Scanner(System.in);
		String deletefile=sc.next();
	    File file=new File("C:\\Users\\LOGESHWARAN\\Desktop\\LockedMe\\"+deletefile+".txt");
	    
	    boolean present = file.exists();
	    file.delete();
	    if(present==true) {
	    	System.out.println(deletefile+" is deleted successfully");
	    }
	    else {
	    	System.out.println(" Entered file "+deletefile+" is not found");
	    }
	}
	public static void searchFile() throws Exception {
		try {
	    System.out.println("Enter the filename that you want to search");
		Scanner sc=new Scanner(System.in);
		String search=sc.next();
		File file=new File("C:\\Users\\LOGESHWARAN\\Desktop\\LockedMe\\"+search+".txt");
		        
	    FileReader reader=new FileReader(file);
		int data;
		while((data=reader.read())!=-1) {
			 System.out.print((char)data);
		}
		}
		catch(FileNotFoundException e) {
			System.out.println("Entered file is not present");
			System.out.println(e.getClass().getName());
			  
		}
	}
}
