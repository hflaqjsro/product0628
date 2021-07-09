package javaexp.z04_recruit;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class mine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//숫자 : 48-57, 대문자 : 65-90, 소문자 : 97-122
		
		File resume = new File("rs000001.txt");
		File dir = new File("RC001_SL//rs000001.txt");
		System.out.println(dir.getAbsolutePath());
		System.out.println(resume.getAbsolutePath());
	
		
		Path org = Paths.get(dir.getAbsolutePath());
		Path cpy = Paths.get(resume.getAbsolutePath());
		try {
			Files.copy(org, cpy);
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}			
		/*
		String[] list = f.list();
		for(int i=0;i<list.length;i++) {
			if(list[i].equals("RC001_SL")){
				File dir = new File(list[i]);
				dir.getAbsolutePath();
			}
			
		}*/
		
		/*
		File f2 = new File("rs000001.txt");
		String[] f2list = f2.list();
		for(int i=0;i<f2list.length;i++) {
			System.out.println(f2list[i]);
		}*/
	}
}
/*
public static void findPath(File file) {
	File[] flist = file.listFiles();
	for(File f : flist) {
		System.out.println(f.getAbsolutePath());
	}
}*/