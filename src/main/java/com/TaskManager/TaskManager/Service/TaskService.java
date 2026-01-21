package com.TaskManager.TaskManager.Service;

import com.TaskManager.TaskManager.DTO.TaskRequestDTO;
import com.TaskManager.TaskManager.DTO.TaskResponseDTO;
import com.TaskManager.TaskManager.Exceptions.Exceptions.NotFound;
import com.TaskManager.TaskManager.Mapper.TaskMapper;
import com.TaskManager.TaskManager.Model.Enum.Prioridade;
import com.TaskManager.TaskManager.Model.Enum.Status;
import com.TaskManager.TaskManager.Model.Task;
import com.TaskManager.TaskManager.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private TaskMapper taskMapper;


    TaskService(TaskMapper tm, TaskRepository tr){
        this.taskMapper = tm;
        this.taskRepository = tr;
    }

    @Transactional
    public TaskResponseDTO create(TaskRequestDTO taskDto){
        Task task = new Task(taskDto.getTitulo(),
                taskDto.getDescricao(),
                Status.PENDENTE,
                taskDto.getPrioridade(),
                taskDto.getDataConclusao());
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    public List<TaskResponseDTO> listAll(){
        return taskMapper.toListDto(taskRepository.findAll());
    }

    public List<TaskResponseDTO> listAllAtivo() {
        return taskMapper.toListDto(taskRepository.findByAtivoTrue());
    }

    public List<TaskResponseDTO> atrasadas(){
        return taskMapper.toListDto(taskRepository.findByPtatus(Status.ATRASADA));
    }

    public List<TaskResponseDTO> listByStatus(Status status){
        return taskMapper.toListDto(taskRepository.findByPtatus(status));
    }

    public List<TaskResponseDTO> listByPrioridade(Prioridade prioridade){
        return taskMapper.toListDto(taskRepository.findByPrioridade(prioridade));
    }

    public TaskResponseDTO findById(Long id){

        Optional<Task> taskOpt = taskRepository.findById(id);

        if(taskOpt.isEmpty()) throw new NotFound("Não foi encontrado no banco de dados");

        Task t = taskOpt.get();

        return taskMapper.toDto(t);
    }

    public Task findByIdTask(Long id){
        Optional<Task> taskOpt = taskRepository.findById(id);

        if(taskOpt.isEmpty()) throw new NotFound("Não foi encontrado no banco de dados");

        return taskOpt.get();
    }

    @Transactional
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO tak2){

        Task t = findByIdTask(id);

        if(tak2.getPrioridade() != null) t.setPrioridade(tak2.getPrioridade());
        if(tak2.getTitulo() != null || !tak2.getTitulo().trim().isEmpty()) t.setTitulo(tak2.getTitulo());
        if(tak2.getDescricao() != null || !tak2.getDescricao().trim().isEmpty()) t.setDescricao(tak2.getDescricao());
        if(tak2.getDataConclusao() != null) t.setDataConclusao(tak2.getDataConclusao());

        return taskMapper.toDto(t);
    }

    @Transactional
    public String updateStatus(Long id, Status stats){

        Task t = this.findByIdTask(id);

        t.setPtatus(stats);
        return "A tarefa com o Titulo "+t.getTitulo()+" está com o status: "+stats.getDescricao();
    }

    @Transactional
    public String concluido(Long id){

        Task t = this.findByIdTask(id);
        t.setPtatus(Status.CONCLUIDA);

        return "A tarefa foi Concluida com sucesso";
    }

    @Transactional
    public String DesativarTarefa(Long id){

        Task t = this.findByIdTask(id);

        if(!t.isAtivo()) return "A tarefa com o id = "+t.getId()+" já foi deletada";

        t.setAtivo(false);

        return "A tarefa com o id = "+t.getId()+"Foi deletada";
    }

    @Transactional
    public String ativarTarefa(Long id){

        Task t = this.findByIdTask(id);

        if(t.isAtivo()) return "A tarefa com o id = "+t.getId()+" já está ativo";
        t.setAtivo(true);

        return "A tarefa com o id = "+t.getId()+"Foi ativada";
    }

    public String estatisticas(){

        int total = this.listAll().size();
        int pendentes = this.listByStatus(Status.PENDENTE).size();
        int concluidas = this.listByStatus(Status.CONCLUIDA).size();
        int atrasadas = this.atrasadas().size();

        return "Informações Estatisticas \n Total = "+total+"\n Pendentes: "+pendentes+"\n Concluidas: "+concluidas+"\n Atrasadas: "+atrasadas;
    }



}
