package javaexp.z0625_project;


public class ComController {
	ComService ComSer = new ComService();
	public String post(Post po, Model m) {
		ComSer.post(po);
		m.addAttribute("key 값", po);
		return ".jsp경로";
	}

	public String loadPost(){
		ComSer.loadPost();
		return ".jsp경로";
	}
	
}
