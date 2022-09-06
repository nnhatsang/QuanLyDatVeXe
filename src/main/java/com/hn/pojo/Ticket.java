/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hn.pojo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id"),
    @NamedQuery(name = "Ticket.findByName", query = "SELECT t FROM Ticket t WHERE t.name = :name")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "price")
    private double price;

    @Basic
    @Column(name = "amount")
    private int amount;

    @JoinColumn(name = "coach_line_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CoachLine coachLine;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    @ManyToOne
//    @ManyToOne(optional = false)
    private Staff staff;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId")
//    private Collection<TicketDetail> ticketDetailCollection;

    public Ticket() {
    }

    public Ticket(Integer id) {
        this.id = id;
    }

    public Ticket(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoachLine getCoachLine() {
        return coachLine;
    }

    public void setCoachLine(CoachLine coachLineId) {
        this.coachLine = coachLineId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customerId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staffId) {
        this.staff = staffId;
    }

//    @XmlTransient
//    public Collection<TicketDetail> getTicketDetailCollection() {
//        return ticketDetailCollection;
//    }
//
//    public void setTicketDetailCollection(Collection<TicketDetail> ticketDetailCollection) {
//        this.ticketDetailCollection = ticketDetailCollection;
//    }

    @Override
    public String toString() {
        return "com.hn.pojo.Ticket[ id=" + id + " ]";
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
