package com.vipul.Vipul.pos.system.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name= "tbl_profiles")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private Boolean isActive;
    @Column(unique = true)
    private String email;
    private String profileImageUrl;
    private String password;
    @Column(unique = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String activationToken;

    @PrePersist
    public void prePersist(){
        if(this.isActive==null){
            isActive = false;
        }
    }
}
