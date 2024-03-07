package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	private GupshupMock gupshupmock;
	
	
    @Autowired
	public void setGupshupmock(GupshupMock gupshupmock) {
		this.gupshupmock = gupshupmock;
	}

   


	@Override
	public BaseEmailResponse sendEmail(String to, String subject, String body) {
		String resmessage= gupshupmock.getEmailMockedResponse();
		BaseEmailResponse	res= new BaseEmailResponse(true,resmessage);
		return res;
	}

}
