package com.kaishengit.web.patchca;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

/**
 * 验证码
 * @author loveoh
 *
 */
public class patchcaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置验证码
		ConfigurableCaptchaService service = new ConfigurableCaptchaService();
		service.setColorFactory(new SingleColorFactory(new Color(25,60,180)));
		service.setFilterFactory(new CurvesRippleFilterFactory(service.getColorFactory()));
		//设置验证码的样式
		RandomWordFactory wordFactory = new RandomWordFactory();
		wordFactory.setMinLength(4);
		wordFactory.setMinLength(4);
		wordFactory.setCharacters("0123456789");
		
		
		//FileOutputStream outputStream = new FileOutputStream("e:/s.png");
		//通过response对象获取响应输出流
		OutputStream outputStream = response.getOutputStream();
		//获取验证码的内容
		String code = EncoderHelper.getChallangeAndWriteImage(service, "png", outputStream);
		System.out.println(code);
		//将产生的验证码放入session中,以便验证
		HttpSession session = request.getSession();
		session.setAttribute("patchaca", code);
		
		outputStream.flush();
		outputStream.close();
		
	
	
	
	
	}



}
