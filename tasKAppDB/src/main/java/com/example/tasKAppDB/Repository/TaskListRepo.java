package com.example.tasKAppDB.Repository;

import com.example.tasKAppDB.Model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskListRepo extends JpaRepository<TaskList,Integer> {

}
