import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Bank implements ActionListener {
	JFrame f;
	JButton bCheck, bTrans;
	JLabel lid, ltxid, lacc;
	private JTextField textField;
	BankIdAccountDAO dao;
	
	public Bank() {

		// id¶û account ºÒ·¯¿À±â (MemberVo static ¸Þ¼Òµå »ç¿ë)
		dao = new BankIdAccountDAO();
		dao.list(MemberVo.user);
		ltxid = new JLabel(MemberVo.user.getId());
		lacc = new JLabel(dao.account);
		
		f = new JFrame("ZBank");
		f.getContentPane().setBackground(SystemColor.inactiveCaption);
		
		ltxid.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lacc.setFont(new Font("±¼¸²", Font.BOLD, 14));

		bCheck = new JButton("Á¶È¸");
		bTrans = new JButton("ÀÌÃ¼");
		bCheck.addActionListener(this);
		bTrans.addActionListener(this);

		ltxid.setBounds(41, 5, 82, 25);
		lacc.setBounds(240, 5, 82, 25);
		bCheck.setBounds(28, 199, 122, 30);
		bTrans.setBounds(180, 199, 122, 30);

		f.setSize(350, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.getContentPane().add(bCheck);
		f.getContentPane().add(bTrans);
		f.getContentPane().add(ltxid);
		f.getContentPane().add(lacc);
		lid = new JLabel("ID ", JLabel.RIGHT);
		lid.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lid.setBounds(12, 10, 23, 15);
		f.getContentPane().add(lid);

		textField = new JTextField();
		textField.setBounds(55, 105, 193, 30);
		f.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lwon = new JLabel("\uC6D0");
		lwon.setForeground(new Color(0, 0, 0));
		lwon.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lwon.setBounds(253, 104, 34, 30);
		f.getContentPane().add(lwon);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Á¶È¸")) {
			new Check();
			f.setVisible(false);
		}
		if (e.getActionCommand().equals("ÀÌÃ¼")) {
			new Trans();
			f.setVisible(false);
		}

	}

	public static void main(String[] args) {
		new Bank();
	}
}