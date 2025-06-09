package Testing;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import org.testng.annotations.Test;

import java.io.IOException;

public class PDFTest {
    
    @Test
    void getTextFromPDF() {
        String filePath = "example.pdf"; // Update with your file path
        try (PdfDocument pdfDoc = new PdfDocument(new PdfReader(filePath))) {
            StringBuilder extractedText = new StringBuilder();
            for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {
                extractedText.append(PdfTextExtractor.getTextFromPage(pdfDoc.getPage(i))).append("\n");
            }
            System.out.println("Extracted Text: " + extractedText);
        } catch (IOException e) {
            System.out.println("Error reading PDF: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}