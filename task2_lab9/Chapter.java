package task2;

public class Chapter {
	private String tittle;
	private int pages;
	public Chapter(String tittle, int pages) {
		super();
		this.tittle = tittle;
		this.pages = pages;
	}
	public int getPages() {
		return pages;
	}
	public String getName() {
		return tittle;
	}
}
