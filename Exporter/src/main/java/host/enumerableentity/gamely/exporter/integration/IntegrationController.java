package host.enumerableentity.gamely.exporter.integration;

import host.enumerableentity.gamely.commons.dto.WalkthroughDTO;
import host.enumerableentity.gamely.exporter.service.interaface.ExportService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/integration")
@RequiredArgsConstructor
public class IntegrationController {
    private final ExportService<WalkthroughDTO> exporterService;

    @PostMapping
    public void getXls(@RequestBody List<WalkthroughDTO> walkthroughes, HttpServletResponse response) throws IOException {
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"walkthrough.xlsx\"");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setHeader(HttpHeaders.EXPIRES, "0");
        response.setContentType("application/vnd.ms-excel");
        exporterService.getExportedFile(walkthroughes, response);
    }

}
