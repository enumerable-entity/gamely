package host.enumerableentity.gamely.games.service;

import feign.Response;
import host.enumerableentity.gamely.commons.dto.WalkthroughDTO;
import host.enumerableentity.gamely.games.clients.ExportClient;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExportService {

    private final WalkthroughService walkthroughService;
    private final ExportClient exportClient;


    public void getExportedFile(HttpServletResponse response) throws IOException {
        List<WalkthroughDTO> allWalkthroughes = walkthroughService.getAllWalkthroughesForUser();
        Response xls = exportClient.getXls(allWalkthroughes);
        response.getOutputStream().write(xls.body().asInputStream().readAllBytes());
        response.getOutputStream().close();
    }
}
