package edu.cnm.deepdive.celestialbodies.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

@Entity
public class OperatorQuery {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "operator_query_id", nullable = false, updatable = false)
  private long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "operator_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Operator operator;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  private long catalogId;

  private String starName;

  private String constellationName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public long getCatalogId() {
    return catalogId;
  }

  public void setCatalogId(long catalogId) {
    this.catalogId = catalogId;
  }

  public String getStarName() {
    return starName;
  }

  public void setStarName(String starName) {
    this.starName = starName;
  }

  public String getConstellationName() {
    return constellationName;
  }

  public void setConstellationName(String constellationName) {
    this.constellationName = constellationName;
  }
}
