package smdb.app.controller;

import org.springframework.http.ResponseEntity;
import smdb.app.domain.Film;
import smdb.app.service.BaseService;
import smdb.app.service.FilmService;
import smdb.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController extends AbstractController<Film> {
    private final FilmService filmService;

    @Override
    public BaseService<Film, Long> getBaseService() {
        return filmService;
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<List<Film>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<Film>>builder().data(getBaseService().findAll()).build());
    }
}

