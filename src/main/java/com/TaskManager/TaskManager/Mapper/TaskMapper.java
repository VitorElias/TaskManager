package com.TaskManager.TaskManager.Mapper;

import com.TaskManager.TaskManager.DTO.TaskRequestDTO;
import com.TaskManager.TaskManager.DTO.TaskResponseDTO;
import com.TaskManager.TaskManager.Model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {


    public Task toTask(TaskRequestDTO dto){

        Task task = new Task();

        task.setDescricao(dto.getDescricao());
        task.setTitulo(dto.getTitulo());
        task.setPrioridade(dto.getPrioridade());

        return task;
    }

    public TaskResponseDTO toDto(Task task){

        return new TaskResponseDTO(
                task.getId(),
                task.getTitulo(),
                task.getDescricao(),
                task.getPtatus(),
                task.getPrioridade(),
                task.isAtivo(),
                task.getDataCriacao(),
                task.getDataConclusao()
        );
    }

    public List<TaskResponseDTO> toListDto(List<Task> tasks){

        List<TaskResponseDTO> task = new ArrayList<>();

        for(Task t : tasks){
            task.add(this.toDto(t));
        }
        return task;
    }

}
