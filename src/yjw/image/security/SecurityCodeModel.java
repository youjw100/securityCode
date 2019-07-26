package yjw.image.security;

import java.awt.image.BufferedImage;

public class SecurityCodeModel {
	
	private BufferedImage securityCode;
	
	private String codeValue;
	
	public SecurityCodeModel (int width, int height) {
		this.securityCode = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public BufferedImage getSecurityCode() {
		return securityCode;
	}
	
	public void setSecurityCode(BufferedImage securityCode) {
		this.securityCode = securityCode;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	
}
