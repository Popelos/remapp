/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hello Java !
 */
@Entity
@Table(name = "order", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o")
    , @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id")
    , @NamedQuery(name = "Order1.findByOrderdate", query = "SELECT o FROM Order1 o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "Order1.findByPaymentMethod", query = "SELECT o FROM Order1 o WHERE o.paymentMethod = :paymentMethod")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "payment_method")
    private String paymentMethod;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EnrolledUser clientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private List<Orderlist> orderlistList;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Order1(Integer id, Date orderdate, String paymentMethod) {
        this.id = id;
        this.orderdate = orderdate;
        this.paymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public EnrolledUser getClientId() {
        return clientId;
    }

    public void setClientId(EnrolledUser clientId) {
        this.clientId = clientId;
    }

    public List<Orderlist> getOrderlistList() {
        return orderlistList;
    }

    public void setOrderlistList(List<Orderlist> orderlistList) {
        this.orderlistList = orderlistList;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.Order1[ id=" + id + " ]";
    }
    
}
