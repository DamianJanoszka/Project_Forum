package com.example.myProject.forum.repository;

import com.example.myProject.forum.model.entity.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends JpaRepository<Thread,Long> {
}
