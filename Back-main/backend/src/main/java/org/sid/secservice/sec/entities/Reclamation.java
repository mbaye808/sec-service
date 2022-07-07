package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.Arrays;

/**
 * A Reclamation.
 */
@Entity
@Table(name = "reclamation")
public class Reclamation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    //@NotNull
    @Column(name = "etat", nullable = false)
    private String etat;

    //@NotNull
    @Column(name = "ine", nullable = false)
    private String ine;

    //@NotNull
    @Column(name = "note_reclamation", nullable = false)
    private Float noteReclamation;

    //@NotNull
    @Column(name = "date", nullable = false)
    private Instant date;

    //@NotNull
    @Column(name = "enseignement", nullable = false)
    private String enseignement;

    //@NotNull
    @Column(name = "typeReclamation", nullable = true)
    private String typeReclamation;

    //@NotNull
    @Column(name = "nature", nullable = false)
    private String nature;

    //@NotNull
    @Column(name = "description", nullable = false)
    private String description;

    //@NotNull
    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;

    //@NotNull
    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "photo_content_type")
    private String photoContentType;



    @ManyToOne(optional = false)
    //@NotNull
    @JsonIgnoreProperties(value = "reclamations", allowSetters = true)
    private Note note;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "reclamations", allowSetters = true)
    private AnneeAccademique anneeAccademique;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public Reclamation etat(String etat) {
        this.etat = etat;
        return this;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public Float getNoteReclamation() {
        return noteReclamation;
    }

    public Reclamation noteReclamation(Float noteReclamation) {
        this.noteReclamation = noteReclamation;
        return this;
    }

    public void setNoteReclamation(Float noteReclamation) {
        this.noteReclamation = noteReclamation;
    }

    public Instant getDate() {
        return date;
    }

    public Reclamation date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getEnseignement() {
        return enseignement;
    }

    public void setEnseignement(String enseignement) {
        this.enseignement = enseignement;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Note getNote() {
        return note;
    }

    public Reclamation note(Note note) {
        this.note = note;
        return this;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    

    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    public String getTypeReclamation() {
        return typeReclamation;
    }

    public void setTypeReclamation(String typeReclamation) {
        this.typeReclamation = typeReclamation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reclamation)) {
            return false;
        }
        return id != null && id.equals(((Reclamation) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Reclamation [date=" + date + ", description=" + description + ", etat=" + etat + ", nature=" + nature
                + ", note=" + note + ", noteReclamation=" + noteReclamation + ", photo=" + Arrays.toString(photo)
                + ", photoContentType=" + photoContentType + ", typeReclamation=" + typeReclamation + "]";
    }

    
    // prettier-ignore
   
}
