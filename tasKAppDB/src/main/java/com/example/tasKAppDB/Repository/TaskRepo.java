package com.example.tasKAppDB.Repository;

import com.example.tasKAppDB.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface TaskRepo extends  JpaRepository<Task, Integer> {

    public List<Task> findByPeriod(String period);

    @Query("SELECT t FROM Task t INNER JOIN t.taskList l WHERE l.list_id=:listId")
    public List<Task> findTasksByListId(@Param("listId") Integer listId);


}