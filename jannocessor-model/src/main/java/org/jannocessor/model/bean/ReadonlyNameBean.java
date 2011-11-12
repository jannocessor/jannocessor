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

package org.jannocessor.model.bean;

import org.jannocessor.model.Name;

public class ReadonlyNameBean extends NameBean {

	private static final long serialVersionUID = 427742519840634024L;
	
	private static final String ERROR_MSG = "Can't modify a read-only name! Try creating a copy of it.";

	public ReadonlyNameBean(String name) {
		super(name);
	}

	@Override
	public Name deleteParts(int... positions) {
		throw exception();
	}

	@Override
	public Name insertPart(int position, String part) {
		throw exception();
	}

	@Override
	public Name appendPart(String part) {
		throw exception();
	}

	@Override
	public Name replacePart(int position, String part) {
		throw exception();
	}

	@Override
	public void assign(String name) {
		throw exception();
	}

	private RuntimeException exception() {
		return new RuntimeException(ERROR_MSG);
	}

}
