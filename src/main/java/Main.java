import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String inputPath = pathCreator("/Users/ksusha/Desktop/test", "vasya.jpg");
        String outputPath = pathCreator("/Users/ksusha/Desktop/test", "vasya_changed.jpg");
        resize(inputPath, outputPath, 0.25);

        // взять много картинок и для каждой запустить функцию сжатия

    }


    public static void resize(String inputImagePath,
                              String outputImagePath, double kfc)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        //takes values depended on the kfc
        int scaledHeight = (int) (inputImage.getHeight() * kfc);
        int scaledWidth = (int) (inputImage.getWidth() * kfc);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);

        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }

    public static String pathCreator(String path, String name) {
        if (path == null || name == null) {
            return "It looks that something bad is going to be!";
        }
        return path + name;
    }
}
