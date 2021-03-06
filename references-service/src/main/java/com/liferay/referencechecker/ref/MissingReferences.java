/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.referencechecker.ref;

import java.util.Collection;

/**
 * @author Jorge Díaz
 */
public class MissingReferences {

	public MissingReferences(
		Reference reference, Collection<Object[]> values, long affectedRows) {

		this.reference = reference;
		this.values = values;
		this.affectedRows = affectedRows;
	}

	public MissingReferences(Reference reference, Throwable throwable) {
		this.reference = reference;
		this.throwable = throwable;
	}

	public long getAffectedRows() {
		return affectedRows;
	}

	public Reference getReference() {
		return reference;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public Collection<Object[]> getValues() {
		return values;
	}

	protected long affectedRows = -1L;
	protected Reference reference = null;
	protected Throwable throwable = null;
	protected Collection<Object[]> values = null;

}