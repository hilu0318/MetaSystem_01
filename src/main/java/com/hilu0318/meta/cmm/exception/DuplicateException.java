package com.hilu0318.meta.cmm.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateException extends SQLIntegrityConstraintViolationException {
	public DuplicateException() {super(); }
	public DuplicateException(String msg) { super(msg); }
}
