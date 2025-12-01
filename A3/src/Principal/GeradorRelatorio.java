package Principal;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.util.List;
import Model.Produto;

public class GeradorRelatorio {
    public static void gerarRelatorioProdutos(String caminhoArquivo, List<Produto> listaProdutos) {
        Document document = new Document();
        double valorTotalEstoque = 0.0;
        
        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
            Paragraph titulo = new Paragraph("RELATÓRIO DE ESTOQUE DE PRODUTOS", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            PdfPTable tabela = new PdfPTable(4);
            tabela.setWidthPercentage(100);
            tabela.setSpacingBefore(10f);

            String[] cabecalhos = {"ID", "NOME", "PREÇO", "ESTOQUE"};
            for (String cab : cabecalhos) {
                PdfPCell cell = new PdfPCell(new Phrase(cab, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabela.addCell(cell);
            }

            for (Produto p : listaProdutos) {
                tabela.addCell(String.valueOf(p.getId()));
                tabela.addCell(p.getNome());
                
                String precoFormatado = String.format("R$ %.2f", p.getPreco());
                PdfPCell cellPreco = new PdfPCell(new Phrase(precoFormatado));
                cellPreco.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinha o preço à direita
                tabela.addCell(cellPreco);
                
                tabela.addCell(String.valueOf(p.getQuantEstq()));
                
                valorTotalEstoque += (p.getPreco() * p.getQuantEstq()); // <-- Adicionado: Acumula o valor total
            }

            document.add(tabela);
            
            java.text.NumberFormat formatadorMoeda = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("pt", "BR"));
            String totalFormatado = formatadorMoeda.format(valorTotalEstoque);

            Font fontTotal = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
            
            Paragraph totalParagraph = new Paragraph("\nValor Total do Estoque: " + totalFormatado, fontTotal);
            totalParagraph.setAlignment(Element.ALIGN_RIGHT); // Alinha o texto à direita
            totalParagraph.setSpacingBefore(15f);

            document.add(totalParagraph);
            
            javax.swing.JOptionPane.showMessageDialog(null, "Relatório PDF gerado com sucesso em: " + caminhoArquivo);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao gerar PDF: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }

}