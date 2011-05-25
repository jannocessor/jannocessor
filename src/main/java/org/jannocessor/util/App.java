package org.jannocessor.util;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class App {

	private static final String INFO = "<html><center><i>JAnnocessor</i> is an extensible framework for Java annotations processing for the purpose of code generation, annotation validation and metadata manipulation.</center></html>";

	public static void main(String[] args) {
		showDialog();
	}

	private static void showDialog() {
		JDialog dlg = new JDialog();

		dlg.setTitle("JAnnocessor - Java Annotation Processor");
		dlg.setPreferredSize(new Dimension(500, 100));

		JLabel text = new JLabel(INFO);
		dlg.add(text);

		dlg.pack();
		dlg.setModal(true);
		dlg.setLocationRelativeTo(null);
		dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dlg.setVisible(true);
	}
}
