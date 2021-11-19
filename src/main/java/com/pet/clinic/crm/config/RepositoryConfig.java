package com.pet.clinic.crm.config;


import com.pet.clinic.crm.entity.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(RoleType.class);
        config.exposeIdsFor(Service.class);
        config.exposeIdsFor(Customer.class);
        config.exposeIdsFor(Ticket.class);
        config.exposeIdsFor(TicketItem.class);
        config.exposeIdsFor(Payment.class);
        config.exposeIdsFor(PaymentItem.class);
    }

}
