package org.tokenizer2.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@WebServlet(name = "show_pdf", urlPatterns = { "/show_pdf" })
@MultipartConfig // 👈 important
public class Pdf_creator extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract fields from FormData
        Part resultPart = request.getPart("similarity");
        Part resultPart2 = request.getPart("commonWords");
        
        String result = new String(resultPart.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        String result2 = new String(resultPart2.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

       
        // Set response type to PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=similarity_report.pdf");

        // Write PDF directly to response output stream
        PdfWriter respWriter = new PdfWriter(response.getOutputStream());
        PdfDocument pdfResp = new PdfDocument(respWriter);
        Document docResp = new Document(pdfResp);

        docResp.add(new Paragraph("Plagiarism Detection Report"));
        docResp.add(new Paragraph("------------------------------"));
        docResp.add(new Paragraph("similarity"+result));
        docResp.add(new Paragraph("common words"+result2));

        docResp.close();

        System.out.println("PDF generated and sent to client.");
    }
}
