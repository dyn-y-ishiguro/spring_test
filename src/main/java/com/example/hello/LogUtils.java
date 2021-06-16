package com.example.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// テスト用
// 本番には不要
public class LogUtils {
	protected final static Logger logger = LoggerFactory.getLogger(LogUtils.class);
	public static void trace(String msg) {
		logger.trace(msg);
	}
	public static void debug(String msg) {
		logger.debug(msg);
	}
	public static void info(String msg) {
		logger.info(msg);
	}
	public static void warn(String msg) {
		logger.warn(msg);
	}
	public static void error(String msg) {
		logger.error(msg);
	}
}
