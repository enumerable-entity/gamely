package host.enumerableentity.gamely.exporter.service;

import host.enumerableentity.gamely.commons.dto.WalkthroughDTO;
import host.enumerableentity.gamely.exporter.service.interaface.ExportService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ExportServiceImpl implements ExportService<WalkthroughDTO> {

    private final XSSFWorkbook workbook = new XSSFWorkbook();
    private final XSSFSheet sheet = workbook.createSheet("Walkthroughs");

    @Override
    public void getExportedFile(List<WalkthroughDTO> walkthroughes, HttpServletResponse response) throws IOException {
        fillHeaders();
        writeDataLines(walkthroughes);

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            response.getOutputStream().close();
        }
    }

    private void writeDataLines(List<WalkthroughDTO> walkthroughDTOS) {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (WalkthroughDTO w : walkthroughDTOS) {
            Row row = sheet.createRow(rowCount++);

            createCell(row, 0, w.gameId(), style);
            createCell(row, 1, w.date(), style);
            createCell(row, 2, w.duration().toString(), style);
            createCell(row, 3, w.pirated(), style);
            createCell(row, 4, w.externalUsernameCoop(), style);
            createCell(row, 5, w.userNotes(), style);
            createCell(row, 6, w.internalCoopUser() == null ? "" : w.internalCoopUser().id(), style);
            createCell(row, 7, w.platform().id(), style);

        }
    }



    private void fillHeaders() {
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Game Id", style);
        createCell(row, 1, "Date", style);
        createCell(row, 2, "Duration", style);
        createCell(row, 3, "Is pirated", style);
        createCell(row, 4, "Completed with user", style);
        createCell(row, 5, "User notes", style);
        createCell(row, 6, "Completed with internal user id", style);
        createCell(row, 7, "Platform", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if(value instanceof LocalDate){
            cell.setCellValue(((LocalDate) value).toString());
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
}
