package org.projects.msvc_users.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email
    private String email;

    private String password;

    private String phone;

    private String address;

    private String document;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "birth_date")
    private Date birthDate;

    private boolean status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "status_updated_at")
    private Date statusUpdatedAt;

    @Column(name = "data_updated_at")
    private Date dataUpdatedAt;

    @Column(name = "tutor_id")
    private Long tutorId;

    @Column(name = "agreement_id", insertable=false, updatable=false)
    private Long agreementId;

    @ManyToOne
    @JoinColumn(name = "tutor_id",insertable=false, updatable=false)
    private UserEntity tutor;

    @ManyToOne
    @JoinColumn(name = "agreement_id")
    private AgreementEntity agreement;
}
