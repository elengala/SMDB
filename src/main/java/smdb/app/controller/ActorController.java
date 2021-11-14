package smdb.app.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import smdb.app.domain.Actor;
import smdb.app.service.BaseService;
import smdb.app.service.ActorService;
import smdb.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorController extends AbstractController<Actor> {
    private final ActorService actorService;

    @Override
    public BaseService<Actor, Long> getBaseService() {
        return actorService;
    }
/*    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<List<Actor>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<Actor>>builder().data(getBaseService().findAll()).build());
    }*/
/*    @GetMapping("/actors")
    public ResponseEntity<ApiResponse<List<Actor>>> findAll() {
        List<Actor> all = actorService.findAll();
        return ResponseEntity.ok(ApiResponse.<JsonNode>builder().data(all).build());
    }*/

/*    @GetMapping(params = "lastname")
    public ResponseEntity<ApiResponse<Actor>> findBySerial(@RequestParam("serial") String lastname) {
        return ResponseEntity.ok(ApiResponse.<Actor>builder().data(actorService.findByLastName(lastname)).build());
    }*/

}

