import java.util.List;

/**
 * Lớp phân tích điểm số học sinh
 */
public class StudentAnalyzer {
    
    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     * - Bỏ qua điểm âm hoặc lớn hơn 10 (coi là dữ liệu sai)
     * - Nếu danh sách rỗng, trả về 0
     */
    public int countExcellentStudents(List<Double> scores) {
        // Điều kiện 2: Nếu danh sách rỗng thì trả về 0
        if (scores == null || scores.isEmpty()) {
            return 0;
        }
        
        int count = 0;
        
        // Vòng lặp 1: Duyệt qua danh sách điểm để lọc học sinh giỏi
        for (Double score : scores) {
            // Điều kiện 1: Nếu điểm nhỏ hơn 0 hoặc lớn hơn 10 thì bỏ qua
            if (score == null || score < 0 || score > 10) {
                continue;
            }
            
            // Đếm học sinh giỏi (>= 8.0)
            if (score >= 8.0) {
                count++;
            }
        }
        
        return count;
    }

    /**
     * Tính điểm trung bình hợp lệ (từ 0 đến 10)
     * @param scores danh sách điểm
     * @return điểm trung bình của các điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        // Điều kiện 2: Nếu danh sách rỗng thì trả về 0
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        int validCount = 0;
        
        // Vòng lặp 2: Duyệt qua danh sách để tính trung bình hợp lệ
        for (Double score : scores) {
            // Điều kiện 1: Nếu điểm nhỏ hơn 0 hoặc lớn hơn 10 thì bỏ qua
            if (score == null || score < 0 || score > 10) {
                continue;
            }
            
            sum += score;
            validCount++;
        }
        
        // Tránh chia cho 0
        if (validCount == 0) {
            return 0.0;
        }
        
        return sum / validCount;
    }
}

