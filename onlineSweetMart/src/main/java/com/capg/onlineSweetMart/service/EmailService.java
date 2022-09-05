package com.capg.onlineSweetMart.service;

public interface EmailService {
     public boolean sendMail(String message, String subject, String to);
}
