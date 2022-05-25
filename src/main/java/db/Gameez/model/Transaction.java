package db.Gameez.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long transactionsId;
    @Column(nullable = false)
    private double value;
    //private Date date;
    private String type;

    public Long getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(Long id) {
        this.transactionsId = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
