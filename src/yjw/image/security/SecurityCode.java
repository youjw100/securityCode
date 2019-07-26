package yjw.image.security;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class SecurityCode {
	
	public RandomSecurityCode getSecurityCode(int width, int height, int num) {
		//创建图片验证码
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		return this.drawSecurityCode(image, num);
	}
	
	private RandomSecurityCode drawSecurityCode(BufferedImage image, int num) {
		RandomSecurityCode rsc = new RandomSecurityCode();
		
		//获取随机验证码A~Z、a~z、0~9
		rsc.setValue(this.getRandomNum(num));
		
		//绘制验证码的值
		
		return rsc;
	}
	
	/**
	 * 获取随机验证码的值
	 * @param num
	 * @return
	 */
	private String getRandomNum(int num) {
		StringBuilder value = new StringBuilder();
		Random r = new Random();
		for(int i=0; i<num; i++) {
			int number = r.nextInt(62);
			if(number < 10) {
				value.append((char) (number + 48));
			} else if (number >=10 && number <= 35) {
				value.append((char) (number + 55));
			} else {
				value.append((char) (number + 61));
			}
		}
		return value.toString();
	}
	
	public static void main(String[] args) throws IOException {
		ImageIO.write(new SecurityCode().getSecurityCode(100, 30, 5).getSecurityCode(), "jpg", new File("D:\\1.jpg"));
	}
}
