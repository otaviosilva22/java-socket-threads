# Aplicação de Threads e Socket em Java.

Uso de threads em Java para transformar em escala de cinza uma imagem enviada do cliente para o servidor através de sockets.


<h2> Tecnologias Utilizadas </h2>

- [Java](https://www.java.com/pt-BR/)

<h2> Threads </h2>

A imagem foi dividida em 4 threads, sendo que cada uma dessas transformava cada pixel em escala de cinza.
```
for (int x = larguraInicial; x<this.larguraFinal; x++){
    for (int y = this.alturaInicial; y<this.alturaFinal; y++){
        Color pixel = new Color(this.imagem.getRGB(x, y));

        int corPixel = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;

        this.imagem.setRGB(x, y, new Color(corPixel, corPixel, corPixel).getRGB());
    }
}

try {
    ImageIO.write(this.imagem, "JPG", new File("imagensResultantes/imgGrayscale.jpg"));
} catch (IOException ex) {
    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
}
```



<h2> Contato </h2>

[![Linkedin Badge](https://img.shields.io/badge/-Otávio-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/otaviosilva22/)](https://www.linkedin.com/in/otaviosilva22/)
[![Gmail Badge](https://img.shields.io/badge/-otavio.ssilva22@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:otavio.ssilva22@gmail.com)](mailto:otavio.ssilva22@gmail.com)



