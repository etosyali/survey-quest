package com.uniyaz.core.domain;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "KISI")
public class Kisi extends BaseEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADI", nullable = false, length = 100)
    @NotNull
    private String adi;

    @Column(name="EMAİL", nullable = false,length = 100)
    @NotNull
    private String email;



    @Override
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getAdi() { return adi; }

    public void setAdi(String adi) { this.adi = adi; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }



}
