package br.com.poc.app2.coreH2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bill")
@Entity(name = "bill")
public class BillEntity implements Serializable {

    @Id
    @Column(name = "BILL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "CUSTOMER")
    private UUID customer;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BARCODE")
    private String barCode;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "AMOUNT")
    private Long amount;


}
