package task2;

public class Magazine extends Publication {
	private String magazineName;

	public Magazine(String tittle, String author, int pages, int year, double price, String magazineName) {
		super(tittle, author, pages, year, price);
		this.magazineName = magazineName;
	}

	@Override
	public String whatIsThis() {
		// TODO Auto-generated method stub
		return "This is magazine";
	}

	@Override
	public boolean isOldMagazine() {
		// TODO Auto-generated method stub
		return year<=2011;
	}
	public static void main(String[] args) {
		
	}

	@Override
	public boolean sameTypeandAuthor(Publication p) {
		// TODO Auto-generated method stub
		return (p instanceof Magazine && this.author.equals(p.getAuthor()));
	}

	@Override
	public int chapterPages() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return magazineName;
	}

	@Override
	public String getName(int pages) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
