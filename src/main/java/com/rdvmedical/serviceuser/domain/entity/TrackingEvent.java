package com.rdvmedical.serviceuser.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TrackingEvent {

    public enum TrackingStatus {
        PACKAGE_SHIPPED, IN_TRANSIT, DELIVERY_ATTEMPTED, PACKAGE_DELIVERED, RETURNED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)   // <-- length en minuscules
    private TrackingStatus status;

    @Column(nullable = false)
    private LocalDateTime eventTime = LocalDateTime.now();

    private Double latitude;    // <-- en minuscules
    private Double longitude;   // <-- en minuscules
    private String proofUrl;

    @ManyToOne(optional = false)
    private PackageParcel pkg;

    // ======= Getters / Setters =======

    public Long getId() { return id; }

    public TrackingStatus getStatus() { return status; }
    public void setStatus(TrackingStatus status) { this.status = status; }

    public LocalDateTime getEventTime() { return eventTime; }
    public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public String getProofUrl() { return proofUrl; }
    public void setProofUrl(String proofUrl) { this.proofUrl = proofUrl; }

    public PackageParcel getPkg() { return pkg; }
    public void setPkg(PackageParcel pkg) { this.pkg = pkg; }
}
