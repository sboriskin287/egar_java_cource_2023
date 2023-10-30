package ru.egartech.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "profiles")
@Data
@NamedQuery(name = "search", query = "SELECT p FROM Profile p " +
        "WHERE (:id is null OR p.id = :id) " +
        "AND ((:firstNames) is null OR p.firstName IN :firstNames) " +
        "AND (:lastName is null OR p.lastName = :lastName) " +
        "AND (:age is null OR p.age = :age)")
@ToString(exclude = {"address", "tasks", "showrooms", "taskInfo"})
@Accessors(chain = true)
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "executor")
    @MapKey(name = "name")
    @Where(clause = "name like '%Помпеи%'")
    private Map<String, Task> tasks = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "tasks", joinColumns = @JoinColumn(name = "profile_id"))
    @MapKeyColumn(name = "name")
    @Column(name = "description")
    private Map<String, String> taskInfo = new HashMap<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "profile_showroom",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "showroom_id"))
    private List<Showroom> showrooms = new LinkedList<>();
}
