package javaexp.z0625_project;


public class Post {
	private String postTitle;
	private String postText;
	private String postTag;
	
	public Post(String postTitle, String postText, String postTag) {
		super();
		this.postTitle = postTitle;
		this.postText = postText;
		this.postTag = postTag;
	}
	
	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostTag() {
		return postTag;
	}

	public void setPostTag(String postTag) {
		this.postTag = postTag;
	}

	@Override
	public String toString() {
		return "게시글 저장 내용 \n 제목 :" + postTitle + "\n 내용 : " + postText + "\n 태그 : " + postTag +"\n";
	}
}
