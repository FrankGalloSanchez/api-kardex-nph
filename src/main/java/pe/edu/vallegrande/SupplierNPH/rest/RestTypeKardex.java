package pe.edu.vallegrande.SupplierNPH.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.SupplierNPH.model.TypeKardex;
import pe.edu.vallegrande.SupplierNPH.service.TypeKardexService;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/NPH/type-kardex")
public class RestTypeKardex {

    @Autowired
    private TypeKardexService service;

    // Listar todos los registros
    @GetMapping("/list-all")
    public Flux<TypeKardex> listAll() {
        return service.listAll();
    }

    // Listar solo los registros activos
    @GetMapping("/list")
    public Flux<TypeKardex> listActive() {
        return service.listActive();
    }

    // Crear un nuevo TypeKardex
    @PostMapping("/create")
    public Mono<TypeKardex> create(@RequestBody TypeKardex typeKardex) {
        return service.create(typeKardex);
    }

    // Editar un TypeKardex existente
    @PutMapping("/edit/{id}")
    public Mono<TypeKardex> update(@PathVariable Long id, @RequestBody TypeKardex typeKardex) {
        return service.update(id, typeKardex);
    }

    // Eliminar lógicamente (cambia el estado a "I")
    @PutMapping("/delete-logical/{id}")
    public Mono<Void> deleteLogical(@PathVariable Long id) {
        return service.deleteLogical(id);
    }

    // Eliminar físicamente
    @DeleteMapping("/delete-physical/{id}")
    public Mono<Void> deletePhysical(@PathVariable Long id) {
        return service.deletePhysical(id);
    }

    // Restaurar (cambia el estado a "A")
    @PutMapping("/restore/{id}")
    public Mono<Void> restore(@PathVariable Long id) {
        return service.restore(id);
    }
}
