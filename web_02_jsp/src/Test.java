import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

public class Test {

	public static void main(String[] args) throws IOException {
		
		String code1 = DigestUtils.md5Hex("123");
		System.out.println(code1);
		
		String code2 = DigestUtils.md5Hex("loveoh");
		System.out.println(code2);
		
		String salt = "dsfasdflkjhskldfj1238947ojkldfjal;sdfjui34589723489./,/`";
		String password = "123" + salt;
		String code = DigestUtils.md5Hex(password);
		System.out.println(code);
		
	/*	//设置验证码
				ConfigurableCaptchaService service = new ConfigurableCaptchaService();
				service.setColorFactory(new SingleColorFactory(new Color(25,60,180)));
				service.setFilterFactory(new CurvesRippleFilterFactory(service.getColorFactory()));
				//设置验证码的样式
				RandomWordFactory wordFactory = new RandomWordFactory();
				wordFactory.setMinLength(4);
				wordFactory.setMaxLength(4);
				wordFactory.setCharacters("0123456789");
				service.setWordFactory(wordFactory);
				
				FileOutputStream outputStream = new FileOutputStream("e:/s.png");
				//通过response对象获取响应输出流
				//OutputStream outputStream = response.getOutputStream();
				//获取验证码的内容
				String code = EncoderHelper.getChallangeAndWriteImage(service, "png", outputStream);
				System.out.println(code);
				//将产生的验证码放入session中,以便验证
				
			
				
				outputStream.flush();
				outputStream.close();
				*/
	
	
	}
}
