package com.TaskManager.TaskManager.Service;

import com.TaskManager.TaskManager.DTO.TaskRequestDTO;
import com.TaskManager.TaskManager.DTO.TaskResponseDTO;
import com.TaskManager.TaskManager.Exceptions.Exceptions.NotFound;
import com.TaskManager.TaskManager.Mapper.TaskMapper;
import com.TaskManager.TaskManager.Model.Enum.Prioridade;
import com.TaskManager.TaskManager.Model.Enum.Status;
import com.TaskManager.TaskManager.Model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<TaskResponseDTO> listAll(){

        List<TaskResponseDTO> lists = new ArrayList<>();
        for(Task taskDto : tasks) {
            lists.add(taskMapper.toDto(taskDto));
        }
        return lists;
    }

    public List<TaskResponseDTO> listAllAtivo(){

        List<TaskResponseDTO> lists = new ArrayList<>();
        for(Task taskDto : tasks){
            if(taskDto.isAtivo()) lists.add(taskMapper.toDto(taskDto));
        }
        return lists;
    }

    public List<TaskResponseDTO> atrasadas(){

        List<TaskResponseDTO> lists = new ArrayList<>();
        for(Task t : tasks){
            if(t.getDataConclusao().isBefore(LocalDateTime.now())) lists.add(taskMapper.toDto(t));
        }

        return lists;
    }

    public List<TaskResponseDTO> listByStatus(Status status){

        List<TaskResponseDTO> lists = new ArrayList<>();

        if(status == null) throw new NotFound("Status é nulo");

        for(Task taskDto : tasks){if(status.equals(taskDto.getPtatus())) lists.add(taskMapper.toDto(taskDto));}

        return lists;

    }

    public List<TaskResponseDTO> listByPrioridade(Prioridade prioridade){

        List<TaskResponseDTO> lists = new ArrayList<>();

        if(prioridade == null) throw new NotFound("Prioridade é nulo");

        for(Task taskDto : tasks){if(prioridade.equals(taskDto.getPrioridade())) lists.add(taskMapper.toDto(taskDto));}

        return lists;

    }

    public TaskResponseDTO findById(Long id){

        for(Task task2 : tasks){
            if(task2.getId().equals(id)) return taskMapper.toDto(task2);
        }

        throw new NotFound("Não foi encontrado no banco de dados");
    }

    public Task findByIdTask(Long id){
        for(Task task2 : tasks){if(task2.getId().equals(id)) return task2;}

        throw new NotFound("Não foi encontrado no banco de dados");
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO tak2){

        Task t = findByIdTask(id);

        if(tak2.getPrioridade() != null) t.setPrioridade(tak2.getPrioridade());
        if(tak2.getTitulo() != null || !tak2.getTitulo().trim().isEmpty()) t.setTitulo(tak2.getTitulo());
        if(tak2.getDescricao() != null || !tak2.getDescricao().trim().isEmpty()) t.setDescricao(tak2.getDescricao());
        if(tak2.getDataConclusao() != null) t.setDataConclusao(tak2.getDataConclusao());

        return taskMapper.toDto(t);
    }

    public String updateStatus(Long id, Status stats){

        Task t = this.findByIdTask(id);

        t.setPtatus(stats);
        return "A tarefa com o Titulo "+t.getTitulo()+" está com o status: "+stats.getDescricao();
    }

    public String concluido(Long id){

        Task t = this.findByIdTask(id);
        t.setPtatus(Status.CONCLUIDA);

        return "A tarefa foi Concluida com sucesso";
    }

    public String DesativarTarefa(Long id){

        Task t = this.findByIdTask(id);

        if(!t.isAtivo()) return "A tarefa com o id = "+t.getId()+" já foi deletada";

        t.setAtivo(false);

        return "A tarefa com o id = "+t.getId()+"Foi deletada";
    }

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
