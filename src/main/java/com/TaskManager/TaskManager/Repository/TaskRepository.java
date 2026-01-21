package com.TaskManager.TaskManager.Repository;

import com.TaskManager.TaskManager.Model.Enum.Prioridade;
import com.TaskManager.TaskManager.Model.Enum.Status;
import com.TaskManager.TaskManager.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByAtivoTrue();

    List<Task> findByPtatus(Status status);

    List<Task> findByPrioridade(Prioridade prioridade);


}
