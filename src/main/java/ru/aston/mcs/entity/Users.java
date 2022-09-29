package ru.aston.mcs.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private GenderType gender;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "surname", length = 20, nullable = false)
    private String surname;
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;
    @Column(name = "email", length = 40, nullable = false)
    private String email;
    @Column(name = "address", length = 40, nullable = false)
    private String address;
    @Column(name = "pinkod", length = 8, nullable = false)
    private String code;
    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Resource> resourceId;
    @OneToOne
    @JoinColumn(name = "passport_number", nullable = false)
    private PassportData passportId;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Roles role;

}
