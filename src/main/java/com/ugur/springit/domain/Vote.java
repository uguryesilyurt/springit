package com.ugur.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Vote {

    @Id @GeneratedValue
    private Long id;
    //private User user;
    //private Link link;
    private int vote;
}