package xyz.sanjiaomao.infrastructure.plant.dataobject;

import java.util.Date;

public class Plant {
  private Long id;

  private String plantName;

  private Date plantDate;

  private String plantKey;

  private Long accountId;

  private Integer isDeleted;

  private String plantContent;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPlantName() {
    return plantName;
  }

  public void setPlantName(String plantName) {
    this.plantName = plantName == null ? null : plantName.trim();
  }

  public Date getPlantDate() {
    return plantDate;
  }

  public void setPlantDate(Date plantDate) {
    this.plantDate = plantDate;
  }

  public String getPlantKey() {
    return plantKey;
  }

  public void setPlantKey(String plantKey) {
    this.plantKey = plantKey == null ? null : plantKey.trim();
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Integer getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
  }

  public String getPlantContent() {
    return plantContent;
  }

  public void setPlantContent(String plantContent) {
    this.plantContent = plantContent == null ? null : plantContent.trim();
  }
}