import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Lớp kiểm thử đơn vị cho StudentAnalyzer
 */
@DisplayName("Student Analyzer Test Suite")
public class StudentAnalyzerTest {
    
    private StudentAnalyzer analyzer;
    
    @BeforeEach
    public void setUp() {
        analyzer = new StudentAnalyzer();
    }
    
    // ========== TEST CHO countExcellentStudents() ==========
    
    @Test
    @DisplayName("Test đếm học sinh giỏi - Trường hợp bình thường")
    public void testCountExcellentStudents_NormalCase() {
        // Danh sách có 2 học sinh giỏi: 9.0 và 8.5
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 6.5, 5.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }
    
    @Test
    @DisplayName("Test đếm học sinh giỏi - Có điểm không hợp lệ")
    public void testCountExcellentStudents_WithInvalidScores() {
        // Có 2 học sinh giỏi (9.0, 8.5), bỏ qua 11.0 và -1.0
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }
    
    @Test
    @DisplayName("Test đếm học sinh giỏi - Danh sách rỗng")
    public void testCountExcellentStudents_EmptyList() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }
    
    @Test
    @DisplayName("Test đếm học sinh giỏi - Danh sách null")
    public void testCountExcellentStudents_NullList() {
        assertEquals(0, analyzer.countExcellentStudents(null));
    }
    
    @Test
    @DisplayName("Test đếm học sinh giỏi - Điểm biên 8.0")
    public void testCountExcellentStudents_BoundaryValue8() {
        // 8.0 đúng là giỏi
        List<Double> scores = Arrays.asList(8.0, 7.9);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }
    
    @Test
    @DisplayName("Test đếm học sinh giỏi - Điểm biên 10.0 và 0.0")
    public void testCountExcellentStudents_BoundaryValues() {
        List<Double> scores = Arrays.asList(10.0, 8.0, 0.0, 5.0);
        assertEquals(2, analyzer.countExcellentStudents(scores)); // 10.0 và 8.0
    }
    
    @Test
    @DisplayName("Test đếm học sinh giỏi - Toàn bộ điểm không hợp lệ")
    public void testCountExcellentStudents_AllInvalidScores() {
        List<Double> scores = Arrays.asList(-5.0, 15.0, -1.0, 11.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }
    
    @Test
    @DisplayName("Test đếm học sinh giỏi - Toàn bộ học sinh giỏi")
    public void testCountExcellentStudents_AllExcellent() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 10.0, 8.0);
        assertEquals(4, analyzer.countExcellentStudents(scores));
    }
    
    // ========== TEST CHO calculateValidAverage() ==========
    
    @Test
    @DisplayName("Test tính điểm trung bình - Trường hợp bình thường")
    public void testCalculateValidAverage_NormalCase() {
        // Trung bình của 9.0, 8.5, 7.0 = 24.5/3 = 8.166...
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01);
    }
    
    @Test
    @DisplayName("Test tính điểm trung bình - Có điểm không hợp lệ")
    public void testCalculateValidAverage_WithInvalidScores() {
        // Chỉ tính 9.0, 8.5, 7.0 (bỏ qua 11.0 và -1.0)
        // Trung bình = 24.5/3 = 8.166...
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01);
    }
    
    @Test
    @DisplayName("Test tính điểm trung bình - Danh sách rỗng")
    public void testCalculateValidAverage_EmptyList() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()));
    }
    
    @Test
    @DisplayName("Test tính điểm trung bình - Danh sách null")
    public void testCalculateValidAverage_NullList() {
        assertEquals(0.0, analyzer.calculateValidAverage(null));
    }
    
    @Test
    @DisplayName("Test tính điểm trung bình - Chỉ có giá trị 0")
    public void testCalculateValidAverage_OnlyZero() {
        List<Double> scores = Arrays.asList(0.0, 0.0, 0.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores));
    }
    
    @Test
    @DisplayName("Test tính điểm trung bình - Chỉ có giá trị 10")
    public void testCalculateValidAverage_OnlyTen() {
        List<Double> scores = Arrays.asList(10.0, 10.0, 10.0);
        assertEquals(10.0, analyzer.calculateValidAverage(scores));
    }
    
    @Test
    @DisplayName("Test tính điểm trung bình - Giá trị biên 0 và 10")
    public void testCalculateValidAverage_BoundaryValues() {
        // Trung bình của 0.0 và 10.0 = 5.0
        List<Double> scores = Arrays.asList(0.0, 10.0);
        assertEquals(5.0, analyzer.calculateValidAverage(scores));
    }
    
    @Test
    @DisplayName("Test tính điểm trung bình - Toàn bộ điểm không hợp lệ")
    public void testCalculateValidAverage_AllInvalidScores() {
        List<Double> scores = Arrays.asList(-5.0, 15.0, -1.0, 11.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores));
    }
    
    @Test
    @DisplayName("Test tính điểm trung bình - Một điểm hợp lệ")
    public void testCalculateValidAverage_SingleValidScore() {
        List<Double> scores = Arrays.asList(7.5);
        assertEquals(7.5, analyzer.calculateValidAverage(scores));
    }
    
    @Test
    @DisplayName("Test tính điểm trung bình - Điểm chính xác")
    public void testCalculateValidAverage_ExactCalculation() {
        // Trung bình của 5.0, 6.0, 7.0, 8.0 = 26.0/4 = 6.5
        List<Double> scores = Arrays.asList(5.0, 6.0, 7.0, 8.0);
        assertEquals(6.5, analyzer.calculateValidAverage(scores), 0.001);
    }
}

