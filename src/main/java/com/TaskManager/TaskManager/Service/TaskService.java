package com.TaskManager.TaskManager.Service;

import com.TaskManager.TaskManager.DTO.TaskRequestDTO;
import com.TaskManager.TaskManager.DTO.TaskResponseDTO;
import com.TaskManager.TaskManager.Mapper.TaskMapper;
import com.TaskManager.TaskManager.Model.Enum.Status;
import com.TaskManager.TaskManager.Model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private TaskMapper taskMapper;

    private List<Task> tasks = new ArrayList<Task>();

    private AtomicLong al = new AtomicLong(0);

    TaskService(TaskMapper tm){
        this.taskMapper = tm;
    }

    public TaskResponseDTO create(TaskRequestDTO taskDto){

        Task task = new Task(al.addAndGet(1),taskDto.getTitulo(),
                taskDto.getDescricao(),
                Status.PENDENTE,
                taskDto.getPrioridade(),
                taskDto.getDataConclusao());

        tasks.add(task);

        return taskMapper.toDto(task);
    }

}
