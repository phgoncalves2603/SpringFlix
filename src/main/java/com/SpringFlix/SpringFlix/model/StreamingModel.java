package com.SpringFlix.SpringFlix.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "streaming")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StreamingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
