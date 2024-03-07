package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.SmsService;


@Service
public class SmsServiceImpl implements SmsService {

	private GupshupMock gupshupmock;
	private KayleraMock kayleramock;
	
    @Autowired
	public void setGupshupmock(GupshupMock gupshupmock) {
		this.gupshupmock = gupshupmock;
	}

    @Autowired
	public void setKayleramock(KayleraMock kayleramock) {
		this.kayleramock = kayleramock;
	}

	@Override
	public BaseSmsResponse sendSms(String phoneNumber, String message) {
		String resmessage= null;
		BaseSmsResponse res= null;
		if(phoneNumber.equals("123456"))
		{
			  resmessage= kayleramock.getSmsMockedResponses(phoneNumber);
			  res= new BaseSmsResponse(true,resmessage);
		}else
		{
		      phoneNumber="789012";
		      resmessage= kayleramock.getSmsMockedResponses(phoneNumber);
		      res= new BaseSmsResponse(false,resmessage);
		}
			  
		return res;
	}

	@Override
	public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
		String resmessage=null;
		SmsDeliveryStatus  res=null;
		if(messageId.equals("MessageId1"))
		{
			resmessage= gupshupmock.getSmsDeliveryStatusMockedResponse(messageId);
			res= new SmsDeliveryStatus(true,resmessage);
		}
		else
		{
			messageId="MessageId2";
			resmessage= gupshupmock.getSmsDeliveryStatusMockedResponse(messageId);
			res= new SmsDeliveryStatus(false,resmessage);
		}
		
		return res;
	}

}
