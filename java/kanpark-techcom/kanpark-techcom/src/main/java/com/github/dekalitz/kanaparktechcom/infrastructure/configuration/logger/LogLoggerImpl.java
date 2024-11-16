package com.github.dekalitz.kanaparktechcom.infrastructure.configuration.logger;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


public class LogLoggerImpl implements LogLogger {


  private final Logger log;

  public LogLoggerImpl(Logger log) {
    this.log = log;
  }

  @Override
  public void info(String s, Object o, Object o1) {
    log.info(s, o, o1);
  }

  @Override
  public void info(String s, Object... objects) {

  }

  @Override
  public void info(String s, Throwable throwable) {

  }

  @Override
  public void warn(String s) {

  }

  @Override
  public void warn(String s, Throwable throwable) {

  }

  @Override
  public void warn(String s, Object o) {

  }

  @Override
  public void warn(String s, Object... objects) {

  }

  @Override
  public void warn(String s, Object o, Object o1) {

  }

  @Override
  public void error(String s) {

  }

  @Override
  public void error(String s, Throwable throwable) {

  }

  @Override
  public void error(String s, Object... objects) {

  }

  @Override
  public void error(String s, Object o, Object o1) {

  }

  @Override
  public void error(String s, Object o) {

  }
}
