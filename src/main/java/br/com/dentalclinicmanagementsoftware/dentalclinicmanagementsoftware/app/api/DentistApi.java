package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.DentistRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed.DentistDetailedResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.summary.DentistSummaryResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/dentists")
public interface DentistApi {

    @GetMapping
    ResponseEntity<Page<DentistSummaryResponse>> getAllDentists(@PageableDefault Pageable page);

    @PostMapping
    ResponseEntity<DentistDetailedResponse> addDentist(@RequestBody @Valid DentistRequest request);

    @GetMapping("{id}")
    ResponseEntity<DentistDetailedResponse> getDentistById(@PathVariable UUID id);

    @PatchMapping("{id}")
    ResponseEntity<DentistDetailedResponse> updateDentistById(@PathVariable UUID id, Map<String, Object> params);

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteDentistById(@PathVariable UUID id);

}
