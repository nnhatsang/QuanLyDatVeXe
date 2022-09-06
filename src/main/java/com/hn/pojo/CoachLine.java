/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hn.pojo;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Admin
 */
@Entity
@Table(name = "coach_line")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CoachLine.findAll", query = "SELECT c FROM CoachLine c"),
        @NamedQuery(name = "CoachLine.findById", query = "SELECT c FROM CoachLine c WHERE c.id = :id"),
        @NamedQuery(name = "CoachLine.findByName", query = "SELECT c FROM CoachLine c WHERE c.name = :name"),
        @NamedQuery(name = "CoachLine.findByPrice", query = "SELECT c FROM CoachLine c WHERE c.price = :price"),
        @NamedQuery(name = "CoachLine.findByDepartureDate", query = "SELECT c FROM CoachLine c WHERE c.departureDate = :departureDate"),
        @NamedQuery(name = "CoachLine.findByArrivalDate", query = "SELECT c FROM CoachLine c WHERE c.arrivalDate = :arrivalDate"),
        @NamedQuery(name = "CoachLine.findByRemainingSeats", query = "SELECT c FROM CoachLine c WHERE c.remainingSeats = :remainingSeats")})
public class CoachLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Long price;
    @Column(name = "departure_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date departureDate;
    @Column(name = "arrival_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date arrivalDate;
    @Column(name = "remaining_seats")
    private Integer remainingSeats;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coachLine")
    private Collection<Ticket> ticketCollection;

    @JoinColumn(name = "coachway_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CoachWay coachwayId;
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Driver driverId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coachlineId")
    private Collection<Comment> commentCollection;


    public CoachLine() {
    }

    public CoachLine(Integer id) {
        this.id = id;
    }

    public CoachLine(CoachWay coachwayId, Driver driverId) {
        this.coachwayId = coachwayId;
        this.driverId = driverId;
    }

    public CoachLine(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(Integer remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public CoachWay getCoachwayId() {
        return coachwayId;
    }

    public void setCoachwayId(CoachWay coachwayId) {
        this.coachwayId = coachwayId;
    }

    public Driver getDriverId() {
        return driverId;
    }

    public void setDriverId(Driver driverId) {
        this.driverId = driverId;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoachLine)) {
            return false;
        }
        CoachLine other = (CoachLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hn.pojo.CoachLine[ id=" + id + " ]";
    }

}
