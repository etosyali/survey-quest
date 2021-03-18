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


    @Column(name = "SORUTIPI")
    private String sorutipi;




    @Column(name = "CEVAP",  nullable = true, length = 100)
    @Enumerated(EnumType.STRING)
    private EnumSoruTipi enumSoruTipi;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANKET", foreignKey = @ForeignKey(name = "FK_ANKET_SORU_ANKET"))
    private Anket anket;




    @Override
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public EnumSoruTipi getEnumSoruTipi() {
        return enumSoruTipi;
    }

    public void setEnumSoruTipi(EnumSoruTipi enumSoruTipi) {
        this.enumSoruTipi = enumSoruTipi;
    }


    public String getSorutipi() { return sorutipi; }

    public void setSorutipi(String sorutipi) { this.sorutipi = sorutipi; }

    public String getSoruyaz() { return soruyaz; }

    public void setSoruyaz(String soruyaz) { this.soruyaz = soruyaz; }

    public Anket getAnket() { return anket; }

    public void setAnket(Anket anket) { this.anket = anket; }
}


