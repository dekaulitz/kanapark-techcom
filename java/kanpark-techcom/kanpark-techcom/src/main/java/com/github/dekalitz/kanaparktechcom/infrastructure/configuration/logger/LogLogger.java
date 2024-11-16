package com.github.dekalitz.kanaparktechcom.infrastructure.configuration.logger;

import org.slf4j.Logger;

public interface LogLogger {


  void info(String s, Object o, Object o1);


  void info(String s, Object... objects);


  void info(String s, Throwable throwable);


  void warn(String s);


  void warn(String s, Throwable throwable);


  void warn(String s, Object o);


  void warn(String s, Object... objects);


  void warn(String s, Object o, Object o1);


  void error(String s);


  void error(String s, Throwable throwable);


  void error(String s, Object... objects);


  void error(String s, Object o, Object o1);


  void error(String s, Object o);
}
