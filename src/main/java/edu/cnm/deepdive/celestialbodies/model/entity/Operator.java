package edu.cnm.deepdive.celestialbodies.model.entity;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.NonNull;

@Entity
public class Operator {



  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "operator_id", nullable = false, updatable = false)
  private long id;

  @Column(name = "user_email")
  private String userEmail;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
}
