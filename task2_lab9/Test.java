package task2;

import java.util.ArrayList;
import java.util.List;

public class Test {
public static void main(String[] args) {
//	Magazine m = new Magazine(null, null, 0, 0, 0, null);
//	ReferenceBook r = new ReferenceBook(null, null, 0, 0, 0, null, null);
//	System.out.println(m.whatIsThis());
//	System.out.println(r.whatIsThis());
	
	
	Chapter chap1 = new Chapter("tác giả Kim lân", 1);
	Chapter chap2 = new Chapter("Tìm hiểu tác phẩm Vợ nhặt", 8);
	Chapter chap3 = new Chapter("Tìm hiểu chi tiết tác phẩm Vợ nhặt", 16);
	Chapter chap4 = new Chapter("Hết", 2);
	
	List<Chapter> cli1 = new ArrayList<Chapter>();
	cli1.add(chap1);
	cli1.add(chap2);
	
	List<Chapter> cli2 = new ArrayList<Chapter>();
	cli2.add(chap3);
	cli2.add(chap4);
	
	ReferenceBook rbook1 = new ReferenceBook("Hoàng Tử Bé", "Antoine de Saint-Exupéry", 46439, 1947, 1200000, "tiểu thuyết", cli1);
	ReferenceBook rbook2 = new ReferenceBook("Không gia đình", " Hector Malot", 44669, 1945, 1000000, "tiểu thuyết", cli2);
	
	Magazine m1 = new Magazine("Tạp chí Giáo dục", "Bộ Giáo dục và Đào tạo", 10, 2000, 15000, "Văn Học");
	Magazine m2 = new Magazine("Tạp chí Sức khỏe", "Nguyễn Văn A", 10, 2011, 15000, "Dinh Dưỡng");
	Magazine m3 = new Magazine("Tạp Chí Thể Thao", "Nguyễn Văn B", 10, 2011, 15000, "Cơ Thể");
	Magazine m4 = new Magazine("Tạp Chí Khoa Học", "Nguyễn Văn C", 10, 2011, 15000, "Công Nghệ");
	
	
	List<Publication> booklist = new ArrayList<Publication>();
	booklist.add(rbook1);
	booklist.add(rbook2);
	booklist.add(m1);
	booklist.add(m2);
	booklist.add(m3);
	booklist.add(m4);
	
	BookStore store = new BookStore(booklist);
	System.out.println(store.isContainThisMagazine("Dinh Dưỡng"));
	System.out.println(store.magazinesPublicInThisYear(2023).size());
	store.mostPageReferenceBook();
	
	//System.out.println(store.statisticalByYear());
	
}
}
