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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.io.FileUtils;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.processor.model.RenderData;
import org.jannocessor.processor.model.RenderRegister;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.service.render.VelocityTemplateRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderPreviewDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger("UI");

	private final TemplateRenderer renderer;

	private final String templatesPath;

	private final RenderRegister renderRegister;

	private int index = 0;

	private JTextArea output;

	private JEditorPane input;

	private Collection<File> files;

	private JComboBox combo;

	private String activeTemplate;

	public RenderPreviewDialog(String templatesPath,
			RenderRegister renderRegister, Configurator configurator) {
		this.templatesPath = templatesPath;
		this.renderRegister = renderRegister;

		renderer = new VelocityTemplateRenderer(configurator);
		initialize();
	}

	private void initialize() {
		logger.debug("Initializing UI...");
		setTitle("JAnnocessor - Java Annotation Processor");
		setLayout(new BorderLayout(5, 5));

		listFiles();

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

		combo = createCombo();

		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				load((File) combo.getSelectedItem());
			}
		});

		add(combo, BorderLayout.NORTH);

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

	private JComboBox createCombo() {
		JComboBox combo = new JComboBox(files.toArray());

		return combo;
	}

	private void setActive(int i) {
		index = i;
		reload();
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
		if (!templateName.endsWith(".vm")) {
			templateName = fullTemplateName(templateName);
		}
		template = readFile(templateName);
		activeTemplate = templateName;
		return template;
	}

	private String readFile(String fileName) {
		try {
			return FileUtils.readFileToString(new File(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String fullTemplateName(String templateName) {
		return templatesPath + "/" + templateName + ".vm";
	}

	private void save() {
		String content = input.getText();
		System.out.println("Saving: " + activeTemplate);

		try {
			FileUtils.writeStringToFile(new File(activeTemplate), content);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void refresh() {
		try {
			RenderData current = current();
			String tmpl = fullTemplateName(current.getTemplateName());
			output.setText(renderer.render(readFile(tmpl),
					current.getAttributes()));
		} catch (JannocessorException e) {
			e.printStackTrace();
		}
	}

	private void reload() {
		RenderData current = current();
		input.setText(readTemplate(current.getTemplateName()));
		refresh();
	}

	private void load(File file) {
		try {
			input.setText(readTemplate(file.getCanonicalPath()));
			refresh();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private RenderData current() {
		RenderData current = renderRegister.getRenderings().get(index);
		return current;
	}

	private void listFiles() {
		files = FileUtils.listFiles(new File(templatesPath),
				new String[] { "vm" }, true);
	}
}
