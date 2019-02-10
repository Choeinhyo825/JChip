package view;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class testPU extends JFrame {
	public testPU() {
		JFrame mf = new JFrame("tset");
		mf.setBounds(150, 150, 515, 620);

		JTextArea ta = new JTextArea(10, 30);

		try (BufferedReader br = new BufferedReader(new FileReader("sample2.txt"))) {

			String temp;
			while ((temp = br.readLine()) != null) {
				ta.append(temp + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		mf.add(ta, "Center");

		mf.setVisible(true);
	}
}
