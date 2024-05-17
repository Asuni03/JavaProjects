import java.util.Random;

public class CaptchaGenerator {
	private String captcha;

	public CaptchaGenerator() {
		String chrs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		String captcha = "";
		for (int i = 5; i > 0; i--) {
			int index = (int) (Math.random() * 62);
			captcha += chrs.charAt(index);

		}
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

}
