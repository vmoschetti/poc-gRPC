package br.com.poc.app1.coreH2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dda")
@Entity(name = "dda")
public class DDAEntity implements Serializable {

    @Id
    @Column(name = "DDA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "CUSTOMER")
    private UUID customer;

    @Column(name = "NAME")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DDAStatus status;

}
