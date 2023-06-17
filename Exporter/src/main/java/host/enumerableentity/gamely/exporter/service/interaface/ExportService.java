package host.enumerableentity.gamely.exporter.service.interaface;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public interface ExportService<E> {

    void getExportedFile(List<E> walkthroughes, HttpServletResponse response) throws IOException;
}
