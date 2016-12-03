package com.kaishengit.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.dao.BookDao;
import com.kaishengit.entity.Book;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.utils.Page;


public class BookService {

	private BookDao bookDao = new BookDao();

	public void add(String name, String author, Integer total, String isbn) throws ServiceException {

		
		Book book = bookDao.findByIsbn(isbn);

		if (book == null) {
			bookDao.add(name, author, total, isbn);
		} else {
			throw new ServiceException("isbn编码重复");
		}

	}

	/**
	 * 查找数据库中所有书籍
	 * @return
	 */
	public List<Book> findAll() {

		return bookDao.findAll();

	}

	/**
	 * 根据ID 删除方法
	 * @param id
	 */
	public void delete(Integer id) {

		
		bookDao.deleteById(id);
	}

	public Book findById(Integer id) {
		
		return bookDao.findById(id);
	}

	/**
	 * 修改书籍
	 * @param book
	 */
	public void update(Book book) {
		bookDao.update(book);
	}

	/**
	 * 根据当前页码查询
	 * @param pagNo
	 * @return
	 */
	public List<Book> findbyPageNo(int pagNo) {
		//得到该页面的查询数量
		int pageSize = 5;
		//得到该查询页面的起始行数
		int pageStart = (pagNo - 1) * pageSize;
		return bookDao.findByPage(pageStart,pageSize);
		
		
	}

	public Page<Book> findByPage(int pagNo) {
		
		
		//获得总条数
		int count = bookDao.count().intValue(); 
		Page<Book> page = new Page<Book>(count,pagNo);
		
		int pageSize = 5;
		int pageStart = (pagNo - 1) * pageSize;
		page.setPageStart(pageStart);
		
		List<Book> listBook = bookDao.findByPage(page.getPageStart(),page.getPageSize());
		//将当前页面的数据,写入page对象中去
		page.setItems(listBook);
		return page;
	}

}
