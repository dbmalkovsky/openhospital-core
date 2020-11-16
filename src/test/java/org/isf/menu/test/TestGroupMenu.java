/*
 * Open Hospital (www.open-hospital.org)
 * Copyright © 2006-2020 Informatici Senza Frontiere (info@informaticisenzafrontiere.org)
 *
 * Open Hospital is a free and open source software for healthcare data management.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * https://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.isf.menu.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.isf.menu.model.GroupMenu;
import org.isf.utils.exception.OHException;

public class TestGroupMenu {

	private String userGroup = "TestDescription";
	private String menuItem = "TestDescription";

	public GroupMenu setup(boolean usingSet) throws OHException {
		GroupMenu groupMenu;

		if (usingSet) {
			groupMenu = new GroupMenu();
			_setParameters(groupMenu);
		} else {
			// Create GroupMenu with all parameters 
			groupMenu = new GroupMenu(userGroup, menuItem);
		}

		return groupMenu;
	}

	public void _setParameters(GroupMenu groupMenu) {
		groupMenu.setUserGroup(userGroup);
		groupMenu.setMenuItem(menuItem);
	}

	public void check(GroupMenu groupMenu) {
		assertThat(groupMenu.getUserGroup()).isEqualTo(userGroup);
		assertThat(groupMenu.getMenuItem()).isEqualTo(menuItem);
	}
}
