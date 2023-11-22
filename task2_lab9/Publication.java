package task2;

public abstract class Publication {
	// tiêu đề, số trang, năm xuất bản, tác giả, giá tiền
	protected String tittle, author;
	protected int pages, year;
	protected double price;

	public Publication(String tittle, String author, int pages, int year, double price) {
		super();
		this.tittle = tittle;
		this.author = author;
		this.pages = pages;
		this.year = year;
		this.price = price;
	}

	public abstract String whatIsThis();

	public abstract boolean isOldMagazine();

	public abstract boolean sameTypeandAuthor(Publication p);

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}
	public abstract int chapterPages();
	public abstract String getName();

	protected int getYear() {
		return year;
	}
	public int compareTo(Publication p) {
		return this.tittle.compareTo(p.tittle);
	}

	public abstract String getName(int pages);
	
}
