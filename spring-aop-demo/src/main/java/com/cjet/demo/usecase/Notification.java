package com.cjet.demo.usecase;

public interface Notification {
	public void sendGeneralNotification();
	public void sendSQLExceptionNotification();
	public void sendJSonExceptionNotification();
}
