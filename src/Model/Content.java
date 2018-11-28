package Model;

public class Content{
	int id;
	int level;
	String title;
	String img;
	
	public Content(int id, int level, String title, String img) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.level = level;
		this.title = title;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	

}
