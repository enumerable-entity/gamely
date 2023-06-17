package host.enumerableentity.gamely.games.clients;

import feign.Response;
import host.enumerableentity.gamely.commons.dto.WalkthroughDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "games-exporter")
public interface ExportClient {

    @PostMapping("/integration")
    Response getXls(List<WalkthroughDTO> walkthroughes);
}
