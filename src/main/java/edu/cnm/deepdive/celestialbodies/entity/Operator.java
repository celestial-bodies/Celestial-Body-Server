package edu.cnm.deepdive.celestialbodies.entity;


import edu.cnm.deepdive.celestialbodies.view.FlatOperator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

@Entity
public class Operator  implements FlatOperator {


  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "operator_id", columnDefinition = "CHAR(16) FOR BIT DATA",
    nullable = false, updatable = false)
  private UUID id;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @NonNull
  @Column(length = 1024, nullable = false, unique = true)
  private String profile;

  @NonNull
  @Column
  private Long auth;

  @NonNull
  @Column
  private Long rating;

  @OneToMany(mappedBy = "operator", fetch = FetchType.EAGER)
  private List<Stellar> stellar = new LinkedList<>();

  public UUID getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public Long getAuth() {
    return auth;
  }

  public void setAuth(Long auth) {
    this.auth = auth;
  }

  public Long getRating() {
    return rating;
  }

  public void setRating(Long rating) {
    this.rating = rating;
  }

  public List<Stellar> getStellar() {
    return stellar;
  }

  public void setStellar(List<Stellar> stellar) {
    this.stellar = stellar;
  }
}
