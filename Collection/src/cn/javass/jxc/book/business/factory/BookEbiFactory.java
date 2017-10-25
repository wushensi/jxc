package cn.javass.jxc.book.business.factory;

import cn.javass.jxc.book.business.ebi.BookEbi;
import cn.javass.jxc.book.business.ebo.BookEbo;

public class BookEbiFactory {
	public static BookEbi getBookEbi(){
		return new BookEbo();
	}
}
