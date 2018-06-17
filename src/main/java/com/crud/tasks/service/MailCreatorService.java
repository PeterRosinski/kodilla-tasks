package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/index.html");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "This is an automated message - please do not reply directly to this e-mail.");
        context.setVariable("companyName", companyConfig.getCompanyName());
        context.setVariable("companyDescription", companyConfig.getCompanyDescription());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildEveryDayEmail(String message) {

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/index.html");
        context.setVariable("button", "Visit website");
        context.setVariable("companyName", companyConfig.getCompanyName());
        context.setVariable("companyDescription", companyConfig.getCompanyDescription());
        return templateEngine.process("mail/every-day-mail", context);

    }

    public String buildEmail(String message, String typeOfEmail) {

        switch (typeOfEmail) {
            case EmailType.EVERYDAY_EMAIL:
                return buildEveryDayEmail(message);
            case EmailType.TRELLOCARD_EMAIL:
                return buildTrelloCardEmail(message);
            default:
                return null;
        }
    }

}
