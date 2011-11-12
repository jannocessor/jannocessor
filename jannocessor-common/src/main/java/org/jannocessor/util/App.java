/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

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
