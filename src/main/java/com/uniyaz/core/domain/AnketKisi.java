package com.uniyaz.core.domain;

import javax.persistence.*;


@Entity
@Table(name = "ANKET_KISI")
public class AnketKisi extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANKET", foreignKey = @ForeignKey(name = "FK_ANKET_KISI_ANKET"))
    private Anket anket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KISI", foreignKey = @ForeignKey(name = "FK_ANKET_KISI_KISI"))
    private Kisi kisi;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  public Anket getAnket() { return anket; }

    public void setAnket(Anket anket) { this.anket = anket; }

    public Kisi getKisi() { return kisi; }

    public void setSoru(Kisi kisi) { this.kisi = kisi; }
}
