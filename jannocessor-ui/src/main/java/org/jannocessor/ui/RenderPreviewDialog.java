/**
 * Copyright 2011 jannocessor.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.io.FileUtils;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.processor.model.RenderData;
import org.jannocessor.processor.model.RenderRegister;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.service.render.VelocityTemplateRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderPreviewDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger("UI");

	private final TemplateRenderer renderer = new VelocityTemplateRenderer();

	private final String projectPath;

	private final RenderRegister renderRegister;

	private int index = 0;

	private JTextArea output;

	private JEditorPane input;

	public RenderPreviewDialog(String projectPath, RenderRegister renderRegister) {
		this.projectPath = projectPath;
		this.renderRegister = renderRegister;
		initialize();
	}

	private void initialize() {
		logger.debug("Initializing UI...");
		setTitle("JAnnocessor - Java Annotation Processor");
		setLayout(new BorderLayout(5, 5));

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		double width = screenSize.getWidth() * 0.95;
		double height = screenSize.getHeight() * 0.9;

		Font font = new Font("Courier New", Font.PLAIN, 14);

		input = createInput("", font);
		JScrollPane scroll1 = new JScrollPane(input,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll1.setMinimumSize(new Dimension(200, 200));
		scroll1.setPreferredSize(new Dimension((int) (width * 0.5),
				(int) height));
		add(scroll1, BorderLayout.CENTER);

		output = createOutput(font);
		JScrollPane scroll2 = new JScrollPane(output,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll2.setMinimumSize(new Dimension(200, 200));
		scroll2.setPreferredSize(new Dimension((int) (width * 0.5),
				(int) height));
		add(scroll2, BorderLayout.EAST);

		KeyListener keyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F5) {
					e.consume();
					refresh();
				} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					e.consume();
					dispose();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT && e.isAltDown()) {
					e.consume();
					moveBackward();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && e.isAltDown()) {
					e.consume();
					moveForward();
				} else if (e.getKeyCode() == KeyEvent.VK_S && e.isControlDown()) {
					e.consume();
					save();
				}
			}
		};

		input.addKeyListener(keyListener);
		output.addKeyListener(keyListener);

		setActive(0);

		pack();
		setModal(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	private void setActive(int i) {
		index = i;
		refresh();
	}

	private void moveForward() {
		if (index < renderRegister.getRenderings().size() - 1) {
			setActive(index + 1);
		}
	}

	private void moveBackward() {
		if (index > 0) {
			setActive(index - 1);
		}
	}

	private JEditorPane createInput(String content, Font font) {
		final JEditorPane editor = new JEditorPane();
		editor.setFont(font);
		editor.setBackground(Color.decode("#FFFFFF"));
		editor.setText(content);
		return editor;
	}

	private JTextArea createOutput(Font font) {
		final JTextArea view = new JTextArea();
		view.setFont(font);
		view.setBackground(Color.decode("#EEEEEE"));
		view.setEditable(false);
		return view;
	}

	private String readTemplate(String templateName) {
		String template = "";
		try {
			String tmpl = "src/main/resources/templates";
			String filename = projectPath + tmpl + "/" + templateName + ".vm";
			template = FileUtils.readFileToString(new File(filename));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return template;
	}

	private void save() {
		String content = input.getText();
		System.out.println("Saving...\n" + content);

		try {
			String tmpl = "src/main/resources/templates";
			String filename = projectPath + tmpl + "/"
					+ current().getTemplateName() + ".vm";
			FileUtils.writeStringToFile(new File(filename), content);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void refresh() {
		try {
			RenderData current = current();
			input.setText(readTemplate(current.getTemplateName()));
			output.setText(renderer.render(input.getText(),
					current.getAttributes()));
		} catch (JannocessorException e) {
			e.printStackTrace();
		}
	}

	private RenderData current() {
		RenderData current = renderRegister.getRenderings().get(index);
		return current;
	}

}
