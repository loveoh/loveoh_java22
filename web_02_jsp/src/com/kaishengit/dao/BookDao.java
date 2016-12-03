package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kaishengit.entity.Book;
import com.kaishengit.utils.DBhelep;

public class BookDao {

	/**
	 * ����isbn��ѯ�鼮
	 * 
	 * @param isbn
	 * @return ���鼮����
	 */
	public Book findByIsbn(String isbn) {

		String sql = "select * from t_book where isbn = ?";
		return DBhelep.query(sql, new BeanHandler<>(Book.class), isbn);
	}

	/**
	 * ����鼮
	 * 
	 * @param name
	 * @param author
	 * @param total
	 * @param isbn
	 */
	public void add(String name, String author, Integer total, String isbn) {

		String sql = "insert into t_book(name,author,total,isbn) values(?,?,?,?)";

		DBhelep.update(sql, name, author, total, isbn);

	}

	/**
	 * �����鼮�������鼮
	 * 
	 * @return
	 */
	public List<Book> findAll() {

		String sql = "select * from t_book";
		return DBhelep.query(sql, new BeanListHandler<>(Book.class));

	}

	/**
	 * ����id ɾ��
	 * @param id
	 */
	public void deleteById(Integer id) {

		String sql = "delete from t_book where id=?";
		DBhelep.update(sql, id);

	}

	/**
	 * ����id����
	 * @param id
	 * @return
	 */
	public Book findById(Integer id) {
		
		String sql = "select * from t_book where id=?";
		return DBhelep.query(sql, new BeanHandler<>(Book.class), id);
	}

	/**
	 * �޸��鼮
	 * @param book
	 */
	public void update(Book book) {
		
		
		String sql = "update t_book set name=?,author=?,total=?,isbn=? where id=?";
		DBhelep.update(sql, book.getName(),book.getAuthor(),book.getTotal(),book.getIsbn(),book.getId());
	}

	/**
	 * ��ҳ�������ݿ�
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	public List<Book> findByPage(int pageStart, int pageSize) {
		String sql = "select * from t_book limit ?,?";
		
		return DBhelep.query(sql, new BeanListHandler<Book>(Book.class), pageStart,pageSize);
	}

	/**
	 * ��ѯ���ݿ��ܹ��ж�������¼
	 * @return
	 */
	public Long count() {
		String sql ="select count(*) from t_book";
		return DBhelep.query(sql, new ScalarHandler<Long>());
	}

}
