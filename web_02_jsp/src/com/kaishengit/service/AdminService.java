package com.kaishengit.service;

import org.apache.commons.codec.digest.DigestUtils;

import com.kaishengit.config.config;
import com.kaishengit.dao.AdminDao;
import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;

public class AdminService {

	private AdminDao adminDao = new AdminDao();

	public Admin findAdmin(String username, String password) throws ServiceException{

		
		Admin admin = adminDao.findByName(username);
		System.out.println(password);
		//��֤�û�����Ҳ������
		//password = DigestUtils.md5Hex(password + config.PASSWORD_SALT);

		if (admin != null && admin.getPassword().equals(password)) {
			
			
			return admin;
		} else {
			throw new ServiceException("�˺Ż��������");
		}
	}

	/**
	 * ע��ͼ�����Ա
	 * @param username
	 * @param password
	 * @param adminnum
	 */
	public void regist(String username, String password) throws ServiceException {
		
		Admin admin = adminDao.findByName(username);
		if(admin == null){
			//���ݿ���,�����Ϊ����
			//password = DigestUtils.md5Hex(password +config.PASSWORD_SALT);
		
			adminDao.regist(username,password);
		} else {
			throw new ServiceException("���û����Ѿ�����");
		}
	}

}
