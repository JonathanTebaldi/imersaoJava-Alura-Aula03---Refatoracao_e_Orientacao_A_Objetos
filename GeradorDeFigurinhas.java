package alura;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.net.URL;
public class GeradorDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {

        //leitura de imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal =  ImageIO.read(inputStream);

        //cria uma nova imagem em memória com tgransferência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra nova imagem( em memoria)
        Graphics2D graphics =  (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF,Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);



        //escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 0, novaAltura - 100);



        //escreve a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}

