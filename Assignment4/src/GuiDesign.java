import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiDesign {

	private JFrame frmSkkuCodingClub;
	private JTextField fieldName;
	private JTextField fieldStudentId;
	private JTextField fieldMajor;
	private JTextField fieldEmail;
	private JTextField fieldPhoneNumber;
	private JTextField fieldCaptcha;
	private JLabel captchaLabel;
	CaptchaGenerator obj;
	private static int errorCounter = 0;
	private static String message = "";

	public GuiDesign() {
		frmSkkuCodingClub = new JFrame();
		frmSkkuCodingClub.setTitle("SKKU Coding Club");
		frmSkkuCodingClub.setBounds(100, 100, 1018, 720);
		frmSkkuCodingClub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSkkuCodingClub.setLocationRelativeTo(null);
		frmSkkuCodingClub.getContentPane().setLayout(null);

		JLabel assetImage = new JLabel("");
		assetImage.setIcon(new ImageIcon(GuiDesign.class.getResource("/assets/programming.jpg")));
		assetImage.setBounds(0, 0, 400, 700);
		frmSkkuCodingClub.getContentPane().add(assetImage);

		JLabel guiTitle = new JLabel("SKKU Coding Club Application Form");
		guiTitle.setForeground(new Color(0, 0, 255));
		guiTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
		guiTitle.setBounds(463, 63, 531, 39);
		frmSkkuCodingClub.getContentPane().add(guiTitle);

		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setBounds(410, 153, 486, 327);
		frmSkkuCodingClub.getContentPane().add(textFieldPanel);
		textFieldPanel.setLayout(null);

		fieldName = new JTextField();
		fieldName.setBounds(146, 0, 340, 30);
		textFieldPanel.add(fieldName);
		fieldName.setColumns(10);

		fieldStudentId = new JTextField();
		fieldStudentId.setColumns(10);
		fieldStudentId.setBounds(146, 55, 340, 30);
		textFieldPanel.add(fieldStudentId);

		fieldMajor = new JTextField();
		fieldMajor.setColumns(10);
		fieldMajor.setBounds(146, 114, 340, 30);
		textFieldPanel.add(fieldMajor);

		fieldEmail = new JTextField();
		fieldEmail.setColumns(10);
		fieldEmail.setBounds(146, 174, 340, 30);
		textFieldPanel.add(fieldEmail);

		fieldPhoneNumber = new JTextField();
		fieldPhoneNumber.setColumns(10);
		fieldPhoneNumber.setBounds(146, 234, 340, 30);
		textFieldPanel.add(fieldPhoneNumber);

		fieldCaptcha = new JTextField();
		fieldCaptcha.setColumns(10);
		fieldCaptcha.setBounds(146, 296, 340, 30);
		textFieldPanel.add(fieldCaptcha);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(88, -3, 48, 30);
		textFieldPanel.add(lblNewLabel);

		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentId.setBounds(55, 55, 79, 30);
		textFieldPanel.add(lblStudentId);

		JLabel lblMajor = new JLabel("Major: ");
		lblMajor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMajor.setBounds(90, 111, 48, 30);
		textFieldPanel.add(lblMajor);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(88, 174, 48, 30);
		textFieldPanel.add(lblEmail);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(30, 234, 106, 30);
		textFieldPanel.add(lblPhoneNumber);

		JLabel lblCaptcha = new JLabel("CAPTCHA:");
		lblCaptcha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCaptcha.setBounds(68, 293, 68, 30);
		textFieldPanel.add(lblCaptcha);

		JButton btnSubmit = new JButton("SUBMIT");

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (!(fieldName.getText().matches("^[a-zA-Z]+\\s[a-zA-Z]+$"))) {
						throw new InvalidName();
					}
				} catch (InvalidName nameException) {
					errorCounter++;
					message += errorCounter + ". First name or last name is missing.\n";
					fieldName.setForeground(new Color(255, 0, 0));
				}

				try {
					if (!(fieldStudentId.getText().matches("^20\\d{2}31\\d{4}$"))) {
						throw new InvalidStudentId();
					}
				} catch (InvalidStudentId studentIdException) {
					errorCounter++;
					message += errorCounter
							+ ". Student ID format is wrong. It must look like 20xx31xxxx without non-digits.\n";
					fieldStudentId.setForeground(new Color(255, 0, 0));
				}

				try {
					if (fieldMajor.getText().equals("")) {
						throw new InvalidMajor();
					}
				} catch (InvalidMajor majorException) {
					errorCounter++;
					message += errorCounter + ". Major field must not be empty.\n";
					fieldMajor.setForeground(new Color(255, 0, 0));
				}

				try {
					if (!(fieldEmail.getText().matches("\\b[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}\\b"))) {
						throw new InvalidEmail();
					}
				} catch (InvalidEmail emailException) {
					errorCounter++;
					message += errorCounter + ". E-Mail field must be in form of \"email@some.some\"\n";
					fieldEmail.setForeground(new Color(255, 0, 0));
				}

				try {
					if (!(fieldPhoneNumber.getText().matches("^010-\\d{4}-\\d{4}$"))) {
						throw new InvalidPhoneNumber();
					}
				} catch (InvalidPhoneNumber phoneNumberException) {
					errorCounter++;
					message += errorCounter + ". Phone number field must be in form of \"010-xxxx-xxxx\"\n";
					fieldPhoneNumber.setForeground(new Color(255, 0, 0));
				}

				try {
					if (!(fieldCaptcha.getText().equals(captchaLabel.getText()))) {
						throw new InvalidCaptcha();
					}
				} catch (InvalidCaptcha captchaException) {
					errorCounter++;
					message += errorCounter + ". CAPTCHA is wrong. Try again!\n";
					fieldCaptcha.setForeground(new Color(255, 0, 0));
				}

				finally {
					if (errorCounter == 0) {
						JOptionPane.showMessageDialog(null, "Successfully submitted", "Success",
								JOptionPane.INFORMATION_MESSAGE, null);
						fieldName.setText(null);
						fieldStudentId.setText(null);
						fieldMajor.setText(null);
						fieldEmail.setText(null);
						fieldPhoneNumber.setText(null);
						fieldCaptcha.setText(null);
					} else {
						JOptionPane.showMessageDialog(null, message, "Failure", JOptionPane.ERROR_MESSAGE, null);
						errorCounter = 0;
						obj = new CaptchaGenerator();
						captchaLabel.setText(obj.getCaptcha());
					}
				}

				obj = new CaptchaGenerator();
				captchaLabel.setText(obj.getCaptcha());

			}

		});

		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(553, 549, 128, 50);
		frmSkkuCodingClub.getContentPane().add(btnSubmit);

		obj = new CaptchaGenerator();
		captchaLabel = new JLabel(obj.getCaptcha());
		captchaLabel.setBounds(553, 490, 92, 24);
		frmSkkuCodingClub.getContentPane().add(captchaLabel);

		frmSkkuCodingClub.setVisible(true);
	}
}
