package com.demo.jwt.persistence.entities;

import com.demo.jwt.common.helpers.TokenType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="_token", schema = "_authentication")
public class Token extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer tokenId;
    @Column(unique = true)
    public String token;
    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;
    public boolean revoked;
    public boolean expired;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnore
    public User user;
}
