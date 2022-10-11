package com.axonactive.agileterm.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "topic")
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String color;
}
