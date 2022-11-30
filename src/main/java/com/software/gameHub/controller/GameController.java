package com.software.gameHub.controller;


import com.software.gameHub.entity.dto.CreateGameRequest;
import com.software.gameHub.entity.dto.GameDto;


import com.software.gameHub.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/create")
    public ResponseEntity<GameDto> createGame( @RequestBody CreateGameRequest request){
        return new ResponseEntity<>(gameService.createGame(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/gameId")
    public ResponseEntity<Void> delete(@RequestParam("gameId") int gameId){
        gameService.delete(gameId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{gameId}")
    public ResponseEntity<GameDto> findById(@PathVariable int gameId){
        return new ResponseEntity<>(gameService.getById(gameId),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<GameDto>> findGameByCategories_CategoryIdIn(@RequestParam("categoriesId") List<Integer> categoriesId){
        return new ResponseEntity<>(gameService.findGameByCategories_CategoryIdIn(categoriesId),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GameDto>> getAll(){
        return new ResponseEntity<>(gameService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/getByNameStartingWith")
    public ResponseEntity<List<GameDto>> findByNameStartingWith(@RequestParam("name") String name){
        return new ResponseEntity<>(gameService.findByNameStartingWith(name),HttpStatus.OK);
    }

    @GetMapping("/getByNameContaining")
    public ResponseEntity<List<GameDto>> findByNameContaining(@RequestParam("name") String name){
        return new ResponseEntity<>(gameService.findByNameContaining(name),HttpStatus.OK);
    }

    @GetMapping("/getByOrderByName")
    public ResponseEntity<List<GameDto>> findByOrderByName(){
        return new ResponseEntity<>(gameService.findByOrderByName(),HttpStatus.OK);
    }

    @GetMapping("/getByOrderByNameDesc")
    public ResponseEntity<List<GameDto>> findByOrderByNameDesc(){
        return new ResponseEntity<>(gameService.findByOrderByNameDesc(),HttpStatus.OK);
    }

    @GetMapping("/getByOrderByPrice")
    public ResponseEntity<List<GameDto>> findByOrderByPrice(){
        return new ResponseEntity<>(gameService.findByOrderByPrice(),HttpStatus.OK);
    }

    @GetMapping("/getByOrderByPriceDesc")
    public ResponseEntity<List<GameDto>> findByOrderByPriceDesc(){
        return new ResponseEntity<>(gameService.findByOrderByPriceDesc(),HttpStatus.OK);
    }
}
