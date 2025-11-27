package Principal;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.util.List;
import Model.Produto;

public class GeradorRelatorio {
    public static void gerarRelatorioProdutos(String caminhoArquivo, List<Produto> listaProdutos) {
        Document document = new Document();
        
        try {
            // 1. Cria o escritor PDF (PdfWriter)
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // 2. Adiciona um Título
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
            Paragraph titulo = new Paragraph("RELATÓRIO DE ESTOQUE DE PRODUTOS", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            // 3. Cria a Tabela com 4 colunas
            PdfPTable tabela = new PdfPTable(4);
            tabela.setWidthPercentage(100);
            tabela.setSpacingBefore(10f);

            // 4. Adiciona Cabeçalho da Tabela
            String[] cabecalhos = {"ID", "NOME", "PREÇO", "ESTOQUE"};
            for (String cab : cabecalhos) {
                PdfPCell cell = new PdfPCell(new Phrase(cab, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabela.addCell(cell);
            }

            // 5. Preenche com Dados do Produto
            for (Produto p : listaProdutos) {
                tabela.addCell(String.valueOf(p.getId()));
                tabela.addCell(p.getNome());
                tabela.addCell("R$ " + String.format("%.2f", p.getPreco())); 
                tabela.addCell(String.valueOf(p.getQuantEstq()));
            }

            document.add(tabela);

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
