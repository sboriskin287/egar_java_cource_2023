package org.example.profile.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "show_room")
@Data
public class ShowRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "profiles_show_room",
            joinColumns = @JoinColumn(name = "show_room_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id"))
    private List<Profile> profiles = new LinkedList<>();
}
