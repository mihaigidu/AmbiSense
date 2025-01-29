package com.ambiSense.AmbiSense.controller;
import com.ambiSense.AmbiSense.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/csv")
public class CsvController {

    @Autowired
    private CsvService csvService;

    @PostMapping("/upload")
    public ResponseEntity<String> subirCsv(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Por favor sube un archivo CSV.");
        }

        try {
            csvService.cargarDatosDesdeCSV(file);
            return ResponseEntity.ok("Archivo CSV procesado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al procesar el archivo CSV: " + e.getMessage());
        }
    }
}