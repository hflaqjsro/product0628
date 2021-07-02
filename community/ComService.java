package javaexp.z0625_project;

import java.util.ArrayList;
public class ComService {
	ComDao ComDao = new ComDao();
	public ArrayList<Post> post(Post po){
		return ComDao.post(po);
	}
	
	public void loadPost(){
		ComDao.loadPost();
	}
}

