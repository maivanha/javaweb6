package model.etity;

public class News {
	private int codeNews;
	private String title;
	private String image;
	private String contents;
	
	public News() {
		
	}

	public News(String title, String image, String contents) {
		super();
		this.title = title;
		this.image = image;
		this.contents = contents;
	}

	public News(int codeNews, String title, String image, String contents) {
		super();
		this.codeNews = codeNews;
		this.title = title;
		this.image = image;
		this.contents = contents;
	}

	public int getCodeNews() {
		return codeNews;
	}

	public void setCodeNews(int codeNews) {
		this.codeNews = codeNews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
