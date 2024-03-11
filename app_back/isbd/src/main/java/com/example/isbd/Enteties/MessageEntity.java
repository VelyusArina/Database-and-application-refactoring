package com.example.isbd.Enteties;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import com.example.isbd.enumerations.Gender_enum;
import com.example.isbd.enumerations.Model_car;
import com.example.isbd.enumerations.Type_message_enum;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import com.example.isbd.Enteties.AutopartEntity;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "message")
public class MessageEntity {
    @Id
    @Column(name="id", columnDefinition = "serial")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(write = "?::type_message_enum")
    @Column(name = "type_message", columnDefinition = "type_message_enum", nullable = false)
    private Type_message_enum type_message;
    @Column(name="datetime_message")
    private java.sql.Timestamp datetime_message;
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private ChatEntity chat;
}