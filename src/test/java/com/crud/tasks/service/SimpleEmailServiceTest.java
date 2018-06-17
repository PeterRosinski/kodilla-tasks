package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = new Mail("test@test.com",null, "Test", "Test message");

        //When
        simpleEmailService.send(mail,EmailType.EVERYDAY_EMAIL);

        //Then
        verify(javaMailSender,times(1)).send(any(MimeMessagePreparator.class));
    }

    @Test
    public void shouldSendEmailToCc() {
        //Given
        Mail mail = new Mail("test@test.com","testCC@test.com", "Test", "Test message");

        //When
        simpleEmailService.send(mail,EmailType.EVERYDAY_EMAIL);

        //Then
        verify(javaMailSender,times(1)).send(any(MimeMessagePreparator.class));
    }

}