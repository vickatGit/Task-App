package com.example.tasKAppDB;

import com.example.tasKAppDB.Dao.TaskListDao;
import com.example.tasKAppDB.Model.Task;
import com.example.tasKAppDB.Model.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class TasKAppDbApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	TaskListDao taskListDao;

	@Test
	void addTaskList(){
		TaskList taskList=new TaskList("TaskList 1","Description of TaskList 1",true);
		List<Task> tasks=new ArrayList<>();
		tasks.add(new Task(taskList,"task1","description 1",new Date().toString(),"month","monthly"));
		tasks.add(new Task(taskList,"task2","description 2",new Date().toString(),"month","monthly"));
		taskList.setTasks(tasks);
		taskListDao.addTaskList(taskList);

	}

}
