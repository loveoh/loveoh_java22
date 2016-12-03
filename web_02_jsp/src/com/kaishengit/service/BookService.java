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
			throw new ServiceException("isbn�����ظ�");
		}

	}

	/**
	 * �������ݿ��������鼮
	 * @return
	 */
	public List<Book> findAll() {

		return bookDao.findAll();

	}

	/**
	 * ����ID ɾ������
	 * @param id
	 */
	public void delete(Integer id) {

		
		bookDao.deleteById(id);
	}

	public Book findById(Integer id) {
		
		return bookDao.findById(id);
	}

	/**
	 * �޸��鼮
	 * @param book
	 */
	public void update(Book book) {
		bookDao.update(book);
	}

	/**
	 * ���ݵ�ǰҳ���ѯ
	 * @param pagNo
	 * @return
	 */
	public List<Book> findbyPageNo(int pagNo) {
		//�õ���ҳ��Ĳ�ѯ����
		int pageSize = 5;
		//�õ��ò�ѯҳ�����ʼ����
		int pageStart = (pagNo - 1) * pageSize;
		return bookDao.findByPage(pageStart,pageSize);
		
		
	}

	public Page<Book> findByPage(int pagNo) {
		
		
		//���������
		int count = bookDao.count().intValue(); 
		Page<Book> page = new Page<Book>(count,pagNo);
		
		int pageSize = 5;
		int pageStart = (pagNo - 1) * pageSize;
		page.setPageStart(pageStart);
		
		List<Book> listBook = bookDao.findByPage(page.getPageStart(),page.getPageSize());
		//����ǰҳ�������,д��page������ȥ
		page.setItems(listBook);
		return page;
	}

}
