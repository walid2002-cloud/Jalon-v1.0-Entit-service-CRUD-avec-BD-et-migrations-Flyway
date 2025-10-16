// TrackingEventDTO.java
package com.rdvmedical.serviceuser.domain.dto;
import java.time.LocalDateTime;
public class TrackingEventDTO {
    public Long id; public String status; public LocalDateTime eventTime; public Double latitude; public Double longitude; public String proofUrl;
    public Long packageId;
}
