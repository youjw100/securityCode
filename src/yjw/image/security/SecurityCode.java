package yjw.image.security;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class SecurityCode {
	
	public SecurityCodeModel drawSecurityCode(int width, int height, int num) {
		SecurityCodeModel securityCodeModel = new SecurityCodeModel(width, height);
		
		String value = this.getRandomValue(num);
		
		securityCodeModel.setCodeValue(value);
		securityCodeModel.setSecurityCode(this.getSecurityCode(securityCodeModel));
		
		return securityCodeModel;
	}
	
	private String getRandomValue(int num) {
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
	
	private BufferedImage getSecurityCode(SecurityCodeModel securityCodeModel) {
		BufferedImage image = securityCodeModel.getSecurityCode();
		String codeValue = securityCodeModel.getCodeValue();
		if(codeValue == null || codeValue.length() == 0) {
			return null;
		}
		int width = image.getWidth();
		int height = image.getHeight();
		
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		g2d.setColor(new Color(255, 255, 255));
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(new Color(0,0,0));
		g2d.setFont(new Font("ËÎÌו", Font.PLAIN, (int) (height*0.7)));

		Random random = new Random();
		int num = codeValue.length();
		for(int i=0; i<num; i++) {
			int x = i*(width/num) + random.nextInt(width/num - height/2);
			int y = height/2 + random.nextInt((int) (height/2));
			g2d.drawString(String.valueOf(codeValue.charAt(i)), x, y);
		}
		
		
		
		return image;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedImage bi = new SecurityCode().drawSecurityCode(300, 90, 4).getSecurityCode();
		ImageIO.write(bi, "jpg", new File("D:\\1.jpg"));
	}
}
