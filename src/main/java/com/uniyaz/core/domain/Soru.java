package com.uniyaz.core.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SORU")
public class Soru extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SORUYAZ", nullable = false,length = 255)
    @NotNull
    private String soruyaz;

    @Column(name = "SECENEK",length = 100)
    private String secenek;

    @Column(name ="CEVAP", length = 100)
    private String cevap;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANKET", foreignKey = @ForeignKey(name = "FK_ANKET_SORU_ANKET"))
    private Anket anket;



    @Override
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getSecenek() { return secenek; }

    public void setAdi(String secenek) { this.secenek = secenek; }

    public String getCevap() { return cevap; }

    public void setCevap(String cevap) { this.cevap = cevap; }

    public String getSoruyaz() { return soruyaz; }

    public void setSoruyaz(String soruyaz) { this.soruyaz = soruyaz; }

    public Anket getAnket() { return anket; }

    public void setAnket(Anket anket) { this.anket = anket; }
}


