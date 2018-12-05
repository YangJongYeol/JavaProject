package View.Self;

import View.Self.SelfFrame.JPanel022;
import View.Self.SelfFrame.JPanel033;
import View.Self.SelfFrame.JPanel044;
import View.Self.SelfFrame.JPanel055;
import View.Self.SelfFrame.JPanel066;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SelfTemp extends JFrame implements ActionListener, ItemListener {

	class JPanel011 extends JPanel {
		JRadioButton[] radio = new JRadioButton[8];
		ButtonGroup group = new ButtonGroup();
		String[] menu = { "햄", "참치", "로스트 비프", "에그마요", "비엘티", "미트볼", "터키", "베지" };
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel[] picturePanel = new JPanel[8];
		JButton btn1;
		CardLayout card = new CardLayout();
		JLabel[] pictureLabel = new JLabel[8];
		ImageIcon[] icon = new ImageIcon[8];

		JPanel011() {
			this.setSize(550, 700);
			this.setLayout(new BorderLayout(0, 10));
			panel1.setLayout(new GridLayout(3, 4, 20, 10));
			Border border = BorderFactory.createTitledBorder("원하는 샌드위치 메뉴를 선택하세요.");
			panel1.setBorder(border);
			this.add(panel1, BorderLayout.NORTH);
			
			for (int i = 0; i < menu.length; i++) {
				radio[i] = new JRadioButton(menu[i]);
				panel1.add(radio[i]);
				group.add(radio[i]);
				radio[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (radio[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + menu[i] + ".jpg"); // 이미지 파일 이름
				pictureLabel[i] = new JLabel("");
				panel3.add(pictureLabel[i]);
			}
			this.add(panel2, BorderLayout.SOUTH);
			btn1 = new JButton("다음");
			btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jtab.setSelectedIndex(1);
					jtab.setEnabledAt(0, true);
					jtab.setEnabledAt(1, true);
				}

			});
			panel2.add(btn1);
			this.add(panel3, BorderLayout.CENTER);
			panel3.setLayout(card);
		}

	}

	JPanel011 jpanel1 = null;
	JPanel022 jpanel2 = null;
	JPanel033 jpanel3 = null;
	JPanel044 jpanel4 = null;
	JPanel055 jpanel5 = null;
	JPanel066 jpanel6 = null;

	JTabbedPane jtab = new JTabbedPane();

	public SelfTemp() {
		setTitle("Which Sandwich?");

//		jpanel1 = new JPanel011();
//		jpanel2 = new JPanel022();
//		jpanel3 = new JPanel033();
//		jpanel4 = new JPanel044();
//		jpanel5 = new JPanel055();
//		jpanel6 = new JPanel066();

		jtab.addTab("메뉴", jpanel1);
		jtab.addTab("빵", jpanel2);
		jtab.addTab("추가토핑", jpanel3);
		jtab.addTab("야채", jpanel4);
		jtab.addTab("소스", jpanel5);
		jtab.addTab("세트", jpanel6);

		for (int i = 1; i < jtab.getTabCount(); i++)
			jtab.setEnabledAt(i, false);

		add(jtab);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 700);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

}