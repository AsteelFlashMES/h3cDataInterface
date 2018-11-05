package com.asteelflash.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by hekeji on 16/10/16.
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue
  private Long id;

  @Column(name = "creationTime")
  private Date creationTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }
}
