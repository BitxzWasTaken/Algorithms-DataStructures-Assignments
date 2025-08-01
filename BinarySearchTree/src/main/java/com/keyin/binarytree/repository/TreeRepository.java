package com.keyin.binarytree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.keyin.binarytree.model.TreeRecord;


public interface TreeRepository extends JpaRepository<TreeRecord, Long> {}