package yjw.image.security;

import java.awt.image.BufferedImage;

public class RandomSecurityCode {
	
	//ͼƬ��֤��
	private BufferedImage securityCode;
	
	//��֤���ֵ
	private String value;
	
	public BufferedImage getSecurityCode() {
		return securityCode;
	}
	
	public void setSecurityCode(BufferedImage securityCode) {
		this.securityCode = securityCode;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
