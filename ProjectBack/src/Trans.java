import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Trans  implements ActionListener{

	JFrame f;
	JButton bMain, bTrans;
	JLabel lid, ltxid, ltxacc, tfShowAcc;
	private JTextField tfFoundId;
	private JTextField tfInputAcc;
	private JTextField tfTransMoney;
	BankIdAccountDAO dao;
	TransDAO tsdao;
	
	public Trans() {
		
		dao = new BankIdAccountDAO();
		dao.list(MemberVo.user);
		
		
		
		f = new JFrame("����");
		ltxid = new JLabel(MemberVo.user.getId());
		ltxacc = new JLabel(dao.account);
		
		
		
		bMain = new JButton("\uBA54\uC778");
		bTrans = new JButton("�۱�");
		bMain.addActionListener(this);
		bTrans.addActionListener(this);
		
		ltxid.setBounds(240, 5, 82, 25);
		ltxacc.setBounds(135, 34, 187, 25);
		bMain.setBounds(12, 10, 57, 30);
		bTrans.setBounds(106, 509, 122, 30);
		
		f.setSize(350, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.getContentPane().add(bMain);
		f.getContentPane().add(bTrans);
		f.getContentPane().add(ltxid);
		f.getContentPane().add(ltxacc);
		lid = new JLabel("ID : ", JLabel.RIGHT);
		lid.setBounds(204, 7, 32, 20);
		f.getContentPane().add(lid);
		
		JLabel lFoundID = new JLabel("ID \uCC3E\uAE30");
		lFoundID.setBounds(65, 141, 39, 15);
		f.getContentPane().add(lFoundID);
		
		tfFoundId = new JTextField();
		tfFoundId.setBounds(135, 138, 140, 21);
		f.getContentPane().add(tfFoundId);
		tfFoundId.setColumns(10);
		
		tfShowAcc = new JLabel();
		tfShowAcc.setBounds(48, 197, 227, 21);
		f.getContentPane().add(tfShowAcc);
		
		JLabel lInputAcc = new JLabel("\uACC4\uC88C\uBC88\uD638");
		lInputAcc.setBounds(65, 326, 58, 15);
		f.getContentPane().add(lInputAcc);
		
		tfInputAcc = new JTextField();
		tfInputAcc.setColumns(10);
		tfInputAcc.setBounds(135, 323, 140, 21);
		f.getContentPane().add(tfInputAcc);
		
		tfTransMoney = new JTextField();
		tfTransMoney.setColumns(10);
		tfTransMoney.setBounds(48, 402, 212, 21);
		f.getContentPane().add(tfTransMoney);
		
		JLabel lWon = new JLabel("\uC6D0");
		lWon.setBounds(266, 405, 20, 15);
		f.getContentPane().add(lWon);
		
		JButton btnNewButton = new JButton("\uC870\uD68C");
		btnNewButton.setBounds(114, 164, 97, 23);
		f.getContentPane().add(btnNewButton);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("����")) {
			new Bank();
			f.setVisible(false);
		}
		if(e.getActionCommand().equals("��ȸ")) {
			TransVo v = new TransVo(tfFoundId.getText());
			if(e.getActionCommand().equals("�۱�")) {
				new Trans();
				f.setVisible(false);
				
			}
		}
		
	}

	public static void main (String[] args) {
		 new Trans();
	}
}