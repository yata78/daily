package com.example.daily;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="daily_ev")
@Setter
@Getter
public class dailyEv {
    @Id
    private Long id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_detail")
    private String eventDetail;

    @Column(name = "event_data")
    private LocalDate eventDate;
}
