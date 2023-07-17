package com.learn.student.userdetails.userdetailsapi;

import com.learn.student.userdetails.usersearchapi.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsService {
    private DetailsRepository detailsRepository;

    @Autowired
    public DetailsService(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    public UserDetails searchUser(Integer details) {
        UserDetails userDetails = detailsRepository.findByDetails(details);
        if (userDetails != null) {
            return userDetails;
        }
        return null;
    }
}

