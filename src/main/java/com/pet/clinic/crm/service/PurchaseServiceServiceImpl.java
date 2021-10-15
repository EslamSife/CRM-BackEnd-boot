package com.pet.clinic.crm.service;

import com.pet.clinic.crm.dao.*;
import com.pet.clinic.crm.dto.Purchase;
import com.pet.clinic.crm.dto.PurchaseResponse;
import com.pet.clinic.crm.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PurchaseServiceServiceImpl implements PurchaseServiceService {


    private CustomerRepository customerRepository;

    private PetRepository petRepository;

    private TicketRepository ticketRepository;

    private TicketItemRepository ticketItemRepository;

    private PaymentRepository paymentRepository;

    private PaymentItemRepository paymentItemRepository;

    private ServiceRepository serviceRepository;

    private UserRepository userRepository;

    private TicketStatusRepository ticketStatusRepository;


    public PurchaseServiceServiceImpl(CustomerRepository customerRepository, PetRepository petRepository, TicketRepository ticketRepository,
                                      TicketItemRepository ticketItemRepository, PaymentRepository paymentRepository,
                                      PaymentItemRepository paymentItemRepository, ServiceRepository serviceRepository, UserRepository userRepository, TicketStatusRepository ticketStatusRepository) {
        this.customerRepository = customerRepository;
        this.petRepository = petRepository;
        this.ticketRepository = ticketRepository;
        this.ticketItemRepository = ticketItemRepository;
        this.paymentRepository = paymentRepository;
        this.paymentItemRepository = paymentItemRepository;
        this.serviceRepository = serviceRepository;
        this.userRepository = userRepository;
        this.ticketStatusRepository = ticketStatusRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse purchaseService(Purchase purchase) {

        // map customer model to customer entity and save on db
        Customer customer = purchase.getCustomer();
        customer.setUser(this.userRepository.getById(1));
        customer.setCustomerCode(generateCustomerCode());

        Customer savedCustomer  = this.customerRepository.save(customer);


        // map pet model to customer entity and save on db
        Pet pet = purchase.getPet();
        pet.setOwner(savedCustomer);
        Pet savedPet = this.petRepository.save(pet);

        // map ticket model to customer entity and save on db
        Ticket ticket = purchase.getTicket();
        ticket.setCustomer(savedCustomer);
        // need to be dynamic
        ticket.setTicketStatus(this.ticketStatusRepository.getById(1));
        // need to be dynamic
        ticket.setUser(this.userRepository.getById(1));
        Ticket savedTicket = this.ticketRepository.save(ticket);

        // map ticketItem model to customer entity and save on db
        TicketItem ticketItem = purchase.getTicketItem();
        ticketItem.setTicket(savedTicket);
        ticketItem.setUser(this.userRepository.getById(1));
        ticketItem.setTicketStatus(this.ticketStatusRepository.getById(1));
        ticketItem.setService(this.serviceRepository.getById(purchase.getServiceId()));
        TicketItem savedTicketItem = this.ticketItemRepository.save(ticketItem);


        // map payment model to customer entity and save on db
        Payment payment = purchase.getPayment();
        payment.setTicket(savedTicket);
        Payment savedPayment = this.paymentRepository.save(payment);


        // map paymentItem model to customer entity and save on db
        PaymentItem paymentItem = purchase.getPaymentItem();
        paymentItem.setPayment(savedPayment);
        paymentItem.setTicketItem(savedTicketItem);
        this.paymentItemRepository.save(paymentItem);



        // user under development after login working



        return new PurchaseResponse(purchase.getTicket().getTicketId());
    }

    private String generateCustomerCode() {
        return "2gg";
    }


}
