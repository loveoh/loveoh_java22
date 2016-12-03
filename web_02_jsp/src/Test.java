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
		
	/*	//������֤��
				ConfigurableCaptchaService service = new ConfigurableCaptchaService();
				service.setColorFactory(new SingleColorFactory(new Color(25,60,180)));
				service.setFilterFactory(new CurvesRippleFilterFactory(service.getColorFactory()));
				//������֤�����ʽ
				RandomWordFactory wordFactory = new RandomWordFactory();
				wordFactory.setMinLength(4);
				wordFactory.setMaxLength(4);
				wordFactory.setCharacters("0123456789");
				service.setWordFactory(wordFactory);
				
				FileOutputStream outputStream = new FileOutputStream("e:/s.png");
				//ͨ��response�����ȡ��Ӧ�����
				//OutputStream outputStream = response.getOutputStream();
				//��ȡ��֤�������
				String code = EncoderHelper.getChallangeAndWriteImage(service, "png", outputStream);
				System.out.println(code);
				//����������֤�����session��,�Ա���֤
				
			
				
				outputStream.flush();
				outputStream.close();
				*/
	
	
	}
}
