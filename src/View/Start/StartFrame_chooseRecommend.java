package View.Start;

import Controller.StartController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame_chooseRecommend extends JPanel {

	private StartController controller;

	
	public StartFrame_chooseRecommend() {
		super();
	}

	public StartFrame_chooseRecommend(StartController controller) {
		this.controller = controller;
		JButton button_yes = new JButton("잘 몰라요.. 추천해주세요!!");
		button_yes.setBounds(10, 10, 10, 10);
		button_yes.setActionCommand("yes");
		button_yes.addActionListener(new MyActionListener());

		JButton button_no = new JButton("자신 있어요 내가 직접 만들래요!");
		button_no.setBounds(10, 10, 10, 10);
		button_no.setActionCommand("no");
		button_no.addActionListener(new MyActionListener());

		add(button_yes);
		add(button_no);
		setVisible(true);
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(controller.orderToString());

			if (e.getActionCommand().equals("yes")) {
				controller.change("reco");
			} else {
				controller.change("self");
			}
		}
	}
}
