/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lukas
 */
@Entity
@Table(name = "COPY")
@NamedQueries({
    @NamedQuery(name = "Copy.findAll", query = "SELECT c FROM Copy c"),
    @NamedQuery(name = "Copy.findById", query = "SELECT c FROM Copy c WHERE c.id = :id"),
    @NamedQuery(name = "Copy.findByPrintDate", query = "SELECT c FROM Copy c WHERE c.printDate = :printDate")})
public class Copy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PRINT_DATE")
    @Temporal(TemporalType.TIME)
    private Date printDate;
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    @ManyToOne
    private Book bookId;

    public Copy() {
    }

    public Copy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.printDate);
        hash = 43 * hash + Objects.hashCode(this.bookId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Copy other = (Copy) obj;
        if (!Objects.equals(this.printDate, other.printDate)) {
            return false;
        }
        if (!Objects.equals(this.bookId, other.bookId)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "lt.vu.entities.Copy[ id=" + id + " ]";
    }
    
}
