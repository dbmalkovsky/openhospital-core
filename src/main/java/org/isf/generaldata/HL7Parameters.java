/*
 * Open Hospital (www.open-hospital.org)
 * Copyright © 2006-2021 Informatici Senza Frontiere (info@informaticisenzafrontiere.org)
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
package org.isf.generaldata;

public final class HL7Parameters extends ConfigurationProperties {

	private static final String FILE_PROPERTIES = "hl7.properties";

	public static String DOMAIN;
	public static int PORT;
	public static boolean TLS;

	private static final String DEFAULT_DOMAIN = "127.0.0.1";
	private static final int DEFAULT_PORT = 51000;
	private static final boolean DEFAULT_TLS = false;

	private HL7Parameters(String fileProperties) {
		super(fileProperties);
		DOMAIN = myGetProperty("hl7.domain", DEFAULT_DOMAIN);
		PORT = myGetProperty("hl7.port", DEFAULT_PORT);
		TLS = myGetProperty("hl7.tls", DEFAULT_TLS);
	}

	public static void initialize() {
		new HL7Parameters(FILE_PROPERTIES);
	}

}
