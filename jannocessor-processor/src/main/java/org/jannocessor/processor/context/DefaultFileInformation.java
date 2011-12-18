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

package org.jannocessor.processor.context;

import java.util.Date;

import org.jannocessor.processor.api.FileInformation;

public class DefaultFileInformation implements FileInformation {

	private String content;
	private String filename;
	private Date lastModifiedOn;

	public DefaultFileInformation(String content, String filename, Date lastModifiedOn) {
		this.content = content;
		this.filename = filename;
		this.lastModifiedOn = lastModifiedOn;
	}

	public String getContent() {
		return content;
	}

	public String getFilename() {
		return filename;
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	@Override
	public String toString() {
		return "DefaultFileInformation [content=[" + content.length() + " chars], filename="
				+ filename + ", lastModifiedOn=" + lastModifiedOn + "]";
	}

}
