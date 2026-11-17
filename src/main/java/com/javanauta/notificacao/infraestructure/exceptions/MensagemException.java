package com.javanauta.notificacao.infraestructure.exceptions;

public class MensagemException extends RuntimeException {
  public MensagemException(String message) {
    super(message);
  }
  public MensagemException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
