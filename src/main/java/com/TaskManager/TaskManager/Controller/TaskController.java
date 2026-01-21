package com.TaskManager.TaskManager.Controller;

import com.TaskManager.TaskManager.DTO.TaskRequestDTO;
import com.TaskManager.TaskManager.DTO.TaskResponseDTO;
import com.TaskManager.TaskManager.Model.Enum.Prioridade;
import com.TaskManager.TaskManager.Model.Enum.Status;
import com.TaskManager.TaskManager.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskResponseDTO>> listAll(){return ResponseEntity.ok().body(taskService.listAll());}

    @GetMapping("/ativo")
    public ResponseEntity<List<TaskResponseDTO>> listAlAtivo(){return ResponseEntity.ok().body(taskService.listAllAtivo());}

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskResponseDTO>> listByStatus(@PathVariable Status status){return ResponseEntity.ok().body(taskService.listByStatus(status));}

    @GetMapping("/prioridade/{prioridade}")
    public ResponseEntity<List<TaskResponseDTO>> listByPrioridade(@PathVariable Prioridade prioridade){return ResponseEntity.ok().body(taskService.listByPrioridade(prioridade));}

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id){return ResponseEntity.ok().body(taskService.findById(id));}

    @GetMapping("/estatisticas")
    public ResponseEntity<String> estatisticas(){return ResponseEntity.ok().body(taskService.estatisticas());}

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> update(@PathVariable Long id, @RequestBody TaskRequestDTO t){return ResponseEntity.ok().body(taskService.updateTask(id, t));}

    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestBody Status status){return ResponseEntity.ok().body(taskService.updateStatus(id,status));}

    @PostMapping("/")
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskRequestDTO task){return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(task));}

    @PutMapping("/concluido/{id}")
    public ResponseEntity<String> concluido(@RequestBody Long id){return ResponseEntity.ok().body(taskService.concluido(id));}

    @PutMapping("/ativar/{id}")
    public ResponseEntity<String> ativar(@RequestBody Long id){return ResponseEntity.ok().body(taskService.ativarTarefa(id));}

    @DeleteMapping("/desativar/{id}")
    public ResponseEntity<String> desativarTarefa(@PathVariable Long id){ return ResponseEntity.ok().body(taskService.DesativarTarefa(id));}
}
