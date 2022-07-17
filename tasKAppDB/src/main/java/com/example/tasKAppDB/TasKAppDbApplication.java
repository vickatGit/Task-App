package com.example.tasKAppDB;

import com.example.tasKAppDB.Dao.TaskListDao;
import com.example.tasKAppDB.Model.Task;
import com.example.tasKAppDB.Model.TaskList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.example.tasKAppDB.Repository")
public class TasKAppDbApplication {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context=SpringApplication.run(TasKAppDbApplication.class, args);
		TaskListDao taskListDao=context.getBean(TaskListDao.class);
//		TaskList taskList=new TaskList("TaskList 1","Description of TaskList 1",true);
//		List<Task> tasks=new ArrayList<>();
//		tasks.add(new Task(taskList,"task1","description 1",new Date(),"month","monthly"));
//		tasks.add(new Task(taskList,"task2","description 2",new Date(),"month","monthly"));
//		taskList.setTasks(tasks);
//		taskListDao.addTaskList(taskList);
	}

}
