package com.taskmanagement.TaskManagementService.TaskService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taskmanagement.TaskManagementService.model.Task;
import com.taskmanagement.TaskManagementService.repository.Taskrepository;
import com.taskmanagement.TaskManagementService.serviceimpl.TaskServiceImpl;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private Taskrepository taskRepo;

    @InjectMocks
    private TaskServiceImpl taskService;

   
    
//    @Test
//   void testCreateTask() {
//        Task taskToCreate = new Task();
//        taskToCreate.setTask("Sample Task");
//        when(taskRepo.save(any(Task.class))).thenReturn(new Task(1, "Sample Task","Mark","2023/11/23","OPEN"));
//
//        long createdTaskId = taskService.createTask(taskToCreate);
//
//        assertEquals(1L, createdTaskId);
//    }

//    @Test
//    void testUpdateTask() {
//        Task existingTask = new Task(1, "Sample Task","Mark","2023/11/23","OPEN");
//        Task updatedTask = new Task(1, "Sample Task","Mark","2023/11/23","Assigned");
//        when(taskRepo.save(any(Task.class))).thenReturn(updatedTask);
//        when(taskRepo.findById( anyLong() )).thenReturn(Optional.of(existingTask));
//       
//
//        Task result = taskService.updateTask(updatedTask);
//
//        assertEquals("Updated Task", result.getTask());
//    }


    @Test
    void testDeleteTask() {
        long taskIdToDelete = 1;
        doNothing().when(taskRepo).deleteById(taskIdToDelete);

        long deletedTaskId = taskService.deleteTask(taskIdToDelete);

        assertEquals(1L, deletedTaskId);
    }

    @Test
    void testGetAllTasks() {
        List<Task> expectedTasks = Arrays.asList(new Task(1, "Sample Task","Mark","2023/11/23","Assigned"), new Task(2, "Sample Task2","Peter","2023/11/23","Assigned"));
        when(taskRepo.findAll()).thenReturn(expectedTasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(expectedTasks, result);
    }

    @Test
    void testGetTaskById() {
        Task expectedTask = new Task(1, "Sample Task","Mark","2023/11/23","Assigned");
        when(taskRepo.findById(1L)).thenReturn(Optional.of(expectedTask));

        Task result = taskService.getTaskById(1);

        assertEquals(expectedTask, result);
    }
}
