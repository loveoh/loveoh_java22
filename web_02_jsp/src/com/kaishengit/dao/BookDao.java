package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kaishengit.entity.Book;
import com.kaishengit.utils.DBhelep;

public class BookDao {

	/**
	 * 根据isbn查询书籍
	 * 
	 * @param isbn
	 * @return 该书籍对象
	 */
	public Book findByIsbn(String isbn) {

		String sql = "select * from t_book where isbn = ?";
		return DBhelep.query(sql, new BeanHandler<>(Book.class), isbn);
	}

	/**
	 * 添加书籍
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
	 * 查找书籍库所有书籍
	 * 
	 * @return
	 */
	public List<Book> findAll() {

		String sql = "select * from t_book";
		return DBhelep.query(sql, new BeanListHandler<>(Book.class));

	}

	/**
	 * 根据id 删除
	 * @param id
	 */
	public void deleteById(Integer id) {

		String sql = "delete from t_book where id=?";
		DBhelep.update(sql, id);

	}

	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public Book findById(Integer id) {
		
		String sql = "select * from t_book where id=?";
		return DBhelep.query(sql, new BeanHandler<>(Book.class), id);
	}

	/**
	 * 修改书籍
	 * @param book
	 */
	public void update(Book book) {
		
		
		String sql = "update t_book set name=?,author=?,total=?,isbn=? where id=?";
		DBhelep.update(sql, book.getName(),book.getAuthor(),book.getTotal(),book.getIsbn(),book.getId());
	}

	/**
	 * 分页查找数据库
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	public List<Book> findByPage(int pageStart, int pageSize) {
		String sql = "select * from t_book limit ?,?";
		
		return DBhelep.query(sql, new BeanListHandler<Book>(Book.class), pageStart,pageSize);
	}

	/**
	 * 查询数据库总共有多少条记录
	 * @return
	 */
	public Long count() {
		String sql ="select count(*) from t_book";
		return DBhelep.query(sql, new ScalarHandler<Long>());
	}

}
