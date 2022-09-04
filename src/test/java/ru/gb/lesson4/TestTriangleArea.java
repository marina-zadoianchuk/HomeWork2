package ru.gb.lesson4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class TestTriangleArea {
    private static final Logger logger = LoggerFactory.getLogger(TestTriangleArea.class);

    @Test
    @DisplayName("Проверка вычисления площади треугольника при величине сторон > 0")
    public void CalculatingTriangleArea() throws TriangleExeption {
        TringleArea triangle = new TringleArea(2, 2, 2);
      //  TringleArea triangle1 = new TringleArea(0, 2, 2);
       // Assertions.assertAll(
        Assertions.assertEquals(1.7320508075688772, triangle.getS());
    }
    @Test
    @DisplayName("Проверка появления исключения, когда одна из сторон = 0")
    public void ZeroTriangleArea() throws TriangleExeption {
        TringleArea triangle = new TringleArea(0, 2, 2);
        Assertions.assertThrows(TriangleExeption.class, triangle::getS);
        logger.debug("Проверка появления исключения, когда одна из сторон = 0");
    }
}
