package mx.edu.utez.unimor.unimor.categoria.controller;



import mx.edu.utez.unimor.unimor.categoria.model.Categoria;
import mx.edu.utez.unimor.unimor.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = {"*"})
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id) {
        return categoriaService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> createCategory(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.save(new Categoria(categoriaDTO.getDescription(),categoriaDTO.getEmpresas()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCategory(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.update(new Categoria(categoriaDTO.getIdCategoria(), categoriaDTO.getDescription(),categoriaDTO.getEmpresas()));
    }
}
