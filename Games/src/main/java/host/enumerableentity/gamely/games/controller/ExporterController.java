package host.enumerableentity.gamely.games.controller;

import host.enumerableentity.gamely.commons.dto.WalkthroughDTO;
import host.enumerableentity.gamely.games.service.ExportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static host.enumerableentity.gamely.games.commons.ServiceConstants.API_PREFIX;

@Tag(name = "User walkthrough exporter", description = "Controller for export to user walkthroughs list")
@Slf4j
@RestController
@RequestMapping(API_PREFIX + "/export")
@RequiredArgsConstructor
public class ExporterController {

    private final ExportService exporterService;

    @Operation(summary = "Get XLS file with user walkthroughs")
    @GetMapping
    public void getXls(HttpServletResponse response) throws IOException {
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"walkthrough.xlsx\"");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setHeader(HttpHeaders.EXPIRES, "0");
        response.setContentType("application/vnd.ms-excel");
        exporterService.getExportedFile(response);
    }

}
