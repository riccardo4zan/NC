<%@page import="com.lowagie.text.Chunk"%>
<%@page import="com.lowagie.text.pdf.PdfPCell"%>
<%@page import="com.lowagie.text.pdf.PdfPTable"%>
<%@page import="nc.model.Pezzo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.lowagie.text.Font"%>
<%@page import="com.lowagie.text.Paragraph"%>
<%@page import="com.lowagie.text.DocumentException"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="com.lowagie.text.Document"%>
<%
    Document document = new Document();
    try {
        int min = Integer.parseInt(request.getParameter("min"));
        int max = Integer.parseInt(request.getParameter("max"));
        String cat = request.getParameter("cat");
        response.setContentType("application/pdf");
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font titolo = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
        Font caption = new Font(Font.TIMES_ROMAN, 14, Font.ITALIC);
        Font tabella = new Font(Font.TIMES_ROMAN, 14, Font.BOLD);
        document.add(new Paragraph("Report Produzione", titolo));
        document.add(new Paragraph("Generated on " + Calendar.getInstance().getTime().toString(), caption));
        PdfPTable table = new PdfPTable(2);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        document.add(new Chunk("  "));
        PdfPCell cell1 = new PdfPCell(new Paragraph("ID pezzo", tabella));
        PdfPCell cell2 = new PdfPCell(new Paragraph("Categoria", tabella));
        table.addCell(cell1);
        table.addCell(cell2);
        for (int i = min; i < max; i++) {
            table.addCell(new PdfPCell(new Paragraph(i+"")));
            table.addCell(new PdfPCell(new Paragraph(cat)));
        }
        document.add(table);

    } catch (DocumentException de) {
        de.printStackTrace();
        System.err.println("document: " + de.getMessage());
    }
    document.close();
%>