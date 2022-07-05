import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class NewLogin implements ActionListener{
	UserDAO dao;
	private JFrame f;
	private JButton bJoin;
	private JLabel lname, lid, lpw;
	JTextField name, id, pw;
	private JPanel panel;
	private boolean membershipProgress = false;
	
	public NewLogin() {
		dao = new UserDAO();
		f = new JFrame("ȸ������");
		
		
		f.setSize(350, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setBackground(Color.white);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel.setBounds(0, 0, 334, 261);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		lname = new JLabel("�̸�");
		lname.setBounds(61, 41, 46, 15);
		panel.add(lname);
		lname.setForeground(SystemColor.textHighlight);
		name = new JTextField();
		name.setBounds(61, 55, 220, 25);
		panel.add(name);
		lid = new JLabel("ID");
		lid.setBounds(61, 91, 46, 15);
		panel.add(lid);
		lid.setForeground(SystemColor.textHighlight);
		id = new JTextField();
		id.setBounds(61, 105, 220, 25);
		panel.add(id);
		lpw = new JLabel("PW");
		lpw.setBounds(61, 140, 57, 15);
		panel.add(lpw);
		lpw.setForeground(SystemColor.textHighlight);
		pw = new JTextField();
		pw.setBounds(61, 155, 220, 25);
		panel.add(pw);
		
		bJoin = new JButton("�����ϱ�");
		bJoin.setBounds(106, 200, 122, 30);
		panel.add(bJoin);
		bJoin.setForeground(SystemColor.textHighlight);
		bJoin.addActionListener(this);
		f.setVisible(true);
		
	
	}

	public static void main(String[] args) {
		new NewLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(name.getText().trim().length()==0 || name.getText().trim().equals("�̸�")) {
			JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���", "", JOptionPane.WARNING_MESSAGE);
			name.grabFocus();
			return;
		}
		if(id.getText().trim().length()==0 || id.getText().trim().equals("���̵�")) {
			JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���", "", JOptionPane.WARNING_MESSAGE);
			id.grabFocus();
			return;
		}
		if(pw.getText().trim().length()==0) {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���", "", JOptionPane.WARNING_MESSAGE);
			pw.grabFocus();
			return;
		}
		membershipProgress = true;
		
		if(e.getActionCommand().equals("�����ϱ�")) {
			UserVo nv = new UserVo(name.getText(), id.getText(), pw.getText());
			boolean b = dao.list(nv);
			
			if(b == true) {
				UserVo.userinit(nv);
				new Hello();
			}else {
				JOptionPane.showMessageDialog(null, "���ο� id�� �Է��ϼ���", "����", JOptionPane.WARNING_MESSAGE);
				new NewLogin();
				f.setVisible(false);
				
			}
			
		
		}
	}

}
