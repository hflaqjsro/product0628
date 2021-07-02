package javaexp.z0625_project;

import java.util.ArrayList;
import java.util.List;

public class ComDao {
	public ArrayList<Post> post(Post po){
		ArrayList<Post> postList = new ArrayList<Post>();
		postList.add(po);
		savePost(po);
		System.out.println(postList.toString());
		return postList;
	}
	ArrayList<Post> postListSave = new ArrayList<Post>();
	public ArrayList<Post> savePost(Post po) {
		postListSave.add(po);
		return postListSave;
	}
	
	public void loadPost() {
		System.out.println(postListSave);
	}
	
}
