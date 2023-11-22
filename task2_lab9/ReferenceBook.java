package task2;

import java.util.List;

public class ReferenceBook extends Publication {
//tiêu đề, số trang, năm xuất bản, tác giả, giá tiền
	private String fields;
	private List<Chapter> chapters;
	public ReferenceBook(String tittle, String author, int pages, int year, double price, String fields,
			List<Chapter> chapters) {
		super(tittle, author, pages, year, price);
		this.fields = fields;
		this.chapters = chapters;
	}
	@Override
	public String whatIsThis() {
		// TODO Auto-generated method stub
		return "This is reference book";
	}
	@Override
	public boolean isOldMagazine() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean sameTypeandAuthor(Publication p) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				return (p instanceof ReferenceBook && this.author.equals(p.getAuthor()));
	}
	@Override
	public int chapterPages() {
		// TODO Auto-generated method stub
		int max =0;
		for (Chapter c : chapters) {
		if (c.getPages()>=max)
			max = c.getPages();
		}
		return max;
	}
	@Override
	public String getName(int pages) {
		// TODO Auto-generated method stub
		for (Chapter c : chapters) {
			if (c.getPages() == pages) {
				return c.getName();
			}
		}
		return "";
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return tittle;
	}
	
	
}
