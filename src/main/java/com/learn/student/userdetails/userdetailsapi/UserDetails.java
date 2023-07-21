package com.learn.student.userdetails.userdetailsapi;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String firstname;
   private String username;
   private String password;
   private String status;
   private String email;
   private int details;
   private String institution;
   private String role;
}
