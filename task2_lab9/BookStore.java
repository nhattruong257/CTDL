package task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStore {
	private List<Publication> li;

	public BookStore(List<Publication> li) {
		super();
		this.li = li;
	}

	public double totalCost() {
		double re = 0;
		for (Publication p : li) {
			re += p.getPrice();
		}
		return re;
	}

	public ReferenceBook mostPageReferenceBook() {
		int max = 0;
		ReferenceBook re = null;
		for (Publication p : li) {
			if (p instanceof ReferenceBook) {
				if (p.chapterPages() >= max)
					max = p.chapterPages();
				re = (ReferenceBook) p;
			}
		}
		System.out.println(re.getName(max)+ " with "+max+" pages is the most.");
		return re;

	}

	public boolean isContainThisMagazine(String name) {
		for (Publication p : li) {
			if (p instanceof Magazine) {
				if (p.getName().equals(name))
					return true;
			}
		}
		return false;
	}

	public List<Magazine> magazinesPublicInThisYear(int year) {
		List<Magazine> re = new ArrayList<Magazine>();
		for (Publication p : li) {
			if (p instanceof Magazine) {
				if (p.getYear() == year)

					re.add((Magazine) p);
			}
		}
		return re;
	}
	public void sort() {
		li.sort(new Comparator<Publication>() {

			@Override
			public int compare(Publication p1, Publication p2) {
				int re = p1.compareTo(p2);
				if (re == 0) {
					return p1.getYear() - p2.getYear();
				}
				else return re;
			}
			
		});
	}
	public Map<Integer, Integer> statisticalByYear(){
		Map<Integer,Integer> re = new HashMap<Integer, Integer>();
		for (Publication p : li) {
			if (!re.containsKey(p.getYear())) {
				re.put(p.getYear(), 1);
			}
			else {
				//Tạm thời ló thế
				re.remove(p.getYear());
				Integer i = re.get(p.getYear());
				i+=1;
				
			}
		}
		return re;
		
	}
	

}
