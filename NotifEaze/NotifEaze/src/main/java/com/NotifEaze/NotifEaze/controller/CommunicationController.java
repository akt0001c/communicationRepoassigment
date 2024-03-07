package com.NotifEaze.NotifEaze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.service.EmailService;
import com.NotifEaze.NotifEaze.service.PushNotificationService;
import com.NotifEaze.NotifEaze.service.SmsService;

@RestController
@RequestMapping("/api/communication")
public class CommunicationController {
	
	

	private SmsService smsservice;
	private EmailService eservice;
	private PushNotificationService pnservice;
	
	@Autowired
	public void setSmsservice(SmsService smsservice) {
		this.smsservice = smsservice;
	}

	@Autowired
	public void setEservice(EmailService eservice) {
		this.eservice = eservice;
	}

	@Autowired
	public void setPnservice(PushNotificationService pnservice) {
		this.pnservice = pnservice;
	}
	
    @PostMapping("/send-sms")
    public ResponseEntity<BaseSmsResponse> sendSms() {
        BaseSmsResponse res= smsservice.sendSms("123456", "This is sms body");
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @PostMapping("/send-email")
    public ResponseEntity<BaseEmailResponse> sendEmail() {
        BaseEmailResponse res= eservice.sendEmail("user","This is email subject","This is email body");
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @PostMapping("/send-notification")
    public ResponseEntity<BasePushNotificationResponse> sendNotification() {
        BasePushNotificationResponse res= pnservice.sendNotification("FCMToken1","this is message");
        
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }
}
